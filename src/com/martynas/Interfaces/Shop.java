package com.martynas.Interfaces;

public interface Shop {

    /**
     * Get shop's name
     * @return String name
     */
    String getName();

    /**
     * Get Shop Balance from selling inventory
     * @return float
     */
    float getBalance();

    /**
     * Add Item to Shops storage
     * @param name Item's name
     * @param price Item's price
     * @param amount Amount of items
     */
    void addItem(String name, float price, int amount);

    /**
     * Sell Item
     * @param index index of item
     * @param amount amount of items to sell
     */
    void sellItem(int index, int amount);

    /**
     * Sell item
     * @param name name of the item
     * @param amount amount of items to sell
     */
    void sellItem(String name, int amount);

}
