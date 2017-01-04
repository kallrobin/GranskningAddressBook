package com.loca.addressbook.remoteregistry;

public class RemoteCatalogueFactory {

    private int defaultPort;

    public RemoteCatalogueFactory(int port) {
        this.defaultPort = port;
    }

    public RemoteCatalogueFactory() {
        this.defaultPort = 61616;
    }

    public RemoteCatalogueProxy create(String host) {
        return new AtomicRemoteCatalogueProxy(host, defaultPort);
    }
}
