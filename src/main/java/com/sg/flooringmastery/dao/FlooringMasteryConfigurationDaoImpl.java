/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import static com.sg.flooringmastery.dao.FlooringMasteryOrderDaoImpl.DELIMITER;
import static com.sg.flooringmastery.dao.FlooringMasteryOrderDaoImpl.ORDERS_FOLDER;
import com.sg.flooringmastery.dto.Order;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class FlooringMasteryConfigurationDaoImpl implements FlooringMasteryConfigurationDao {

    public static final String CONFIG_FILE = "configurationFile.txt";
    public static final String DELIMITER = ",";

    @Override
    public String readConfigDao() throws FlooringMasteryPersistenceException {
        String configuration = "";
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(CONFIG_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryPersistenceException("Could not load Configuration", e);
        }
        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentLine = currentLine.substring(17, 20);

            configuration = currentLine;

        }
        scanner.close();

        return configuration;

    }

}


// Week 5 - SShandonay 
