/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aronsmeyer.vendingmachinev3.dao;

import com.aronsmeyer.vendingmachinev3.dto.Change;
import com.aronsmeyer.vendingmachinev3.dto.Item;
import com.aronsmeyer.vendingmachinev3.service.InsufficientFundsException;
import com.aronsmeyer.vendingmachinev3.service.NoItemInventoryException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author aronmeyer
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {

    private final String INVENTORY_FILE;
    public static final String DELIMITER = "::";
    
    public VendingMachineDaoFileImpl(){
        INVENTORY_FILE = "inventory.txt";
    }
    
    public VendingMachineDaoFileImpl(String inventoryTextFile){
        INVENTORY_FILE = inventoryTextFile;
    }
    
    private Map<String, Item> vendingMachineInventory = new HashMap<>();
    
    @Override
    public List<Item> getAllItems() throws VendingMachinePersistenceException {
        loadInventory();
        return new ArrayList<Item>(vendingMachineInventory.values());
    }

    @Override
    public Item getItem(String inventoryNumber) throws VendingMachinePersistenceException, NoItemInventoryException {
        loadInventory();
        return vendingMachineInventory.get(inventoryNumber);
    }

    @Override
    public Item sellItem(String inventoryNumber) throws VendingMachinePersistenceException, NoItemInventoryException, InsufficientFundsException {
        loadInventory();
        Item itemToSell = vendingMachineInventory.get(inventoryNumber);
        itemToSell.setQuantity(itemToSell.getQuantity()-1);
        writeInventory();
        return itemToSell;
    }
    

    
    private Item unmarshallItem(String itemAsText) {
        String[] itemTokens = itemAsText.split(DELIMITER);
        String inventoryNumber = itemTokens[0];
        Item itemFromFile = new Item(inventoryNumber);
        itemFromFile.setItemName(itemTokens[1]);
        BigDecimal itemFromFileAmt = new BigDecimal(itemTokens[2]);
        BigDecimal itemFromFilePrice = itemFromFileAmt.setScale(2, RoundingMode.HALF_UP);
        itemFromFile.setPrice(itemFromFilePrice);
        int itemFromFileQuantity = parseInt(itemTokens[3]);
        itemFromFile.setQuantity(itemFromFileQuantity);
        return itemFromFile;
    }
    
    private void loadInventory() throws VendingMachinePersistenceException {
        Scanner scanner;
        
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(INVENTORY_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException("Could not load data into memory.");
        }
        String currentLine;
        Item currentItem;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentItem = unmarshallItem(currentLine);
            vendingMachineInventory.put(currentItem.getInventoryNumber(), currentItem);
        }
        scanner.close();
    }
    
    private String marshallItem(Item anItem) {
        String itemAsText = anItem.getInventoryNumber() + DELIMITER;
        itemAsText += anItem.getItemName() + DELIMITER;
        itemAsText += anItem.getPrice() + DELIMITER;
        itemAsText += anItem.getQuantity();
        return itemAsText;
    }
    
    private void writeInventory() throws VendingMachinePersistenceException {
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(INVENTORY_FILE));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException("Could not save inventory data.", e);
        }
        
        String itemAsText;
        List<Item> inventoryList = this.getAllItems();
        for (Item currentItem : inventoryList) {
            itemAsText = marshallItem(currentItem);
            out.println(itemAsText);
            out.flush();
        }
        out.close();
    }
    
}
