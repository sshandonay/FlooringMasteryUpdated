/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.ProductType;
import com.sg.flooringmastery.dto.State;
import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class FlooringMasteryServiceLayerTest {

    private FlooringMasteryServiceLayer service;

    public FlooringMasteryServiceLayerTest() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = ctx.getBean("serviceLayer", FlooringMasteryServiceLayer.class);

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addOrder method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testAddOrderFail() throws Exception {

        Order onlyOrder = new Order();
        onlyOrder.setOrderNum(4);
        onlyOrder.setCustomerName("Timothy");
        onlyOrder.setState("OR");
        onlyOrder.setTaxRate(new BigDecimal("0.00"));
        onlyOrder.setProductType("Carpet");
        onlyOrder.setArea(new BigDecimal("20"));
        onlyOrder.setCostPerSquareFoot(new BigDecimal("2"));
        onlyOrder.setLaborCostPerSquareFoot(new BigDecimal("2"));
        onlyOrder.setMaterialCost(new BigDecimal("2"));
        onlyOrder.setLaborCost(new BigDecimal("2"));
        onlyOrder.setTax(new BigDecimal("2"));
        onlyOrder.setTotal(new BigDecimal("2"));

         service.addOrder(onlyOrder);

        //assertNull(orderList);

    }

    @Test
    public void testAddOrder() {

        Order onlyOrder = new Order();
        onlyOrder.setOrderNum(2);
        onlyOrder.setCustomerName("Timothy");
        onlyOrder.setState("OR");
        onlyOrder.setTaxRate(new BigDecimal("0.00"));
        onlyOrder.setProductType("Carpet");
        onlyOrder.setArea(new BigDecimal("20"));
        onlyOrder.setCostPerSquareFoot(new BigDecimal("2"));
        onlyOrder.setLaborCostPerSquareFoot(new BigDecimal("2"));
        onlyOrder.setMaterialCost(new BigDecimal("2"));
        onlyOrder.setLaborCost(new BigDecimal("2"));
        onlyOrder.setTax(new BigDecimal("2"));
        onlyOrder.setTotal(new BigDecimal("2"));

        service.addOrder(onlyOrder);

//        assertEquals(orderList.size(), 1);

    }

    /**
     * Test of loadAllOrders method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testLoadAllOrders() throws Exception {
    }

    /**
     * Test of getAllOrders method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testGetAllOrders() {
    }

    /**
     * Test of calculateOrderCosts method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testCalculateOrderCosts() throws Exception {
    }

    /**
     * Test of editOrder method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testEditOrder() {
    }

    /**
     * Test of removeOrder method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testRemoveOrder() {

        List<Order> sizeCheck = service.getAllOrders();

        Order onlyOrder = new Order();
        onlyOrder.setOrderNum(2);
        onlyOrder.setCustomerName("Timothy");
        onlyOrder.setState("OR");
        onlyOrder.setTaxRate(new BigDecimal("0.00"));
        onlyOrder.setProductType("Carpet");
        onlyOrder.setArea(new BigDecimal("20"));
        onlyOrder.setCostPerSquareFoot(new BigDecimal("2"));
        onlyOrder.setLaborCostPerSquareFoot(new BigDecimal("2"));
        onlyOrder.setMaterialCost(new BigDecimal("2"));
        onlyOrder.setLaborCost(new BigDecimal("2"));
        onlyOrder.setTax(new BigDecimal("2"));
        onlyOrder.setTotal(new BigDecimal("2"));

        //List<Order> orderList = service.addOrder(onlyOrder);

        service.removeOrder(onlyOrder);
        List<Order> fromService = service.getAllOrders();

        assertEquals(fromService.size(), sizeCheck.size());

    }

    /**
     * Test of saveOrder method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testSaveOrder() throws Exception {
    }

    /**
     * Test of readConfig method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testReadConfig() throws Exception {
    }

    public class FlooringMasteryServiceLayerImpl implements FlooringMasteryServiceLayer {

        public void addOrder(Order currentOrder) {
            //return null;
        }

        public int loadAllOrders() throws FlooringMasteryPersistenceException {
            return 0;
        }

        public List<Order> getAllOrders() {
            return null;
        }

        public Order calculateOrderCosts(Order order) throws FlooringMasteryPersistenceException {
            return null;
        }

        public void editOrder(Order order) {
           
        }

        public void removeOrder(Order orderToRemove) {
            
        }

        public void saveOrder() throws FlooringMasteryPersistenceException {
        }

        public String readConfig() throws FlooringMasteryPersistenceException {
            return "";
        }

        @Override
        public List<ProductType> getAllProductTypes() throws FlooringMasteryPersistenceException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public List<State> getAllStates() throws FlooringMasteryPersistenceException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

}

// Week 5 - SShandonay 
