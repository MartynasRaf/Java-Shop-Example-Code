package com.martynas.Customer;

import com.martynas.Exceptions.CustomerException;
import com.martynas.Interfaces.Customer;
import com.martynas.Inventory;
import com.martynas.Shop.ShopInventory;

import java.util.concurrent.ThreadLocalRandom;

public class CustomerInventory extends Inventory implements Customer {

    public float balance;
    public String name;
    private int id;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getBalance() {
        return balance;
    }

    public int getId(){return id;}

    @Override
    public float getInventoryPriceTotal() {
        return getInventoryPrice();
    }

    @Override
    public float getVat() {
        return getInventoryPrice()/1.21f;
    }


    private ShopInventory shopInventory;
    public ShopInventory getShopInventory()  {
        return shopInventory;
    }

    @Override
    public void changeBalance(float change) {

    }

    /**
     * Set shop for customer
     * @param shopInv
     */
    public void setShopInventory(ShopInventory shopInv){ shopInventory=shopInv;}

    public CustomerInventory(String name, ShopInventory shopInventory, float balance){
        setShopInventory(shopInventory);
        this.balance=balance;
        this.name=name;
        this.id= ThreadLocalRandom.current().nextInt(0, 2 + 1);
    }

    /**
     * Buy everything in the inventory from store
     * @param c
     * @return
     */
    public int buyStorage(Customer c) throws CustomerException {
        if (getListSize()==0){
            throw new CustomerException("CustomerException: No items in inventory");
        }

        for (int i = 0; i< shopInventory.getListSize(); i++){
            for (int k=0;k<getListSize();k++) {
                if (shopInventory.getCommodity(i).getName().equals(getCommodity(k).getName())){
                    if(getCommodity(k).getAmount()*shopInventory.getCommodity(k).getPrice()>c.getBalance()) {
                        throw new CustomerException("CustomerException: Not enough money in customer balance",c.getBalance()-getCommodity(k).getAmount()*shopInventory.getCommodity(k).getPrice());
                    }

                    c.changeBalance(-getCommodity(k).getAmount()*shopInventory.getCommodity(k).getPrice());

                    shopInventory.sellItem(i,getCommodity(k).getAmount());

                }
            }
        }
        return 0;
    }

    /**
     * Add item to List
     * @param name Item's name
     * @param amount Amount to add
     */

    @Override
    public void addItem(String name, int amount){
        for (int i = 0; i< shopInventory.getListSize(); i++){
                if (shopInventory.getCommodity(i).getName().equals(name)){
                    super.addItem(name, shopInventory.getCommodity(i).getPrice(),amount);
                    return;

            }
        }
    }

    /**
     * Add item to List
     * @param name Item's name
     * @param price Item's price
     * @param amount amount to add
     */
    @Override
    public void addItem(String name, float price, int amount){
        this.addItem(name,amount);
    }


}
