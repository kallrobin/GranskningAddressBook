package com.loca.addressbook.remoteregistry;

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
        catalogueClient.connect();
        catalogueClient.sendRequest("getall");

        String result = catalogueClient.waitForResponse();
        String[] contactArray = result.split("\n");
        for (int i = 0; i <= contactArray.length; i++) {
            remoteContactList.add(contactArray[i]);
        }
        return remoteContactList;
    }
}
