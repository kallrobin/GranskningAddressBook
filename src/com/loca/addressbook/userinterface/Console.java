package com.loca.addressbook.userinterface;

public class Console implements ConsolePrinter {

    public void registerInputHandler () {

    }

    @Override
    public void print(String output) {
        System.out.println(output);
    }

}
