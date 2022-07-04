/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aronsmeyer.vendingmachinev3.controller;

import com.aronsmeyer.vendingmachinev3.dao.VendingMachineDao;
import com.aronsmeyer.vendingmachinev3.dao.VendingMachinePersistenceException;
import com.aronsmeyer.vendingmachinev3.dao.VendingMachineDaoFileImpl;
import com.aronsmeyer.vendingmachinev3.dto.Item;
import com.aronsmeyer.vendingmachinev3.service.InsufficientFundsException;
import com.aronsmeyer.vendingmachinev3.service.NoItemInventoryException;
import com.aronsmeyer.vendingmachinev3.service.VendingMachineServiceLayer;
import com.aronsmeyer.vendingmachinev3.ui.UserIO;
import com.aronsmeyer.vendingmachinev3.ui.UserIOConsoleImpl;
import com.aronsmeyer.vendingmachinev3.ui.VendingMachineView;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author aronmeyer
 */
public class VendingMachineController {
        
    private VendingMachineView view;
    private VendingMachineServiceLayer service;
    
    public VendingMachineController(VendingMachineServiceLayer service, VendingMachineView view) {
        this.service = service;
        this.view = view;
    }
    
    public void run()  {
        boolean keepGoing = true;
        String menuSelection;
        BigDecimal userMoney;
        try {
        while (keepGoing) {
            
            // display in-stock items
            displayInventoryList();
            
            // receive money from user
            userMoney = view.takeMoney();
            
            // after taking money, user chooses item
            menuSelection = view.getMenuSelection(userMoney);
            
            // option to exit program
            if (menuSelection.equals("9")) {
                keepGoing = false;
                view.displayExitMessage();
            }  else {
                // check that inventory number is valid and sell item
                service.validateUserSelection(menuSelection);
                service.sellItem(menuSelection, userMoney);
                
            }
             
        }
        } catch (VendingMachinePersistenceException | NoItemInventoryException | InsufficientFundsException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }
    private void displayInventoryList() throws VendingMachinePersistenceException {
        List<Item> vendingMachineInventory = service.getAllItems();
        view.displayInventory(vendingMachineInventory);
    }
    
}
