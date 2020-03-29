package com.martynas;

public class ShopInventory extends Inventory implements Shop {

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



}
