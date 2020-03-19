package com.martynas;

public class Commodity {

    private String name;
    private int amount;
    private float price;

    public String getName(){
        return name;
    }

    public Commodity(String name, int amount, float price){
        this.name=name;
        this.amount=amount;
        this.price=price;
    }

    public Commodity(String name, int amount){
        this.name=name;
        this.amount=amount;
    }

    public Commodity(String name, float price){
        this.name=name;
        this.price=price;
    }


    public int getAmount(){
        return amount;
    }

    public  float getPrice(){
        return price;
    }

    public void increaseAmount( int amountToIncrease){
        amount+=amountToIncrease;
    }

    public void decreaseAmount( int amountToDecrease){
        amount-=amountToDecrease;
    }



}
