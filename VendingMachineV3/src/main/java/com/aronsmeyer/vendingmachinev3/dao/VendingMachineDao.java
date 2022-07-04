/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aronsmeyer.vendingmachinev3.dao;

import com.aronsmeyer.vendingmachinev3.dto.Change;
import com.aronsmeyer.vendingmachinev3.dto.Item;
import com.aronsmeyer.vendingmachinev3.service.InsufficientFundsException;
import com.aronsmeyer.vendingmachinev3.service.NoItemInventoryException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author aronmeyer
 */
public interface VendingMachineDao {
    
    List <Item> getAllItems() throws VendingMachinePersistenceException;
    
    Item getItem(String inventoryNumber) throws VendingMachinePersistenceException, NoItemInventoryException;
    
    Item sellItem(String inventoryNumber) throws VendingMachinePersistenceException, NoItemInventoryException, InsufficientFundsException;
           
}
