package com.mycompany.quoteservice;

import Entitys.Quote;
import Exception.BusinessException;
import Exception.PersistenceException;
import Service.QuoteManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 *
 * @author sonic
 *
 */
@Endpoint
public class QuoteSOAPService {

    private static final String NAMESPACE_URI = "http://mycompany.com/quoteservice";

    private final QuoteManager quoteManager;

    @Autowired
    public QuoteSOAPService(QuoteManager quoteManager) {
        this.quoteManager = quoteManager;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CalculateQuoteRequest")
    @ResponsePayload
    public CalculateQuoteResponse procesarCotizacion(
            @RequestPayload CalculateQuoteRequest request) {

        CalculateQuoteResponse response = new CalculateQuoteResponse();

        try {
            Quote saved = quoteManager.crearCotizacion(
                    request.getClienteId(),
                    request.getVehiculoId(),
                    request.getServiceId(),
                    request.getVehicleStatus(),
                    request.getGeneralDiagnosis()
            );

            response.setQuoteId(saved.getId());
            response.setTotalEstimado(saved.getLaborPrice().doubleValue());
            response.setMensaje("Cotización #" + saved.getId() + " creada exitosamente.");

        } catch (BusinessException | PersistenceException e) {

            response.setQuoteId(0L);
            response.setTotalEstimado(0.0);
            response.setMensaje("No se pudo crear la cotización: " + e.getMessage());

        } catch (Exception e) {

            response.setQuoteId(0L);
            response.setTotalEstimado(0.0);
            response.setMensaje("Error inesperado al crear la cotización: " + e.getMessage());
        }

        return response;
    }
}