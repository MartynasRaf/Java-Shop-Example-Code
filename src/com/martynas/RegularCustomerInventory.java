package com.martynas;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class RegularCustomerInventory extends CustomerInventory implements Customer {

    public String name;
    private int id;
    public int getId(){return id;}
    //public CustomerInventory inventory;
    float balance=0;
    public float getBalance(){ return balance; }

    public RegularCustomerInventory(ShopInventory shopInventory, float balance){
        setShopInventory(shopInventory);
        this.balance=balance;
        this.id=0;//ThreadLocalRandom.current().nextInt(0, 2 + 1);
    }

    public RegularCustomerInventory(String name, ShopInventory shopInventory, float balance){
        setShopInventory(shopInventory);
        this.balance=balance;
        this.name=name;
        this.id=ThreadLocalRandom.current().nextInt(0, 2 + 1);
    }

    @Override
    public float getAllProductsPriceSum() {
        return getInventoryPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Customer that = (Customer) o;
        if(id==that.getId() && balance==that.getBalance()) {
            return true;
        }
        if (this.hashCode()==o.hashCode()){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
