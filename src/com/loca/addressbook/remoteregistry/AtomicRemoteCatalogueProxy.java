package com.loca.addressbook.remoteregistry;

import java.util.List;

/**
 * Created by Loca on 2016-12-20.
 */
public class AtomicRemoteCatalogueProxy implements RemoteCatalogueProxy {

    CatalogueClient catalogueClient;
    String host;
    int port;

    public AtomicRemoteCatalogueProxy(String host, int port) {
        catalogueClient = new CatalogueClient(host, port);
        this.host = host;
        this.port = port;
    }

    @Override
    public List<String> getContacts() {
        return null;
    }
}
