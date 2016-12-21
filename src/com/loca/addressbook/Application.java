package com.loca.addressbook;

import com.loca.addressbook.registry.AutoSave;
import com.loca.addressbook.registry.Registry;
import com.loca.addressbook.registry.RegistryPersister;
import com.loca.addressbook.remoteregistry.CatalogueLoader;
import com.loca.addressbook.remoteregistry.RemoteRegistry;
import com.loca.addressbook.userinterface.CommandLineInterface;

public class Application {
    public void start() {
        Registry registry = new Registry();
        RemoteRegistry remoteRegistry = new RemoteRegistry();
        RegistryPersister registryPersister = new RegistryPersister(registry);
        registryPersister.load();

        Thread autoSave = new Thread(new AutoSave(registryPersister));
        autoSave.setDaemon(true);
        autoSave.start();

        Thread catalogueLoader = new Thread(new CatalogueLoader(remoteRegistry));
        catalogueLoader.setDaemon(true);
        catalogueLoader.start();

        new CommandLineInterface(registry);

        registryPersister.save();
    }

    public void quit() {
        //do quit stuff
    }
}
