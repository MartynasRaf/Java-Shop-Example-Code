package com.martynas;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class BusinessCustomerInventory extends CustomerInventory implements Customer {

    public String name;
    public String getName(){return name;};
    private int id;
    public int getId(){return id;}
    //public CustomerInventory inventory;
    float balance=0;
    public float getBalance(){ return balance; }

    public BusinessCustomerInventory(ShopInventory shopInventory, float balance){
        setShopInventory(shopInventory);
        this.balance=balance;
        this.id=ThreadLocalRandom.current().nextInt(0, 2 + 1);
    }

    public BusinessCustomerInventory(String name, ShopInventory shopInventory, float balance){
        setShopInventory(shopInventory);
        this.balance=balance;
        this.name=name;
        this.id=ThreadLocalRandom.current().nextInt(0, 2 + 1);
    }

    @Override
    public float getInventoryPriceTotal() {
        return getInventoryPrice()/1.21f;
    }

    public void changeBalance(float change){
        balance+=change;
    }

    public int buyInventory(){
        return buyStorage(this);
    }

    public float getVat(){
        return 0;
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
