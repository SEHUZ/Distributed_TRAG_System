package com.mycompany.administradorcotizaciones_trag;


import dtos.quote.QuoteUpdateDTO;
import dtos.quote.QuoteSummaryDTO;
import dtos.quote.QuoteAddDTO;
import dtos.quote.QuoteDetailDTO;
import Exception.BusinessException;
import java.time.LocalDateTime;
import java.util.List;
import Daos.QuoteDAO; 
import Connection.Connection;


/**
 *
 * Archivo: FAdministradorCotizaciones.java
 * @author Ariel Eduardo Borbón Izaguirre - 253080
 * @author Sebastián Bórquez Huerta - 253080
 * @author Chris Fitch Lopez - 252379
 * */

public class FAdministradorCotizaciones implements IAdministradorCotizaciones {
    private final AdministradorCotizaciones administradorCotizaciones;
    
    public FAdministradorCotizaciones() {
        this.administradorCotizaciones = new AdministradorCotizaciones(new QuoteDAO());
    }

    public FAdministradorCotizaciones(AdministradorCotizaciones administradorCotizaciones) {
        this.administradorCotizaciones = administradorCotizaciones;
    }

    @Override
    public QuoteDetailDTO crearCotizacion(QuoteAddDTO dto) throws BusinessException{
        return administradorCotizaciones.crearCotizacion(dto);
    }


    @Override
    public QuoteDetailDTO obtenerCotizacion(Long idCotizacion) throws BusinessException {
        return administradorCotizaciones.obtenerCotizacion(idCotizacion);
    }

    

    @Override
    public QuoteSummaryDTO obtenerResumenCotizacion(Long idCotizacion) throws BusinessException {
        return administradorCotizaciones.obtenerResumenCotizacion(idCotizacion);
    }

    

    @Override
    public List<QuoteSummaryDTO> obtenerTodasCotizaciones() throws BusinessException {
        return administradorCotizaciones.obtenerTodasCotizaciones();
    }

    

    @Override
    public List<QuoteSummaryDTO> obtenerCotizacionesPorIdsClientes(List<Long> customerIds) throws BusinessException {
        return administradorCotizaciones.obtenerCotizacionesPorIdsClientes(customerIds);
    }

    

    @Override
    public List<QuoteSummaryDTO> obtenerCotizacionesFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin) throws BusinessException {
        return administradorCotizaciones.obtenerCotizacionesFecha(fechaInicio, fechaFin);
    }

    

    @Override
    public QuoteDetailDTO actualizarCotizacion(QuoteUpdateDTO dto) throws BusinessException{
        return administradorCotizaciones.actualizarCotizacion(dto);
    }


    @Override
    public QuoteDetailDTO eliminarCotizacion(Long idCotizacion) throws BusinessException {
        return administradorCotizaciones.eliminarCotizacion(idCotizacion);
    }


    @Override
    public QuoteDetailDTO habilitarCotizacion(Long idCotizacion) throws BusinessException {
        return administradorCotizaciones.habilitarCotizacion(idCotizacion);
    }
}