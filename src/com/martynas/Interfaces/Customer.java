package com.martynas.Interfaces;

import com.martynas.Commodity;
import com.martynas.Exceptions.CustomerException;
import com.martynas.Shop.ShopInventory;

import java.util.List;

public interface Customer {

    /**
     * Get name of the customer
     * @return
     */
    String getName();

    /**
     * Get customer's money amount (ambiguous currency)
     * @return
     */
    float getBalance();

    /**
     * Get customer's id
     * @return
     */
    int getId();

    /**
     * Get customer's shopping inventory price total
     * @return
     */
    float getInventoryPriceTotal();

    /**
     * Get VAT of the shopping inventory
     * @return
     */
    float getVat();

    /**
     * Add item to customer's inventory
     * @param name name of the item, must exist in Shop's inventory
     * @param amount amount of item to add
     */
    void addItem(String name, int amount);

    /**
     * Buy everything that exists in the inventory
     * @return error codes: 1- not enough money, 2- empty shopping cart, 0- operation successful
     */
    int buyStorage(Customer c) throws CustomerException;

    /**
     * Remove item from inventory
     * @param name name of the item
     * @param amount amount to remove
     */
    void removeItem(String name, int amount);

    /**
     * Remove item from inventory
     * @param index index of the item
     * @param amount amount to remove
     */
    void removeItem(int index, int amount);

    /**
     * Get amount of different Commodities in the inventory
     * @return positive int
     */
    int getListSize();

    /**
     * Get whole shops inventory, throws exception
     * @return Shop Inventory (clone)
     */
    ShopInventory getShopInventory();

    /**
     * Get a copy of customer's inventory
     * @return List<Commodity>
     */
    List<Commodity> getInventory();

    /**
     * Get Commodity from inventory
     * @param name name of Commodity
     * @return Commodity
     */
    Commodity getCommodity(String name);

    /**
     * Get Commodity from inventory
     * @param index index of Commodity
     * @return Commodity
     */
    Commodity getCommodity(int index);

    /**
     * Change customer's balance
     * @param change
     */
    void changeBalance(float change);

    }
