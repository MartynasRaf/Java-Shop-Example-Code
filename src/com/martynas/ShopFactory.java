package com.martynas;

public class ShopFactory {

    public static Shop createShop(String name) {
        return new ShopInventory(name);
    }

}
