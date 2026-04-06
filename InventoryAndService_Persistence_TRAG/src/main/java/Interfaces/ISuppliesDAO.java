/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entitys.Supply;
import Exception.PersistenceException;
import java.util.List;

/**
 *
 * @author sonic
 */
public interface ISuppliesDAO {
    public abstract Supply addSupply(Supply supply) throws PersistenceException;
    public abstract Supply getSupply(Long idInsumo) throws PersistenceException;
    public abstract List<Supply> getSuppliesName(String supplyName) throws PersistenceException;
}
