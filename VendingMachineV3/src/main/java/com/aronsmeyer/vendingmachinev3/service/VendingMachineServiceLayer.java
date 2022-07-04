/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aronsmeyer.vendingmachinev3.service;

import com.aronsmeyer.vendingmachinev3.dao.VendingMachinePersistenceException;
import com.aronsmeyer.vendingmachinev3.dto.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author aronmeyer
 */
public interface VendingMachineServiceLayer {
    
    List<Item> getAllItems() throws VendingMachinePersistenceException;
    
    Item getItem(String inventoryNumber) throws VendingMachinePersistenceException, NoItemInventoryException;
    
    public void sellItem(String inventoryNumber, BigDecimal userMoney) throws VendingMachinePersistenceException, 
            NoItemInventoryException, InsufficientFundsException;
    
    void validateUserSelection(String inventoryNumber) throws VendingMachinePersistenceException, NoItemInventoryException;
    
    
}
