package com.martynas;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class RegularCustomerInventory extends CustomerInventory implements Customer {

    public String name;
    public String getName(){return name;}
    private int id;
    public int getId(){return id;}
    //public CustomerInventory inventory;
    float balance=0;
    public float getBalance(){ return balance; }

    public RegularCustomerInventory(ShopInventory shopInventory, float balance){
        setShopInventory(shopInventory);
        this.balance=balance;
        this.id=ThreadLocalRandom.current().nextInt(0, 2 + 1);
    }

    public RegularCustomerInventory(String name, ShopInventory shopInventory, float balance){
        setShopInventory(shopInventory);
        this.balance=balance;
        this.name=name;
        this.id=ThreadLocalRandom.current().nextInt(0, 2 + 1);
    }

    @Override
    public float getInventoryPriceTotal() {
        return getInventoryPrice();
    }

    public void changeBalance(float change){
        balance+=change;
    }

    public int buyInventory(){
        return buyStorage(this);
    }

    public float getVat(){
        return getInventoryPrice()*0.21f;
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
