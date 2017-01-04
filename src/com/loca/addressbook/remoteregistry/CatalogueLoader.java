package com.loca.addressbook.remoteregistry;

import java.util.ArrayList;
import java.util.List;

public class CatalogueLoader {
    private static final int PORT = 61616;
    private RemoteCatalogueFactory catalogueFactory = new RemoteCatalogueFactory(PORT);
    private RemoteRegistry remoteRegistry;
    private List<String> hosts = new ArrayList<>();

    public CatalogueLoader(RemoteRegistry remoteRegistry, List<String> hosts) {
        this.remoteRegistry = remoteRegistry;
        this.hosts = hosts;
    }


    public void start() {
        for (String host : hosts) {
            new Thread(() -> {
                RemoteCatalogueProxy remoteCatalogueProxy = catalogueFactory.create(host);
                for (String contact : remoteCatalogueProxy.getContacts()) {
                    String[] splittedList = contact.split(" ");
                    remoteRegistry.add(splittedList[0], splittedList[1], splittedList[2], splittedList[3]);
                }
            }).start();
        }
    }
}
