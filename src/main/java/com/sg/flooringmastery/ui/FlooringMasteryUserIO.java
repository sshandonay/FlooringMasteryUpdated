/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.ui;

import java.math.BigDecimal;

/**
 *
 * @author apprentice
 */
public interface FlooringMasteryUserIO {

    BigDecimal stringToBigDecimal(String input);

    void print(String msg);

    int stringToInt(String input);

    String readString(String prompt);

    int readInt(String prompt);

    int readInt(String prompt, int min, int max);

    public BigDecimal stringToBigDecimalEdit(String prompt);

}


// Week 5 - SShandonay 
