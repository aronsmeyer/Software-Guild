/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aronsmeyer.vendingmachinev3.dao;

/**
 *
 * @author aronmeyer
 */
public interface VendingMachineAuditDao {
    
    public void writeAuditEntry(String entry) throws VendingMachinePersistenceException;
    
}
