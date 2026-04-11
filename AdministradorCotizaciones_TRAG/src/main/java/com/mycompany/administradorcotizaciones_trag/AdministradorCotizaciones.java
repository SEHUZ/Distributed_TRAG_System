package com.mycompany.administradorcotizaciones_trag;

import dtos.quote.QuoteUpdateDTO;
import dtos.quote.QuoteAddDTO;
import dtos.quote.QuoteDetailDTO;
import dtos.quote.QuoteSummaryDTO;
import dtos.quoteSupply.QuoteSupplyDetailDTO;
import Entitys.Quote;
import Enums.QuoteStatus;
import Exception.BusinessException;
import Exception.PersistenceException;
import Interfaces.IQuotesDAO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import mappers.DTOMappers;
import mappers.EntityMappers;

/**
 * Archivo: AdministradorCotizaciones.java
 * @author Ariel Eduardo Borbón Izaguirre - 253080
 * @author Sebastián Bórquez Huerta - 253080
 * @author Chris Fitch Lopez - 252379
 */
public class AdministradorCotizaciones {

    private IQuotesDAO cotizacionesDAO;

    private static final int MAX_LONGITUD_ESTADO = 1000;
    private static final BigDecimal PRECIO_MAXIMO = new BigDecimal("99999999.99");

    private static final String MENSAJE_ID_COTIZACION_AUSENTE_OBTENER = "El ID es necesario para obtener una cotización";
    private static final String MENSAJE_ID_COTIZACION_AUSENTE_ACTUALIZAR = "El ID es necesario para actualizar una cotización";
    private static final String MENSAJE_ID_COTIZACION_AUSENTE_ELIMINAR = "El ID es necesario para eliminar una cotización";

    private static final String MENSAJE_ERROR_CREAR_COTIZACION = "Error al crear la cotización";
    private static final String MENSAJE_ERROR_OBTENER_COTIZACION = "Error al obtener la cotización";
    private static final String MENSAJE_ERROR_OBTENER_TODAS_COTIZACIONES = "Error al obtener las cotizaciones";
    private static final String MENSAJE_ERROR_ACTUALIZAR_COTIZACION = "Error al actualizar la cotización";
    private static final String MENSAJE_ERROR_ELIMINAR_COTIZACION = "Error al eliminar la cotización";

    public AdministradorCotizaciones(IQuotesDAO cotizacionesDAO) {
        this.cotizacionesDAO = cotizacionesDAO;
    }

    public QuoteDetailDTO crearCotizacion(QuoteAddDTO dto) throws BusinessException {
        validarCotizacionAgregar(dto);
        Quote cotizacionRegistrada = DTOMappers.toEntity(dto);
        
        // Ensure default active status
        if (cotizacionRegistrada.getStatus() == null) {
            cotizacionRegistrada.setStatus(QuoteStatus.ENABLED);
        }

        try {
            Quote savedQuote = cotizacionesDAO.addQuote(cotizacionRegistrada);
            return mapToQuoteDetailDTO(savedQuote);
        } catch (PersistenceException e) {
            throw new BusinessException(MENSAJE_ERROR_CREAR_COTIZACION, e);
        }
    }

    public QuoteDetailDTO obtenerCotizacion(Long idCotizacion) throws BusinessException {
        if (idCotizacion == null) {
            throw new BusinessException(MENSAJE_ID_COTIZACION_AUSENTE_OBTENER);
        }

        try {
            Quote quote = cotizacionesDAO.getQuote(idCotizacion);
            if (quote == null) return null;
            return mapToQuoteDetailDTO(quote);
        } catch (PersistenceException e) {
            throw new BusinessException(MENSAJE_ERROR_OBTENER_COTIZACION, e);
        }
    }
    
    public QuoteSummaryDTO obtenerResumenCotizacion(Long idCotizacion) throws BusinessException {
        if (idCotizacion == null) {
            throw new BusinessException(MENSAJE_ID_COTIZACION_AUSENTE_OBTENER);
        }

        try {
            Quote quote = cotizacionesDAO.getQuote(idCotizacion);
            if (quote == null) return null;
            return mapToQuoteSummaryDTO(quote);
        } catch (PersistenceException e) {
            throw new BusinessException(MENSAJE_ERROR_OBTENER_COTIZACION, e);
        } 
    }

    public List<QuoteSummaryDTO> obtenerTodasCotizaciones() throws BusinessException {
        try {
            List<Quote> quotes = cotizacionesDAO.getAllQuotes();
            // Los mappers ahora calculan los totales y subtotales automáticamente!
            return quotes.stream().map(this::mapToQuoteSummaryDTO).collect(Collectors.toList());
        } catch (PersistenceException e) {
            throw new BusinessException(MENSAJE_ERROR_OBTENER_TODAS_COTIZACIONES, e);
        }
    }
    
    public List<QuoteSummaryDTO> obtenerCotizacionesPorIdsClientes(List<Long> customerIds) throws BusinessException {
        try {
            List<Quote> quotes = cotizacionesDAO.getQuotesByCustomerIds(customerIds);
            return quotes.stream().map(this::mapToQuoteSummaryDTO).collect(Collectors.toList());
        } catch (PersistenceException e) {
            throw new BusinessException(MENSAJE_ERROR_OBTENER_TODAS_COTIZACIONES, e);
        }
    }
    
