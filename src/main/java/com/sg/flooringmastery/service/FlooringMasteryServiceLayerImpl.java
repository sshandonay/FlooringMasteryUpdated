/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringMasteryConfigurationDao;
import com.sg.flooringmastery.dao.FlooringMasteryOrderDao;
import com.sg.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.dao.FlooringMasteryProductTypeDao;
import com.sg.flooringmastery.dao.FlooringMasteryStateDao;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.ProductType;
import com.sg.flooringmastery.dto.State;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class FlooringMasteryServiceLayerImpl implements FlooringMasteryServiceLayer {

    FlooringMasteryOrderDao orderDao;
    FlooringMasteryProductTypeDao productTypeDao;
    FlooringMasteryStateDao stateDao;
    FlooringMasteryConfigurationDao configDao;

    private FlooringMasteryServiceLayerImpl(FlooringMasteryOrderDao orderDao, FlooringMasteryProductTypeDao productTypeDao, FlooringMasteryStateDao stateDao, FlooringMasteryConfigurationDao configDao) {
        this.orderDao = orderDao;
        this.productTypeDao = productTypeDao;
        this.stateDao = stateDao;
        this.configDao = configDao;
    }

    @Override
    public void addOrder(Order currentOrder) {
       orderDao.addOrder(currentOrder);
        //return updatedOrderList;
    }

    @Override
    public void editOrder(Order order) {
        orderDao.editOrder(order);

    }

    @Override
    public void removeOrder(Order orderToRemove) {
        orderDao.removeOrder(orderToRemove);
    
    }

    @Override
    public void saveOrder() throws FlooringMasteryPersistenceException {
//        List<Order> orderList = orderDao.getAllOrders();
//        for (Order currentOrder : orderList) {
//            if (currentOrder.getOrderNum() < 0) {
//                orderCount++;
//                currentOrder.setOrderNum(orderCount);
//            }
//        }
        orderDao.saveOrderDao();
    }

    @Override
    public int loadAllOrders() throws FlooringMasteryPersistenceException {
        int countOfOrders = orderDao.openOrderDao();
        return countOfOrders;
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orderList = orderDao.getAllOrders();
        return orderList;

    }

    private void generateOrderID() {

    }

    @Override
    public Order calculateOrderCosts(Order order) throws FlooringMasteryPersistenceException {
        ProductType productType = productTypeDao.getProductType(order.getProductType());

        //getting material & labor costs and then calculating total, setting the Order values
        ProductType newProductType = productTypeDao.getProductType(order.getProductType());
        BigDecimal materialCostPerSqFt = newProductType.getCostPerSquareFoot();
        BigDecimal laborCostPerSqFt = newProductType.getLaborCostPerSquareFoot();
        order.setMaterialCost(materialCostPerSqFt.setScale(2, RoundingMode.HALF_UP));
        order.setLaborCostPerSquareFoot(laborCostPerSqFt.setScale(2, RoundingMode.HALF_UP));

        BigDecimal totalMaterialCost = order.getArea().multiply(materialCostPerSqFt);
        order.setCostPerSquareFoot(totalMaterialCost.setScale(2, RoundingMode.HALF_UP));
        BigDecimal totalLaborCost = order.getArea().multiply(laborCostPerSqFt);
        order.setLaborCost(totalLaborCost.setScale(2, RoundingMode.HALF_UP));

        //getting Tax, calculating the tax then calculating Total
        State newState = stateDao.getState(order.getState());
        BigDecimal taxRate = newState.getTax();
        order.setTaxRate(taxRate.setScale(2, RoundingMode.HALF_UP));

        BigDecimal totalBeforeTax = totalMaterialCost.add(totalLaborCost);
        BigDecimal totalTax = (taxRate.divide(new BigDecimal("100")).multiply(totalBeforeTax));
        BigDecimal total = totalTax.add(totalBeforeTax);
        order.setTax(totalTax.setScale(2, RoundingMode.HALF_UP));
        order.setTotal(total.setScale(2, RoundingMode.HALF_UP));

        return order;
    }

    @Override
    public String readConfig() throws FlooringMasteryPersistenceException {

        return configDao.readConfigDao();

    }

    @Override
    public List<ProductType> getAllProductTypes() throws FlooringMasteryPersistenceException {

        return productTypeDao.getAllProductTypes();

    }

    @Override
    public List<State> getAllStates() throws FlooringMasteryPersistenceException {
        return stateDao.getAllStates();
    }

}


// Week 5 - SShandonay 
