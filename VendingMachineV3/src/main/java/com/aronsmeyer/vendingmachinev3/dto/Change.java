/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aronsmeyer.vendingmachinev3.dto;

import java.math.BigDecimal;

/**
 *
 * @author aronmeyer
 */
public class Change {
    
    public int quarters;
    public int dimes;
    public int nickels;
    public int pennies;

    public int getQuarters() {
        return quarters;
    }

    public int getDimes() {
        return dimes;
    }

    public int getNickels() {
        return nickels;
    }

    public int getPennies() {
        return pennies;
    }
 
    public void makeChange(double userChange) {
        
//Change userCoins = new Change();
        int changeInCents = (int)(userChange * 100);
        // calculate quarters
        this.quarters = changeInCents / 25;
        // subtract cents in quarters from total
        int changeMinusQuarters = changeInCents - (this.quarters * 25);
        // calculate dimes
        this.dimes = changeMinusQuarters / 10;
        // subtract cents in dimes from total
        int changeMinusDimes = changeMinusQuarters - (this.dimes * 10);
        // calculate nickels
        this.nickels = changeMinusDimes / 5;
        // subtract cents in nickels from total
        int changeMinusNickels = changeMinusDimes - (this.nickels * 5);
        // calculate pennies
        this.pennies = changeMinusNickels;
        System.out.println("Dispensing " + this.quarters + " quarters, " + this.dimes + " dimes, " + this.nickels + " nickels, and " + this.pennies + " pennies.");
  
    }
        
}


