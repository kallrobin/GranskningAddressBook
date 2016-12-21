package com.loca.addressbook;

import com.loca.addressbook.registry.Registry;
import com.loca.addressbook.remoteregistry.CatalogueLoader;
import com.loca.addressbook.remoteregistry.RemoteRegistry;
import com.loca.addressbook.userinterface.CommandLineInterface;

public class Application {
    public void start() {
        Registry registry = new Registry();
        RemoteRegistry remoteRegistry = new RemoteRegistry();

        //Thread catalogueLoader = new Thread(new CatalogueLoader(remoteRegistry));
        //catalogueLoader.start();

        registry.load();

        new CommandLineInterface(registry);
        quit();
    }

    public void quit() {
        //do quit stuff
    }
}
