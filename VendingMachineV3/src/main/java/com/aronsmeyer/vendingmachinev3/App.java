/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aronsmeyer.vendingmachinev3;

import com.aronsmeyer.vendingmachinev3.controller.VendingMachineController;
import com.aronsmeyer.vendingmachinev3.dao.VendingMachineAuditDao;
import com.aronsmeyer.vendingmachinev3.dao.VendingMachineAuditDaoFileImpl;
import com.aronsmeyer.vendingmachinev3.dao.VendingMachineDao;
import com.aronsmeyer.vendingmachinev3.dao.VendingMachineDaoFileImpl;
import com.aronsmeyer.vendingmachinev3.dao.VendingMachinePersistenceException;
import com.aronsmeyer.vendingmachinev3.service.InsufficientFundsException;
import com.aronsmeyer.vendingmachinev3.service.NoItemInventoryException;
import com.aronsmeyer.vendingmachinev3.service.VendingMachineServiceLayer;
import com.aronsmeyer.vendingmachinev3.service.VendingMachineServiceLayerImpl;
import com.aronsmeyer.vendingmachinev3.ui.UserIO;
import com.aronsmeyer.vendingmachinev3.ui.UserIOConsoleImpl;
import com.aronsmeyer.vendingmachinev3.ui.VendingMachineView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author aronmeyer
 */
public class App {
    public static void main(String[] args) {
        
        /*
        UserIO myIo = new UserIOConsoleImpl();
        VendingMachineView myView = new VendingMachineView(myIo);
        VendingMachineDao myDao = new VendingMachineDaoFileImpl();
        VendingMachineAuditDao myAuditDao = new VendingMachineAuditDaoFileImpl();
        VendingMachineServiceLayer myService = new VendingMachineServiceLayerImpl(myDao, myAuditDao);
        VendingMachineController controller = new VendingMachineController(myService, myView);
        controller.run();
        */
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        VendingMachineController controller = ctx.getBean("controller", VendingMachineController.class);
        controller.run();
    }
}

//original?