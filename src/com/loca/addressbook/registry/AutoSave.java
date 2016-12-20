package com.loca.addressbook.registry;

import java.io.IOException;

/**
 * Created by katan on 2016-12-20.
 */
public class AutoSave implements Runnable {

    @Override
    public void run() {
        Thread.currentThread().setName("AutoSaver");
        while (true) {
            try {
                Thread.sleep(5000);
                RegistryPersister.save();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