    public List<QuoteSummaryDTO> obtenerCotizacionesFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin) throws BusinessException {
        try {
            List<Quote> quotes = cotizacionesDAO.getQuotesByDate(fechaInicio, fechaFin);
            return quotes.stream().map(this::mapToQuoteSummaryDTO).collect(Collectors.toList());
        } catch (PersistenceException e) {
            throw new BusinessException(MENSAJE_ERROR_OBTENER_TODAS_COTIZACIONES, e);
        }
    }

    public QuoteDetailDTO actualizarCotizacion(QuoteUpdateDTO dto) throws BusinessException {
        if (dto.getId() == null) {
            throw new BusinessException(MENSAJE_ID_COTIZACION_AUSENTE_ACTUALIZAR);
        }

        validarCotizacionActualizar(dto);
        dto.setCreatedAt(LocalDateTime.now());
        
        Quote cotizacionActualizar = DTOMappers.toEntity(dto);

        try {
            Quote updatedQuote = cotizacionesDAO.updateQuote(cotizacionActualizar);
            return mapToQuoteDetailDTO(updatedQuote);
        } catch (PersistenceException e) {
            throw new BusinessException(MENSAJE_ERROR_ACTUALIZAR_COTIZACION, e);
        }
    }

    public QuoteDetailDTO eliminarCotizacion(Long idCotizacion) throws BusinessException {
        if (idCotizacion == null) {
            throw new BusinessException(MENSAJE_ID_COTIZACION_AUSENTE_ELIMINAR);
        }

        try {
            Quote deletedQuote = cotizacionesDAO.deleteQuote(idCotizacion);
            return mapToQuoteDetailDTO(deletedQuote);
        } catch (PersistenceException e) {
            throw new BusinessException(MENSAJE_ERROR_ELIMINAR_COTIZACION, e);
        }
    }

    public QuoteDetailDTO habilitarCotizacion(Long idCotizacion) throws BusinessException {
        if(idCotizacion == null){
            throw new BusinessException("El id de la cotización no puede ser nulo.");
        }
        
        try {
            Quote enabledQuote = cotizacionesDAO.enableQuote(idCotizacion);
            return mapToQuoteDetailDTO(enabledQuote);
        } catch (PersistenceException e) {
            throw new BusinessException("Error al habilitar la cotización", e);
        }
    }

    // --- HELPER METHODS FOR SAFE MAPPING ---
    
    private QuoteDetailDTO mapToQuoteDetailDTO(Quote quote) {
        if (quote == null) return null;
        List<QuoteSupplyDetailDTO> supplyDTOs = new ArrayList<>();
        if(quote.getQuoteSupplies() != null) {
            supplyDTOs = quote.getQuoteSupplies().stream()
                .map(qs -> EntityMappers.toQuoteSupplyDetailDTO(qs, null))
                .collect(Collectors.toList());
        }
        return EntityMappers.toQuoteDetailDTO(quote, null, null, null, supplyDTOs);
    }

    private QuoteSummaryDTO mapToQuoteSummaryDTO(Quote quote) {
        if (quote == null) return null;
        List<QuoteSupplyDetailDTO> supplyDTOs = new ArrayList<>();
        if(quote.getQuoteSupplies() != null) {
            supplyDTOs = quote.getQuoteSupplies().stream()
                .map(qs -> EntityMappers.toQuoteSupplyDetailDTO(qs, null))
                .collect(Collectors.toList());
        }
        return EntityMappers.toQuoteSummaryDTO(quote, null, null, supplyDTOs);
    }

    // --- VALIDATORS ---

    private void validarCotizacionAgregar(QuoteAddDTO dto) throws BusinessException {
        if (dto == null) {
            throw new BusinessException("Los datos de la cotización no pueden ser nulos.");
        }
        validarPrecioManoObra(dto.getLaborPrice());
        validarEstadoAutomovil(dto.getVehicleStatus());
        validarDiagnosticoGeneral(dto.getGeneralDiagnosis());
    }

    private void validarCotizacionActualizar(QuoteUpdateDTO dto) throws BusinessException {
        if (dto == null) {
            throw new BusinessException("Los datos de la cotización no pueden ser nulos.");
        }
        validarPrecioManoObra(dto.getLaborPrice());
        validarEstadoAutomovil(dto.getVehicleStatus());
        validarDiagnosticoGeneral(dto.getGeneralDiagnosis());
    }

    private void validarPrecioManoObra(BigDecimal precioManoObra) throws BusinessException {
        if (precioManoObra == null || precioManoObra.compareTo(BigDecimal.ZERO) < 0) {
            throw new BusinessException("El precio de mano de obra no es válido, debe ser mayor o igual a 0.");
        }
        if (precioManoObra.compareTo(PRECIO_MAXIMO) > 0) {
            throw new BusinessException("El precio excede el límite permitido del sistema.");
        }
    }

    private void validarEstadoAutomovil(String estadoAutomovil) throws BusinessException {
        if (estadoAutomovil == null || estadoAutomovil.trim().isEmpty()) {
            throw new BusinessException("El estado del automóvil no puede estar vacío.");
        }
        if (estadoAutomovil.trim().length() > MAX_LONGITUD_ESTADO) {
            throw new IllegalArgumentException("La descripción del estado no puede superar los "
                    + MAX_LONGITUD_ESTADO + " caracteres.");
        }
    }

    private void validarDiagnosticoGeneral(String diagnosticoGeneral) throws BusinessException {
        if (diagnosticoGeneral == null || diagnosticoGeneral.trim().isEmpty()) {
            throw new BusinessException("El diagnóstico general es obligatorio para procesar la cotización.");
        }
    }
}