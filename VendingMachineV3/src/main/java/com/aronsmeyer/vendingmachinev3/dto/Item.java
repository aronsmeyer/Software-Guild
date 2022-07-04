/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aronsmeyer.vendingmachinev3.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author aronmeyer
 */
public class Item {
    private String inventoryNumber;
    private String itemName;
    private BigDecimal price;
    private int quantity; 
    
    public Item(String inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }
    
    public String getInventoryNumber() {
        return inventoryNumber;
    }
    
    public String getItemName() {
        return itemName;
    }
    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
    public BigDecimal getPrice() {
        return price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.inventoryNumber);
        hash = 41 * hash + Objects.hashCode(this.itemName);
        hash = 41 * hash + Objects.hashCode(this.price);
        hash = 41 * hash + this.quantity;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Item{" + "inventoryNumber=" + inventoryNumber + ", itemName=" + itemName + ", price=" + price + ", quantity=" + quantity + '}';
    }

}
