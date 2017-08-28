/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.ProductType;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface FlooringMasteryProductTypeDao {

    public ProductType addProductType(String productType, ProductType product) throws FlooringMasteryPersistenceException;

    public ProductType editProductType(String productType, ProductType product) throws FlooringMasteryPersistenceException;

    public ProductType removeProductType(String product) throws FlooringMasteryPersistenceException;

    public ProductType getProductType(String product) throws FlooringMasteryPersistenceException;

    public List<ProductType> getAllProductTypes() throws FlooringMasteryPersistenceException;

    public void openProductTypeDao() throws FlooringMasteryPersistenceException;

}
    

// Week 5 - SShandonay 