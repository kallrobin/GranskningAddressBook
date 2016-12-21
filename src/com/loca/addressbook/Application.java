package com.loca.addressbook;

import com.loca.addressbook.registry.Registry;
import com.loca.addressbook.userinterface.CommandLineInterface;

public class Application {
    public void start() {
        Registry registry = new Registry();
        registry.load();
        new CommandLineInterface(registry);
        quit();
    }

    public void quit() {
        //do quit stuff
    }
}
