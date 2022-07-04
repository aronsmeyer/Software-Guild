/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aronsmeyer.vendingmachinev3.ui;

import com.aronsmeyer.vendingmachinev3.dto.Item;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author aronmeyer
 */
public class VendingMachineView {
    private UserIO io;
    
    public VendingMachineView(UserIO io) {
        this.io = io;
    }
    
    public BigDecimal takeMoney() {
        return io.readBigDecimal("Please enter the amount of money.");
    }
    
    public String getMenuSelection(BigDecimal userMoney) {
        io.print("You entered $" + userMoney + "."); 
        String menuSelection = io.readString("Please make your selection from the menu. Type 9 to exit.");
        return menuSelection;
    }
    
    public void displayInventory(List<Item> vendingMachineInventory) {
        // display only items with quantity > 0
        List<Item> inStockInventory = vendingMachineInventory.stream()
                .filter((i) ->i.getQuantity()>0)
                .collect(Collectors.toList());
        inStockInventory.stream()
                .forEach((i) -> System.out.println(i.getInventoryNumber() + " : " + i.getItemName() + " | $" + i.getPrice()));
    }
    
    /*
    public void displaySellResult(Item itemToSell) {
        if (itemToSell != null) {
            io.print("Here you go! Enjoy your " + itemToSell.getItemName() + "!");
        } else {
            io.print("Item not found.");
        }
        io.readString("Please hit enter to continue.");
    }
    */
    
    public void displayExitMessage() {
        io.print("Thanks for shopping! Good bye!");
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("ERROR");
        io.print(errorMsg);
    }
}
