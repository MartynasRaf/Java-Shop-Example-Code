package com.martynas;

import java.util.*;

public abstract class Inventory {

    private List<Commodity> items = new ArrayList<>();


    /**
     * Add Item to storage
     * @param name name of the item
     * @param amount amount to add
     */
    public void addItem(String name, int amount){
        for (int i=0;i<items.size();i++){
            if(items.get(i).getName().equals(name)){
                items.get(i).increaseAmount(amount);
                return;
            }
        }
        items.add(new Commodity(name,amount));
    }

    /**
     * Add item to storage
     * @param name name of the item
     * @param price price of the item
     * @param amount amount to add
     */
    public void addItem(String name, float price, int amount){
        for (int i=0;i<items.size();i++){
            if(items.get(i).getName().equals(name)){
                items.get(i).increaseAmount(amount);
                return;
            }
        }
        items.add(new Commodity(name,amount,price));
    }

    /**
     * Remove item from the List
     * @param name name of the item
     * @param amount amount to add
     */
    public void removeItem(String name, int amount){
        for (int i=0;i<items.size();i++){
            if(items.get(i).getName().equals(name)){
                items.get(i).decreaseAmount(amount);
                if(items.get(i).getAmount()<1){
                    items.remove(i);
                }
                return;
            }
        }
    }

    /**
     * Remove item from the list
     * @param index item's index
     * @param amount amount to add
     */
    public void removeItem(int index, int amount){
        if(items.size()>index) {
            items.get(index).decreaseAmount(amount);
            if(items.get(index).getAmount()<1){
                items.remove(index);
            }
        }
        return;
    }


    /**
     * Get commodity based on position in the list
     * @param index index of the item in the list
     * @return
     */
    public Commodity getCommodity(int index){
        if(items.size()>index) {
            return items.get(index);
        }
        return null;
    }

    /**
     * Get item based on it's name
     * @param name name of the item
     * @return
     */
    public Commodity getCommodity(String name){
        for (int i=0;i<getListSize();i++){
            if(getCommodity(i).getName().equals(name)) {
                return getCommodity(i);
            }
        }
        return null;
    }

    public int getListSize(){
        return items.size();
    }

    public List<Commodity> getInventory(){
        return Collections.unmodifiableList(items);
    }

    public float getInventoryPrice(){
        float sum=0;

        for (int i=0;i<items.size();i++){
            if(items.get(i).getAmount()!=0) {
                sum += items.get(i).getPrice() * items.get(i).getAmount();
            }
        }

        return sum;
    }


}
