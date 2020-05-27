package com.martynas.Shop;

import com.martynas.Commodity;
import com.martynas.DesignPatterns.CommodityIterator;
import com.martynas.Interfaces.Shop;
import com.martynas.Inventory;

import java.io.Serializable;
import java.util.Iterator;

public class ShopInventory extends Inventory implements Shop, Serializable {

    private String name;
    public String getName(){ return name; }
    private float balance;
    public float getBalance(){ return balance; }


    public ShopInventory(String name){
        this.name=name;
        this.balance=0;
    }


    /**
     *  Sell Item
     * @param index item's index in the List
     * @param amount amount to sell
     */
    public void sellItem(int index, int amount){
        if(getListSize()>index && getCommodity(index).getAmount()>amount) {
            balance+=getCommodity(index).getPrice()*amount;
            removeItem(index,amount);
            return;
        }
    }

    /**
     * Sell item
     * @param name item's name to sell
     * @param amount amount to sell
     */
    public void sellItem(String name, int amount){
        if(getCommodity(name)!=null && getCommodity(name).getAmount()>amount) {
            balance += getCommodity(name).getPrice() * amount;
            removeItem(name, amount);
        }
    }

    public void addGlobalPrice(float amount){
        Iterator iterator = CommodityIterator.forCommodities(getInventory());
        while(iterator.hasNext()){
            ((Commodity) iterator.next()).addPrice(amount);
        }

    }

    /**
     * Clone object
     * @return super.clone()
     * @throws CloneNotSupportedException
     */
    public Object clone() throws
            CloneNotSupportedException
    {
        return super.clone();
    }

}