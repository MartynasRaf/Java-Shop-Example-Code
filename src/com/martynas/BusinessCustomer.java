package com.martynas;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class BusinessCustomer extends CustomerInventory implements Customer {

    public String name;
    public String getName(){return name;};
    private int id;
    public int getId(){return id;}
    //public CustomerInventory inventory;
    float balance=0;
    public float getBalance(){ return balance; }

    public BusinessCustomer(ShopInventory shopInventory, float balance){
        setShopInventory(shopInventory);
        this.balance=balance;
        this.id=0;//ThreadLocalRandom.current().nextInt(0, 2 + 1);
    }

    public BusinessCustomer(String name, ShopInventory shopInventory, float balance){
        setShopInventory(shopInventory);
        this.balance=balance;
        this.name=name;
        this.id=ThreadLocalRandom.current().nextInt(0, 2 + 1);
    }

    @Override
    public float getAllProductsPriceSum() {
        return getInventoryPrice()/1.21f;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) {
            return false;
        }
        Customer that = (Customer) o;
        if(id==that.getId() && balance==that.getBalance()) {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}