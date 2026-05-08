package com.mycompany.administradorcotizaciones_trag;

import dtos.quote.QuoteUpdateDTO;
import dtos.quote.QuoteAddDTO;
import dtos.quote.QuoteDetailDTO;
import dtos.quote.QuoteSummaryDTO;
import Exception.BusinessException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Archivo: IAdministradorCotizaciones.java
 * @author Ariel Eduardo Borbón Izaguirre - 253080
 * @author Sebastián Bórquez Huerta - 253080
 * @author Chris Fitch Lopez - 252379
 */
public interface IAdministradorCotizaciones {
    QuoteDetailDTO crearCotizacion(QuoteAddDTO dto) throws BusinessException;
    QuoteDetailDTO obtenerCotizacion(Long idCotizacion) throws BusinessException;
    QuoteSummaryDTO obtenerResumenCotizacion(Long idCotizacion) throws BusinessException;
    List<QuoteSummaryDTO> obtenerTodasCotizaciones() throws BusinessException;
    
    List<QuoteSummaryDTO> obtenerCotizacionesPorIdsClientes(List<Long> customerIds) throws BusinessException;
    
    List<QuoteSummaryDTO> obtenerCotizacionesFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin) throws BusinessException;
    QuoteDetailDTO actualizarCotizacion(QuoteUpdateDTO dto) throws BusinessException;
    QuoteDetailDTO eliminarCotizacion(Long idCotizacion) throws BusinessException;
    QuoteDetailDTO habilitarCotizacion(Long idCotizacion) throws BusinessException;
}