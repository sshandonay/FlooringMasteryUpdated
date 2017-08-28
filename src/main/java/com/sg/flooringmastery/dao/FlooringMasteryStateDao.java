/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.State;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface FlooringMasteryStateDao {

    public State addState(String stateName, State state) throws FlooringMasteryPersistenceException;

    public State editState(String stateName, State state) throws FlooringMasteryPersistenceException;

    public State removeState(String state) throws FlooringMasteryPersistenceException;

    public State getState(String state) throws FlooringMasteryPersistenceException;

    public List<State> getAllStates() throws FlooringMasteryPersistenceException;

    public void openStateDao() throws FlooringMasteryPersistenceException;

}
  

// Week 5 - SShandonay 
