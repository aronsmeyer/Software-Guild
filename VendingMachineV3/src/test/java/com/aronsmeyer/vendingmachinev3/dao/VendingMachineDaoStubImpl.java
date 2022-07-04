/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aronsmeyer.vendingmachinev3.dao;

import com.aronsmeyer.vendingmachinev3.dto.Item;
import com.aronsmeyer.vendingmachinev3.service.InsufficientFundsException;
import com.aronsmeyer.vendingmachinev3.service.NoItemInventoryException;
import java.util.List;

/**
 *
 * @author aronmeyer
 */
public class VendingMachineDaoStubImpl implements VendingMachineDao {

    @Override
    public List<Item> getAllItems() throws VendingMachinePersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Item getItem(String inventoryNumber) throws VendingMachinePersistenceException, NoItemInventoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Item sellItem(String inventoryNumber) throws VendingMachinePersistenceException, NoItemInventoryException, InsufficientFundsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
