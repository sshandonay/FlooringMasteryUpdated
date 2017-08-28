/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.ProductType;
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
public class FlooringMasteryProductTypeDaoImpl implements FlooringMasteryProductTypeDao {

    private Map<String, ProductType> productTypeInfo = new HashMap<>();
    public static final String PRODUCTTYPE_FILE = "ProductTypes.txt";
    public static final String DELIMITER = ",";

    @Override
    public ProductType addProductType(String productType, ProductType product) throws FlooringMasteryPersistenceException {

        ProductType addProductType = productTypeInfo.put(productType, product);
        return addProductType;

    }

    @Override
    public ProductType editProductType(String productType, ProductType product) throws FlooringMasteryPersistenceException {

        ProductType editProductType = productTypeInfo.put(productType, product);
        return editProductType;

    }

    @Override
    public ProductType removeProductType(String product) throws FlooringMasteryPersistenceException {

        ProductType removeProductType = productTypeInfo.remove(product);
        return removeProductType;

    }

    @Override
    public ProductType getProductType(String product) throws FlooringMasteryPersistenceException {

        openProductTypeDao();
        return productTypeInfo.get(product);

    }

    @Override
    public List<ProductType> getAllProductTypes() throws FlooringMasteryPersistenceException {

        openProductTypeDao();
        return new ArrayList<ProductType>(productTypeInfo.values());
    }

    @Override
    public void openProductTypeDao() throws FlooringMasteryPersistenceException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(PRODUCTTYPE_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryPersistenceException("Could not load Product Types", e);
        }
        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentTokens = currentLine.split(DELIMITER);

            ProductType currentProductType = new ProductType(currentTokens[0]);

            currentProductType.setCostPerSquareFoot(new BigDecimal(currentTokens[1]));

            currentProductType.setLaborCostPerSquareFoot(new BigDecimal(currentTokens[2]));

            productTypeInfo.put(currentProductType.getProductType(), currentProductType);
        }

        scanner.close();
    }

}
   

// Week 5 - SShandonay 
