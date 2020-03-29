package com.martynas;

import java.util.List;

public interface Customer {


    String getName();
    float getBalance();
    int getId();
    float getInventoryPriceTotal();
    float getVat();
    void addItem(String name, int amount);
    int buyInventory();
    void removeItem(String name, int amount);
    void removeItem(int index, int amount);
    int getListSize();
    ShopInventory getShopInventory();
    List<Commodity> getInventory();
    Commodity getCommodity(String name);
    Commodity getCommodity(int index);
    void changeBalance(float change);

    }
