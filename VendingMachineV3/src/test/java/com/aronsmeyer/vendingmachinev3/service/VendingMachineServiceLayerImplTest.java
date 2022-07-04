/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.aronsmeyer.vendingmachinev3.service;

import com.aronsmeyer.vendingmachinev3.dao.VendingMachineAuditDao;
import com.aronsmeyer.vendingmachinev3.dao.VendingMachineDao;
import com.aronsmeyer.vendingmachinev3.dao.VendingMachineDaoStubImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author aronmeyer
 */
public class VendingMachineServiceLayerImplTest {
    
    private VendingMachineServiceLayer service;
    
    public VendingMachineServiceLayerImplTest() {
//        VendingMachineDao dao = new VendingMachineDaoStubImpl();
//        VendingMachineAuditDao auditDao = new VendingMachineAuditDaoStubImpl();
//        
//        service = new VendingMachineServiceLayerImpl(dao, auditDao);
    
    
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    service = ctx.getBean("serviceLayer", VendingMachineServiceLayer.class);
}
    
    @BeforeEach
    public void setUp() {
    }
    
    @Test
    public void test
    
    @AfterEach
    public void tearDown() {
    }

}
