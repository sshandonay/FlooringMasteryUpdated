/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.ui;

import com.sg.flooringmastery.dto.Order;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class FlooringMasteryUserIOImpl implements FlooringMasteryUserIO {

    Scanner inputReader = new Scanner(System.in);

    @Override
    public BigDecimal stringToBigDecimal(String prompt) {
        System.out.println(prompt);
        //  inputReader.nextLine();
        String input = inputReader.nextLine();
        BigDecimal userInput = new BigDecimal("0.0");
        boolean validEntry = false;
        while (!validEntry) {
            try {
                userInput = new BigDecimal(input);
                validEntry = true;
            } catch (NumberFormatException e) {
                System.out.println("Entry was invalid");
                input = inputReader.nextLine();
            }
        }

        return userInput;
    }

    @Override
    public BigDecimal stringToBigDecimalEdit(String prompt) {
        System.out.println(prompt);
        //  inputReader.nextLine();
        String input = inputReader.nextLine();
        BigDecimal userInput = new BigDecimal("0.0");
        if (input.equals("")) {
            return null;
        } else {
            boolean validEntry = false;
            while (!validEntry) {
                try {
                    userInput = new BigDecimal(input);
                    validEntry = true;
                } catch (NumberFormatException e) {
                    System.out.println("Entry was invalid");
                    input = inputReader.nextLine();
                }
            }
        }
        return userInput;
    }

    @Override
    public int stringToInt(String input) {
        int userInput = Integer.parseInt(input);
        return userInput;
    }

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);

        String userInput = inputReader.nextLine();
        return userInput;
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        int inter = Integer.parseInt(inputReader.nextLine());
        return inter;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int inter;
        do {
            System.out.println(prompt);
            inter = Integer.parseInt(inputReader.nextLine());
        } while (inter < min || inter > max);
        return inter;
    }

}


// Week 5 - SShandonay 
