/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class FlooringMasteryOrderDaoStubImpl implements FlooringMasteryOrderDao {

    Order onlyOrder;
    List<Order> floorOrderList = new ArrayList<>();

   private FlooringMasteryOrderDaoStubImpl() {
        onlyOrder = new Order();
        onlyOrder.setOrderNum(2);
        onlyOrder.setCustomerName("Timotny");
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

        floorOrderList.add(onlyOrder);

    }

    @Override
    public void addOrder(Order order) {
//        if (order.getOrderNum().equals(onlyOrder.getOrderNum())) {
//            return floorOrderList;
//        } else {
//            return null;
//        }

    }

    @Override
    public void editOrder(Order order) {
        if (order.equals(onlyOrder.getOrderNum())) {
            onlyOrder.setCustomerName("Joe");
            
        } 
    }

    @Override
    public List<Order> getAllOrders() {
        return floorOrderList;
    }

    @Override
    public void removeOrder(Order order) {
        if (order.getOrderNum().equals(onlyOrder.getOrderNum())) {
            
        } 
    }

    @Override
    public int openOrderDao() throws FlooringMasteryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveOrderDao() throws FlooringMasteryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}


// Week 5 - SShandonay 