/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.aronsmeyer.vendingmachinev3.dao;

import com.aronsmeyer.vendingmachinev3.dto.Item;
import java.io.FileWriter;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aronmeyer
 */
public class VendingMachineDaoFileImplTest {
    
    VendingMachineDao testDao;
    
    public VendingMachineDaoFileImplTest() {
    }
    
    
    @BeforeEach
    public void setUp() throws Exception {
        String testFile = "testinventory.txt";
        // FileWriter blanks the file
        new FileWriter(testFile);
        testDao = new VendingMachineDaoFileImpl(testFile);
    }
    
    @Test
    public void testGetAllItems() throws Exception {
        // Retrieve list of all items in inventory
        List<Item> allItems = testDao.getAllItems();
        System.out.println(allItems + ": Contents of List");
        assertNotNull(allItems, "The inventory list should not be null.");
    }
    
    /*
    @Test
    public void testSellItem() throws Exception {
        List<Item> allItems = testDao.getAllItems();
        assertNotNull(allItems, "The inventory list should not be null.");
        
        // sell item by inventory number
        Item itemToSell = testDao.sellItem("1A");
        
        // make sure quantity has changed to zero
        assertEquals(itemToSell.getQuantity(), "0");
        
    }
    */
    
    
    @AfterEach
    public void tearDown() {
    }

}
