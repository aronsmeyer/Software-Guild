/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.aronsmeyer.vendingmachinev3.dto;

/**
 *
 * @author aronmeyer
 */
public enum Coin {
    QUARTER (25), 
    DIME (10),
    NICKEL (5),
    PENNY (1);


final int valueInCents;

Coin (int valueInCents) {
    this.valueInCents = valueInCents;
}
}