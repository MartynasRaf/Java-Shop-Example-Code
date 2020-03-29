package com.martynas;

/**
 * Martynas Rafanavicius, pirkejas parduotuvej gali pirkti daiktus is parduotuves
 * Klase storage turi vaikus Customer ir Shop, nes jiems reikia Storint'i prekes
 */

public class Main {

    public static void main(String[] args) {

        ShopInventory smallShopInventory = new ShopInventory("Maksima");

        RegularCustomerInventory regularCustomerInventory = new RegularCustomerInventory(smallShopInventory,12);

        BusinessCustomerInventory businessCustomerInventory = new BusinessCustomerInventory(smallShopInventory,90);

        //TextUI ui = new TextUI(businessCustomerInventory);

        smallShopInventory.addItem("Eggs",3,100);
        smallShopInventory.addItem("Potatoes", 0.7f,100);
        smallShopInventory.addItem("Ramen", 0.3f,100);
        smallShopInventory.addItem("Koka kola", 1.3f,100);
        smallShopInventory.addItem("Chips", 1.45f,100);

       //ui.customerTextUI();

        Customer b = regularCustomerInventory;

        b.addItem("Eggs",4);

        System.out.println(b.getInventoryPriceTotal());
        System.out.println(b.getBalance());
        System.out.println(b.buyInventory());
        System.out.println(b.getBalance());


    }
}
