package com.loca.addressbook.remoteregistry;

import java.io.IOException;
import java.io.SyncFailedException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Loca on 2016-12-20.
 */
public class AtomicRemoteCatalogueProxy implements RemoteCatalogueProxy {

    private CatalogueClient catalogueClient;
    private String host;
    private int port;
    private List<String> remoteContactList = new ArrayList<>();

    public AtomicRemoteCatalogueProxy(String host, int port) {
        catalogueClient = new CatalogueClient(host, port);
        this.host = host;
        this.port = port;
    }

    @Override
    public List<String> getContacts() {
        try {
            catalogueClient.connect();
            catalogueClient.sendRequest("getall");

            String result = catalogueClient.waitForResponse();

            String[] contactArray = result.split("\n");

            for (int i = 0; i < contactArray.length; i++) {
                remoteContactList.add(contactArray[i]);
            }

            catalogueClient.sendRequest("exit");

        } catch (IOException e) {
            System.err.println("Connection error (" + this.host + ")");
        } finally {
            try {
                catalogueClient.disconnect();
            } catch (IOException e) {
                System.err.println("Disconnection error (" + this.host + ")");
            } catch (NullPointerException e) {
                System.err.println("Connection never opened (" + this.host + ")");
            }
        }
        return remoteContactList;
    }
}
