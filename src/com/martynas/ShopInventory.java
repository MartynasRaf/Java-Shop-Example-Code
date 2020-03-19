package com.martynas;

public class ShopInventory extends Inventory {

    private String name;
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
        if(getListSize()>index) {
            balance+=getCommodity(index).getPrice()*amount;
            removeItem(index,amount);
        }
    }

    /**
     * Sell item
     * @param name item's name to sell
     * @param amount amount to sell
     */
    public void sellItem(String name, int amount){
            balance+=getCommodity(name).getPrice()*amount;
            removeItem(name,amount);
    }



}
