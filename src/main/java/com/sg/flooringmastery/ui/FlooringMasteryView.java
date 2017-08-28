/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.ui;

import static com.sg.flooringmastery.dao.FlooringMasteryOrderDaoImpl.DELIMITER;
import com.sg.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.dao.FlooringMasteryProductTypeDao;
import com.sg.flooringmastery.dao.FlooringMasteryProductTypeDaoImpl;
import com.sg.flooringmastery.dao.FlooringMasteryStateDao;
import com.sg.flooringmastery.dao.FlooringMasteryStateDaoImpl;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.ProductType;
import com.sg.flooringmastery.dto.State;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class FlooringMasteryView {

    FlooringMasteryUserIO io = new FlooringMasteryUserIOImpl();
//    FlooringMasteryStateDao stateDao = new FlooringMasteryStateDaoImpl();
//    FlooringMasteryProductTypeDao productTypeDao = new FlooringMasteryProductTypeDaoImpl();

    public FlooringMasteryView(FlooringMasteryUserIO io, FlooringMasteryStateDao stateDao, FlooringMasteryProductTypeDao productTypeDao) {
        this.io = io;
//        this.stateDao = stateDao;
//        this.productTypeDao = productTypeDao;
    }

    public int printMenuAndGetSelection() {

        io.print("<< Welcome to the SWC Flooring Program! >>");
        io.print("1. Display Orders");
        io.print("2. Add an Order");
        io.print("3. Edit an Order");
        io.print("4. Remove an Order");
        io.print("5. Save Current Work");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }

    public Order getNewOrderInfo(List<State> stateOptions, List<ProductType> productTypeOptions) throws FlooringMasteryPersistenceException {
        LocalDate orderDate = getOrderDate();
        String customerName = io.readString("Please enter Customer Name.");
        String state = getState(stateOptions);
        String productType = getProductType(productTypeOptions);
        BigDecimal area = io.stringToBigDecimal("Please enter area.");

        Order currentOrder = new Order();
        currentOrder.setOrderDate(orderDate);
        currentOrder.setCustomerName(customerName);
        currentOrder.setState(state);
        currentOrder.setProductType(productType);
        currentOrder.setArea(area);
        currentOrder.setOrderNum(null);

        return currentOrder;

    }

    public boolean printOrderInfo(Order order) {
        if (order != null) {
            io.print("===============================================================");
            io.print("Order Summary ");
            io.print("Order Date: " + order.getOrderDate() + " | Customer: " + order.getCustomerName());
            io.print("===============================================================");
            io.print("State: " + order.getState() + " | Tax Rate: $" + order.getTaxRate());
            io.print("Material: " + order.getProductType() + " | Material Cost Per Sq Ft: $" + order.getCostPerSquareFoot() + " | Order Total Material Cost: $" + order.getMaterialCost());
            io.print("Area: " + order.getArea() + " | Labor Cost Per Sq Ft: $" + order.getLaborCostPerSquareFoot() + " | Order Total Labor Cost: $" + order.getLaborCost());
            io.print("----------------------------------------------------------------");
            io.print("Tax: $" + order.getTax() + " | Total: $" + order.getTotal());
            io.print(" ");

        } else {
            io.print("No Order exists.");
        }
        boolean validResponse = false;
        boolean saveData = false;
        while (validResponse == false) {
            String commitChoice = io.readString("Would you like to Commit Order? (Y or N)");
            if (commitChoice.equalsIgnoreCase("Y")) {
                validResponse = true;
                saveData = true;
                io.print("Order has been committed");
            } else if (commitChoice.equalsIgnoreCase("N")) {
                validResponse = true;
                io.print("Order not committed");
            } else {
                io.print("Please enter Y or N");
            }
        }
        return saveData;
    }

    public LocalDate getOrderDate() {

        String stringDate = io.readString("Please enter an order date (MM/DD/YYYY).");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        boolean validDate = false;
        do {
            try {
                formatter.parse(stringDate);
                validDate = true;
            } catch (DateTimeParseException ex) {
                io.print("Incorrect Date entered");
                stringDate = io.readString("Please enter an order date (MM/DD/YYYY).");
            }
        } while (validDate == false);
        LocalDate date = LocalDate.parse(stringDate, formatter);
        return date;

    }

    private String getState(List<State> stateList) throws FlooringMasteryPersistenceException {
        String state = "";
        String stateListPrompt = "Please Enter An Order State";
        int iterator = 0;
        Boolean keepGoing = true;

        for (int j = 0; j <= stateList.size() - 1; j++) {
            stateListPrompt += " - " + stateList.get(j).getState();

        }

        while (keepGoing) {

            state = io.readString(stateListPrompt);

            for (State currentState : stateList) {
                if (currentState.getState().equalsIgnoreCase(state)) {
                    keepGoing = false;
                    iterator = 1;
                    state = currentState.getState();
                }
            }
            if (iterator == 0) {
                io.print("State Invalid - (Order can not be placed for that State)");
            }
        }
        return state;
    }

    private String getProductType(List<ProductType> productList) throws FlooringMasteryPersistenceException {
        String productType = "";
        boolean keepGoing = true;
        int iterator = 0;

        while (keepGoing) {

            String productTypePrompt = "Please Enter a Product Type";
            for (ProductType p : productList) {
                productTypePrompt += " - " + p.getProductType();
            }
            productType = io.readString(productTypePrompt);
            for (ProductType currentProductType : productList) {
                if (currentProductType.getProductType().equalsIgnoreCase(productType)) {
                    keepGoing = false;
                    iterator = 1;
                    return currentProductType.getProductType();
                }
            }
            if (iterator == 0) {
                io.print("Product Type Invalid - (Order can not be placed for that Product)");

            }

        }
        return productType;
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!");
    }

    public void exitMessage() {
        io.print("Thanks for shopping!");
    }

    public void createOrderBanner() {
        io.print("==== Create Order ====");

    }

    public void displayErrorMessage(String errorMsg) {
        io.print("==== Error ====");
        io.print(errorMsg);
    }

    public void displayAllOrdersByDateBanner() {
        io.print("=== Order Date: Orders ===");
    }

    public void displayOrdersOfDate(List<Order> orderList) {
        LocalDate userInputDate = getOrderDate();
        int counter = 0;
        for (Order order : orderList) {
            if (userInputDate.equals(order.getOrderDate())) {
                counter++;

                io.print("===============================================================");
                io.print("Summary for Order ID: " + order.getOrderNum());
                io.print("Order Date: " + order.getOrderDate() + " | Customer: " + order.getCustomerName());
                io.print("===============================================================");
                io.print("State: " + order.getState() + " | Tax Rate: $" + order.getTaxRate());
                io.print("Material: " + order.getProductType() + " | Material Cost Per Sq Ft: $" + order.getCostPerSquareFoot() + " | Order Total Material Cost: $" + order.getMaterialCost());
                io.print("Area: " + order.getArea() + " | Labor Cost Per Sq Ft: $" + order.getLaborCostPerSquareFoot() + " | Order Total Labor Cost: $" + order.getLaborCost());
                io.print("----------------------------------------------------------------");
                io.print("Tax: $" + order.getTax() + " | Total: $" + order.getTotal());
                io.print(" ");

            }

        }
        if (counter == 0) {
            io.print("No orders found");
        }
    }

    public Order getOrderToModify(List<Order> orderList) {
        displayOrdersOfDate(orderList);
        int orderNumToModify = io.readInt("Please enter the Order # you would like to modify");
        Order orderToModify = new Order();
        for (Order o : orderList) {
            if (orderNumToModify == o.getOrderNum()) {
                orderToModify = o;
            }
        }

        return orderToModify;
    }

    public Order getModifiedOrderInfo(Order order) {

        String newCustomerName = io.readString("Enter Customer Name (" + order.getCustomerName() + "): ");
        if (newCustomerName.length() > 0) {
            order.setCustomerName(newCustomerName);
        }
        String newState = io.readString("Enter Order State: (" + order.getState() + "): ");
        if (newState.length() > 0) {
            order.setState(newState);
        }
        BigDecimal newTaxRate = io.stringToBigDecimalEdit("Enter TaxRate: (" + order.getTaxRate() + "): ");
        if (newTaxRate != null) {
            order.setTaxRate(newTaxRate);
        }

        String newProductType = io.readString("Enter Product Type: (" + order.getProductType() + "): ");
        if (newProductType.length() > 0) {
            order.setProductType(newProductType);
        }

        BigDecimal newArea = io.stringToBigDecimalEdit("Enter Area: (" + order.getArea() + "): ");
        if (newArea != null) {
            order.setArea(newArea);
        }

        BigDecimal newCostPerSqFt = io.stringToBigDecimalEdit("Enter Material Cost Per Sq Ft: (" + order.getCostPerSquareFoot() + "): ");
        if (newCostPerSqFt != null) {
            order.setCostPerSquareFoot(newCostPerSqFt);
        }

        BigDecimal newLaborCostPerSqFt = io.stringToBigDecimalEdit("Enter Labor Cost Per Sq Ft: (" + order.getLaborCostPerSquareFoot() + "): ");
        if (newLaborCostPerSqFt != null) {
            order.setLaborCostPerSquareFoot(newLaborCostPerSqFt);
        }

        BigDecimal newMaterialCost = io.stringToBigDecimalEdit("Enter Material Cost: (" + order.getMaterialCost() + "): ");
        if (newMaterialCost != null) {
            order.setMaterialCost(newMaterialCost);
        }

        BigDecimal newLaborCost = io.stringToBigDecimalEdit("Enter Labor Cost: (" + order.getLaborCost() + "): ");
        if (newLaborCost != null) {
            order.setLaborCost(newLaborCost);
        }

        BigDecimal newTotalTax = io.stringToBigDecimalEdit("Enter Total Tax: (" + order.getTax() + "): ");
        if (newTotalTax != null) {
            order.setTax(newTotalTax);
        }

        BigDecimal newOrderTotal = io.stringToBigDecimalEdit("Enter Order Total: (" + order.getTotal() + "): ");
        if (newOrderTotal != null) {
            order.setTotal(newOrderTotal);
        }
        return order;

    }

    public Order getOrderToRemove(List<Order> orderList) {
        displayOrdersOfDate(orderList);
        int orderNumToRemove = io.readInt("Please enter the Order # you would like to remove");
        Order orderToRemove = new Order();
        for (Order o : orderList) {
            if (orderNumToRemove == o.getOrderNum()) {
                orderToRemove = o;
            }
        }

        return orderToRemove;
    }
}


// Week 5 - SShandonay 
