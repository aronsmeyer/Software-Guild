/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aronsmeyer.vendingmachinev3.service;

import com.aronsmeyer.vendingmachinev3.dao.VendingMachineAuditDao;
import com.aronsmeyer.vendingmachinev3.dao.VendingMachineDao;
import com.aronsmeyer.vendingmachinev3.dao.VendingMachineDaoFileImpl;
import com.aronsmeyer.vendingmachinev3.dao.VendingMachinePersistenceException;
import com.aronsmeyer.vendingmachinev3.dto.Change;
import com.aronsmeyer.vendingmachinev3.dto.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author aronmeyer
 */
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {

    private VendingMachineAuditDao auditDao;
    VendingMachineDao dao;
    Change change;
    
    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }
    
    @Override
    public List<Item> getAllItems() throws VendingMachinePersistenceException {
        return dao.getAllItems();
    }

    @Override
    public Item getItem(String inventoryNumber) throws VendingMachinePersistenceException, NoItemInventoryException {
        return dao.getItem(inventoryNumber);
    }

   
    @Override
    public void validateUserSelection(String inventoryNumber) throws VendingMachinePersistenceException, NoItemInventoryException {
        if (dao.getItem(inventoryNumber) ==null) {
            throw new NoItemInventoryException("Inventory number not found.");
        } else if (dao.getItem(inventoryNumber).getQuantity() <= 0) {
            throw new NoItemInventoryException("Item is sold out.");
        }
        
    }
    
    @Override
    public void sellItem(String inventoryNumber, BigDecimal userMoney) throws VendingMachinePersistenceException, 
            NoItemInventoryException, InsufficientFundsException {
        // Make sure inventoryNumber corresponds to an item and make sure it is in stock
        Item itemToSell = dao.getItem(inventoryNumber);
        // Check that user entered enough money
        if (itemToSell.getPrice().doubleValue() > userMoney.doubleValue()){
            throw new InsufficientFundsException("Insufficient funds for this item. You inserted $" + userMoney + ".");
        } 
        else {
        Item soldItem = dao.sellItem(inventoryNumber);
        // calculate change amount
        double userChange = (userMoney.doubleValue() - soldItem.getPrice().doubleValue());
        System.out.println("Now dispensing $" + BigDecimal.valueOf(userChange) + " change.");
        // return change as separate coins
        this.change = new Change();
        change.makeChange(userChange);
        // write to audit log
        auditDao.writeAuditEntry(soldItem.getItemName() + " SOLD.");
        
        }
        
    }
  
    }
   
    
