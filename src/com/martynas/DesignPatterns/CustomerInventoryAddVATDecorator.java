package com.martynas.DesignPatterns;

import com.martynas.Commodity;
import com.martynas.Exceptions.CustomerException;
import com.martynas.Interfaces.Customer;
import com.martynas.Shop.ShopInventory;

import java.util.List;

public class CustomerInventoryAddVATDecorator implements Customer {

    private Customer baseCustomerInv;

    public CustomerInventoryAddVATDecorator(Customer baseCustomerInv){
        this.baseCustomerInv=baseCustomerInv;
    }

    @Override
    public String getName() {
        return baseCustomerInv.getName();
    }

    @Override
    public float getBalance() {
        return baseCustomerInv.getBalance();
    }

    @Override
    public int getId() {
        return baseCustomerInv.getId();
    }

    @Override
    public float getInventoryPriceTotal() {
        return baseCustomerInv.getInventoryPriceTotal()*1.21f;
    }

    @Override
    public float getVat() {
        return baseCustomerInv.getVat();
    }

    @Override
    public void addItem(String name, int amount) {
        baseCustomerInv.addItem(name,amount);
    }

    @Override
    public int buyStorage(Customer c) {
        int ret=0;
        try {
             ret = baseCustomerInv.buyStorage(c);
        } catch (CustomerException ex){
            System.out.println(ex.getMessage());
        }
        return ret;
    }

    @Override
    public void removeItem(String name, int amount) {
        baseCustomerInv.removeItem(name,amount);
    }

    @Override
    public void removeItem(int index, int amount) {
        baseCustomerInv.removeItem(index,amount);
    }

    @Override
    public int getListSize() {
       return baseCustomerInv.getListSize();
    }

    @Override
    public ShopInventory getShopInventory() {
        return baseCustomerInv.getShopInventory();
    }

    @Override
    public List<Commodity> getInventory() {
        return baseCustomerInv.getInventory();
    }

    @Override
    public Commodity getCommodity(String name) {
        return baseCustomerInv.getCommodity(name);
    }

    @Override
    public Commodity getCommodity(int index) {
        return baseCustomerInv.getCommodity(index);
    }

    @Override
    public void changeBalance(float change) {
        baseCustomerInv.changeBalance(change);
    }
}
