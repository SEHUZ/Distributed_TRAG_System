/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entitys.Quote;
import Exception.PersistenceException;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author sonic
 */
public interface IQuotesDAO {

    Quote addQuote(Quote quote) throws PersistenceException;

    Quote getQuote(Long idQuote) throws PersistenceException;

    List<Quote> getAllQuotes() throws PersistenceException;

    List<Quote> getQuotesByCustomerIds(List<Long> customerIds) throws PersistenceException;

    List<Quote> getQuotesByDate(LocalDateTime startDate, LocalDateTime endDate) throws PersistenceException;

    Quote updateQuote(Quote quote) throws PersistenceException;

    Quote deleteQuote(Long idQuote) throws PersistenceException;

    Quote enableQuote(Long idQuote) throws PersistenceException;
}
