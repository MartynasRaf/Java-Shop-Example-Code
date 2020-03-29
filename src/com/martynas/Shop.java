package com.martynas;

public interface Shop {

    String getName();
    float getBalance();
    void addItem(String name, float price, int amount);
    void sellItem(int index, int amount);
    void sellItem(String name, int amount);

}
