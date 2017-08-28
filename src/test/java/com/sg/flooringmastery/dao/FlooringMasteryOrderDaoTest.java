/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class FlooringMasteryOrderDaoTest {

    private FlooringMasteryOrderDao dao = new FlooringMasteryOrderDaoImpl();

    public FlooringMasteryOrderDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
//    public void setUp() throws Exception {
//        List<Order> flooringOrderList = dao.getAllOrders();
//        for (Order flooringOrders : flooringOrderList) {
//            dao.removeOrder(flooringOrders);
//        }
//    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addOrder method, of class FlooringMasteryOrderDao.
     */
    @Test
    public void testAddOrder() {
        Order flooringOrder = new Order();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse("10/10/2010", formatter);

        flooringOrder.setOrderDate(date);
        flooringOrder.setOrderNum(1);
        flooringOrder.setCustomerName("Billy");
        flooringOrder.setState("WA");
        flooringOrder.setTaxRate(new BigDecimal("9.5"));
        flooringOrder.setProductType("Tile");
        flooringOrder.setArea(new BigDecimal("50"));
        flooringOrder.setCostPerSquareFoot(new BigDecimal("2"));
        flooringOrder.setLaborCostPerSquareFoot(new BigDecimal("2.2"));
        flooringOrder.setMaterialCost(new BigDecimal("12"));
        flooringOrder.setLaborCost(new BigDecimal("22"));
        flooringOrder.setTax(new BigDecimal("35"));
        flooringOrder.setTotal(new BigDecimal("29.99"));

        dao.addOrder(flooringOrder);
        List<Order> fromOrderDao = dao.getAllOrders();

//        List<Order> fromOrderDao = dao.getAllOrders();
//        Order orderFromDao = fromOrderDao.get(0);
//        assertEquals(fromOrderDao, flooringOrder);
        dao.removeOrder(flooringOrder);
    }

    /**
     * Test of editOrder method, of class FlooringMasteryOrderDao.
     */
    @Test
    public void testEditOrder() {
        
        Order flooringOrder = new Order();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse("10/10/2010", formatter);

        flooringOrder.setOrderDate(date);
        flooringOrder.setOrderNum(1);
        flooringOrder.setCustomerName("Billy");
        flooringOrder.setState("WA");
        flooringOrder.setTaxRate(new BigDecimal("9.5"));
        flooringOrder.setProductType("Tile");
        flooringOrder.setArea(new BigDecimal("50"));
        flooringOrder.setCostPerSquareFoot(new BigDecimal("2"));
        flooringOrder.setLaborCostPerSquareFoot(new BigDecimal("2.2"));
        flooringOrder.setMaterialCost(new BigDecimal("12"));
        flooringOrder.setLaborCost(new BigDecimal("22"));
        flooringOrder.setTax(new BigDecimal("35"));
        flooringOrder.setTotal(new BigDecimal("29.99"));

        dao.addOrder(flooringOrder);
        List<Order> fromOrderDao = dao.getAllOrders();
//        assertEquals(fromOrderDao, flooringOrder);

        flooringOrder.setState("KY");
        dao.editOrder(flooringOrder);
        fromOrderDao = dao.getAllOrders();
//        assertEquals(fromOrderDao, flooringOrder);

    }

    /**
     * Test of getAllOrders method, of class FlooringMasteryOrderDao.
     */
    public void testGetAllOrders() throws Exception {
        Order flooringOrder1 = new Order();

        flooringOrder1.setOrderNum(1);
        flooringOrder1.setCustomerName("Spencer");
        flooringOrder1.setState("WA");
        flooringOrder1.setTaxRate(new BigDecimal("9.5"));
        flooringOrder1.setProductType("Tile");
        flooringOrder1.setArea(new BigDecimal("50"));
        flooringOrder1.setCostPerSquareFoot(new BigDecimal("2"));
        flooringOrder1.setLaborCostPerSquareFoot(new BigDecimal("2"));
        flooringOrder1.setMaterialCost(new BigDecimal("2"));
        flooringOrder1.setLaborCost(new BigDecimal("2"));
        flooringOrder1.setTax(new BigDecimal("2"));
        flooringOrder1.setTotal(new BigDecimal("2"));

        dao.addOrder(flooringOrder1);

        Order flooringOrder2 = new Order();

        flooringOrder2.setOrderNum(2);
        flooringOrder2.setCustomerName("Timotny");
        flooringOrder2.setState("OR");
        flooringOrder2.setTaxRate(new BigDecimal("0.00"));
        flooringOrder2.setProductType("Carpet");
        flooringOrder2.setArea(new BigDecimal("20"));
        flooringOrder2.setCostPerSquareFoot(new BigDecimal("2"));
        flooringOrder2.setLaborCostPerSquareFoot(new BigDecimal("2"));
        flooringOrder2.setMaterialCost(new BigDecimal("2"));
        flooringOrder2.setLaborCost(new BigDecimal("2"));
        flooringOrder2.setTax(new BigDecimal("2"));
        flooringOrder2.setTotal(new BigDecimal("2"));

        dao.addOrder(flooringOrder2);

        assertEquals(2, dao.getAllOrders().size());
    }

    /**
     * Test of removeOrder method, of class FlooringMasteryOrderDao.
     */
    public void testRemoveOrder() {
        Order flooringOrder1 = new Order();

        flooringOrder1.setOrderNum(1);
        flooringOrder1.setCustomerName("Spencer");
        flooringOrder1.setState("WA");
        flooringOrder1.setTaxRate(new BigDecimal("9.5"));
        flooringOrder1.setProductType("Tile");
        flooringOrder1.setArea(new BigDecimal("50"));
        flooringOrder1.setCostPerSquareFoot(new BigDecimal("2"));
        flooringOrder1.setLaborCostPerSquareFoot(new BigDecimal("2"));
        flooringOrder1.setMaterialCost(new BigDecimal("2"));
        flooringOrder1.setLaborCost(new BigDecimal("2"));
        flooringOrder1.setTax(new BigDecimal("2"));
        flooringOrder1.setTotal(new BigDecimal("2"));

        dao.addOrder(flooringOrder1);

        Order flooringOrder2 = new Order();

        flooringOrder2.setOrderNum(2);
        flooringOrder2.setCustomerName("Timotny");
        flooringOrder2.setState("OR");
        flooringOrder2.setTaxRate(new BigDecimal("0.00"));
        flooringOrder2.setProductType("Carpet");
        flooringOrder2.setArea(new BigDecimal("20"));
        flooringOrder2.setCostPerSquareFoot(new BigDecimal("2"));
        flooringOrder2.setLaborCostPerSquareFoot(new BigDecimal("2"));
        flooringOrder2.setMaterialCost(new BigDecimal("2"));
        flooringOrder2.setLaborCost(new BigDecimal("2"));
        flooringOrder2.setTax(new BigDecimal("2"));
        flooringOrder2.setTotal(new BigDecimal("2"));

        dao.addOrder(flooringOrder2);

        dao.removeOrder(flooringOrder1);
        assertEquals(1, dao.getAllOrders().size());
        assertNull(dao.getAllOrders());

        dao.removeOrder(flooringOrder2);
        assertEquals(2, dao.getAllOrders().size());
        assertNull(dao.getAllOrders());

    }

    /**
     * Test of openOrderDao method, of class FlooringMasteryOrderDao.
     */
    @Test
    public void testOpenOrderDao() throws Exception {
    }

    /**
     * Test of saveOrderDao method, of class FlooringMasteryOrderDao.
     */
    @Test
    public void testSaveOrderDao() throws Exception {
    }

    public class FlooringMasteryOrderDaoImpl implements FlooringMasteryOrderDao {

        public void addOrder(Order order) {
            //return null;
        }

        public void editOrder(Order order) {
            
        }

        public List<Order> getAllOrders() {
            return null;
        }

        public void removeOrder(Order order) {
            
        }

        public int openOrderDao() throws FlooringMasteryPersistenceException {
            return 0;
        }

        public void saveOrderDao() throws FlooringMasteryPersistenceException {
        }
    }

}


// Week 5 - SShandonay 
