package com.loca.addressbook.remoteregistry;

import java.rmi.Remote;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian on 2016-12-20.
 */
public class CatalogueLoader implements Runnable{
    int defaultPort = 61616;
    private RemoteCatalogueFactory catalogueFactory;
    private RemoteRegistry remoteRegistry;
    private RemoteCatalogueProxy remoteCatalogueProxy;
    private List<String> hosts = new ArrayList<>();

    public CatalogueLoader(RemoteRegistry remoteRegistry) {
        this.remoteRegistry = remoteRegistry;
    }

    @Override
    public void run() {
        //Add as many hosts as you want
        hosts.add("localhost");

        for (String host: hosts){
            new RemoteCatalogueFactory(defaultPort);
            remoteCatalogueProxy = catalogueFactory.create(host);
            for(String contact : remoteCatalogueProxy.getContacts()) {
                String[] splittedList = contact.split(" ");
                remoteRegistry.add(splittedList[0],splittedList[1],splittedList[2],splittedList[3]);
            }
        }
    }
}
