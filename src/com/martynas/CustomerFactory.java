package com.martynas;

public class CustomerFactory {

    public static Customer createBusinessCustomer(String name, ShopInventory shopInventory, float balance) {
        return new BusinessCustomerInventory(name, shopInventory, balance);
    }

    public static Customer createRegularCustomer(String name, ShopInventory shopInventory, float balance) {
        return new RegularCustomerInventory(name, shopInventory, balance);
    }




}
