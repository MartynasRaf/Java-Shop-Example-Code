package com.martynas.DesignPatterns;

import com.martynas.Interfaces.Shop;
import com.martynas.Shop.ShopInventory;

public class ShopFactory {

    /**
     * Create Shop Object
     * @param name Name of the shop
     * @return
     */
    public static Shop createShop(String name) {
        return new ShopInventory(name);
    }

}
