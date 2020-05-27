package com.martynas.Exceptions;

import java.io.IOException;
import java.util.Scanner;

public class ShopDoesNotExistException extends Exception {

    public ShopDoesNotExistException(String errorMessage){

        super(errorMessage);
    }


}
