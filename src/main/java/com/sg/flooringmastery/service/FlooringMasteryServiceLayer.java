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
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface FlooringMasteryServiceLayer {

    public void addOrder(Order currentOrder);

    public int loadAllOrders() throws FlooringMasteryPersistenceException;

    public List<Order> getAllOrders();

    public Order calculateOrderCosts(Order order) throws FlooringMasteryPersistenceException;

    public void editOrder(Order order);

    public void removeOrder(Order orderToRemove);

    public void saveOrder() throws FlooringMasteryPersistenceException;

    public String readConfig() throws FlooringMasteryPersistenceException;
    
    public List<ProductType> getAllProductTypes() throws FlooringMasteryPersistenceException;
    
    public List<State> getAllStates() throws FlooringMasteryPersistenceException;
    

}

// Week 5 - SShandonay 


