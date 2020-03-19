package com.martynas;

import java.util.Scanner;
import java.text.DecimalFormat;



public class TextUI {

    private static DecimalFormat df = new DecimalFormat("0.00");


    CustomerInventory customerInventory;
    Scanner scanner;

    public TextUI(CustomerInventory customerInventory){
        this.customerInventory = customerInventory;
        scanner = new Scanner(System.in);
    }


    public void customerTextUI(){

        String input="";

        while (!input.equals("0")) {

            System.out.println("Available actions: \n" +
                    "LB- list all items in your shopping bag\n" +
                    "LS- list all items in shop\n" +
                    "A- add item to your shopping bag\n" +
                    "P- get shopping bag price" +
                    "R- remove bag from your shopping bag\n" +
                    "B - buy and quit\n");


            input=scanner.nextLine();

            if(input.equals("LB")){
                 listCustomerShoppingBag();
                 continue;
            }

             if(input.equals("LS")) {
                 listShopStorage();
                 continue;
             }

            if(input.equals("P")) {
                getShoppingBagPrice();
                continue;
            }

            if(input.equals("B")){
                customerInventory.buyStorage();
                break;
            }

             String name;
             int amount;

            System.out.println("Your item: \n");
            name=scanner.nextLine();

            System.out.println("Amount: \n");
            amount=Integer.parseInt(scanner.nextLine());

            if(input.equals("A")){
                customerInventory.addItem(name,amount);
                continue;
            }

            if(input.equals("R")) {
                customerInventory.removeItem(name, amount);
                continue;
            }

         }
    }

    public void listCustomerShoppingBag(){
        for (int i = 0; i< customerInventory.getListSize(); i++){
            System.out.println(i+": "+ customerInventory.getCommodity(i).getName()+" x "+ customerInventory.getCommodity(i).getAmount()+"\n");
        }
    }

    public void listShopStorage(){
        for (int i = 0; i< customerInventory.getShopInventory().getListSize(); i++){
            System.out.println(i+": "+ customerInventory.getShopInventory().getCommodity(i).getName()+", price: "+ customerInventory.getShopInventory().getCommodity(i).getPrice()+"€\n");
        }
    }

    public void getShoppingBagPrice(){
        System.out.println(df.format(customerInventory.getAllProductsPriceSum()));
    }


}
