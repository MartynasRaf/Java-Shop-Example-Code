package com.martynas;

/**
 * Martynas Rafanavicius, pirkejas parduotuvej gali pirkti daiktus is parduotuves
 * Klase storage turi vaikus Customer ir Shop, nes jiems reikia Storint'i prekes
 */

public class Main {

    public static void main(String[] args) {

        ShopInventory smallShopInventory = new ShopInventory("Maksima");

        RegularCustomerInventory regularCustomerInventory = new RegularCustomerInventory(smallShopInventory,90);

        BusinessCustomer businessCustomer = new BusinessCustomer(smallShopInventory,90);

        if(regularCustomerInventory.equals(businessCustomer)){
            System.out.println("Same");
        }

        TextUI ui = new TextUI(businessCustomer);

        smallShopInventory.addItem("Eggs",3,100);
        smallShopInventory.addItem("Potatoes", 0.7f,100);
        smallShopInventory.addItem("Ramen", 0.3f,100);
        smallShopInventory.addItem("Koka kola", 1.3f,100);
        smallShopInventory.addItem("Chips", 1.45f,100);

        ui.customerTextUI();

    }
}
