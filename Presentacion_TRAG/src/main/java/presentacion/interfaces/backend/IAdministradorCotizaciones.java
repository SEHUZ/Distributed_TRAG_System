/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.interfaces.backend;

import dtos.quote.QuoteAddDTO;
import dtos.quote.QuoteDetailDTO;
import dtos.quote.QuoteSummaryDTO;
import dtos.quote.QuoteUpdateDTO;
import java.util.List;

/**
 *
 * @author PC Gamer
 */
public interface IAdministradorCotizaciones {

    List<QuoteSummaryDTO> obtenerTodasCotizaciones() throws Exception;

    QuoteDetailDTO obtenerCotizacion(Long idCotizacion) throws Exception;

    QuoteDetailDTO crearCotizacion(QuoteAddDTO quoteAddDTO) throws Exception;

    QuoteDetailDTO actualizarCotizacion(QuoteUpdateDTO quoteUpdateDTO) throws Exception;

    void eliminarCotizacion(Long idCotizacion) throws Exception;

    void habilitarCotizacion(Long idCotizacion) throws Exception;
}
