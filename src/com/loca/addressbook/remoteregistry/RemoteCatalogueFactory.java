package com.loca.addressbook.remoteregistry;

/**
 * Created by Adrian on 2016-12-21.
 */
public class RemoteCatalogueFactory {

    private int defaultPort;

    public RemoteCatalogueFactory(int defaultPort) {
        this.defaultPort = defaultPort;
    }

    public RemoteCatalogueProxy create(String host) {
        new AtomicRemoteCatalogueProxy(host, defaultPort);
        return null;
    }
}
