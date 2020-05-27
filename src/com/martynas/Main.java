package com.martynas;

import com.martynas.Customer.CustomerInventory;
import com.martynas.DesignPatterns.CustomerInventoryAddVATDecorator;
import com.martynas.Exceptions.CustomerException;
import com.martynas.Exceptions.ShopDoesNotExistException;
import com.martynas.Interfaces.Customer;
import com.martynas.Shop.ShopInventory;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ShopDoesNotExistException {

        Scanner sc=new Scanner(System.in);
        ShopInventory smallShopInventory =null;

        try(ObjectInputStream in=new ObjectInputStream(new FileInputStream("shopInv.ser")))
        {


            smallShopInventory = (ShopInventory) in.readObject();


            System.out.println("Object has been deserialized ");

        }

        catch(IOException ex)
        {
            String input;

            System.out.println("Shop's Name: ");
            input=sc.nextLine();
            smallShopInventory=(ShopInventory) new ShopInventory(input);

            if(smallShopInventory==null || smallShopInventory.getName().isEmpty()){
                ex.printStackTrace();
                System.exit(0);
            }

        }

        catch(ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }

        smallShopInventory.getItemsFromCSV("aaa.csv");

        System.out.println(smallShopInventory.getListSize());

        Customer regularCustomer= new CustomerInventoryAddVATDecorator(new CustomerInventory("Pranas",smallShopInventory,500f));

        //regularCustomer.addItem("Eggs",5);

        smallShopInventory.addGlobalPrice(6);

        //regularCustomer.removeItem("Eggs",5);
        //regularCustomer.addItem("Eggs",5);

        try {
            regularCustomer.buyStorage(regularCustomer);
        }catch (CustomerException ex){
            System.out.println(ex.getMessage());
        }

        try
        {
            FileOutputStream file = new FileOutputStream("shopInv.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(smallShopInventory);

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        } catch(IOException ex)
        {
            ex.printStackTrace();
        }



    }
}