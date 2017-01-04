package com.loca.addressbook.remoteregistry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AtomicRemoteCatalogueProxy implements RemoteCatalogueProxy {
    private static final Logger log = Logger.getLogger(AtomicRemoteCatalogueProxy.class.getName());

    private CatalogueClient catalogueClient;
    private String host;
    private List<String> remoteContactList = new ArrayList<>();

    public AtomicRemoteCatalogueProxy(String host, int port) {
        catalogueClient = new CatalogueClient(host, port);
        this.host = host;
    }

    @Override
    public List<String> getContacts() {
        try {
            catalogueClient.connect();
            catalogueClient.sendRequest("getall");

            String result = catalogueClient.waitForResponse();

            String[] contactArray = result.split("\n");

            Collections.addAll(remoteContactList, contactArray);

            catalogueClient.sendRequest("exit");

        } catch (IOException e) {
            log.log(Level.SEVERE, Thread.currentThread().getName() + ": IOException caught in thread", e);
        } finally {
            try {
                catalogueClient.disconnect();
            } catch (IOException e) {
                log.log(Level.SEVERE, Thread.currentThread().getName() + ": IOException caught in thread", e);
            } catch (NullPointerException e) {
                log.log(Level.SEVERE, Thread.currentThread().getName() + ": NullPointerException caught in thread", e);
            }
        }
        return remoteContactList;
    }
}
