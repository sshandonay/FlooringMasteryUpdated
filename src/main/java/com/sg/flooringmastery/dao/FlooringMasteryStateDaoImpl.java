/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.State;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class FlooringMasteryStateDaoImpl implements FlooringMasteryStateDao {

    private Map<String, State> stateInfo = new HashMap<>();
    public static final String STATETAXES_FILE = "StateTaxes.txt";
    public static final String DELIMITER = ",";

    @Override
    public State addState(String stateName, State state) throws FlooringMasteryPersistenceException {

        State addState = stateInfo.put(stateName, state);
        return addState;

    }

    @Override
    public State editState(String stateName, State state) throws FlooringMasteryPersistenceException {

        State editState = stateInfo.put(stateName, state);
        return editState;

    }

    @Override
    public State removeState(String state) throws FlooringMasteryPersistenceException {

        State removeState = stateInfo.remove(state);
        return removeState;

    }

    @Override
    public State getState(String state) throws FlooringMasteryPersistenceException {

        openStateDao();
        return stateInfo.get(state);

    }

    @Override
    public List<State> getAllStates() throws FlooringMasteryPersistenceException {

        openStateDao();
        return new ArrayList<State>(stateInfo.values());
    }

    @Override
    public void openStateDao() throws FlooringMasteryPersistenceException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(STATETAXES_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryPersistenceException("Could not load State Tax Rates.", e);
        }
        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentTokens = currentLine.split(DELIMITER);

            State currentState = new State(currentTokens[0]);

            currentState.setTax(new BigDecimal(currentTokens[1]));

            stateInfo.put(currentState.getState(), currentState);
        }

        scanner.close();
    }

} 
    

   // Week 5 - SShandonay 
