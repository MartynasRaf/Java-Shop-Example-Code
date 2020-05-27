package com.martynas.Exceptions;

/**
 * Handle Exceptions related to customer
 */
public class CustomerException extends Exception {

    private double priceDif =0;
    public double getPriceDif(){return priceDif;}

    public CustomerException(String message){
        super(message);
    }

    /**
     * Handle case when customer lacks balance to buy items
     * @param message Message to show
     * @param priceDif (balance)-(Item price)
     */
    public CustomerException(String message, double priceDif){
        super(message+" Price difference: "+Double.toString(priceDif));
    }


}
