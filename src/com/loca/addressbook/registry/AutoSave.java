package com.loca.addressbook.registry;

public class AutoSave {

    private RegistryPersister registryPersister;


    public AutoSave(RegistryPersister registryPersister) {
        this.registryPersister = registryPersister;
    }


    public void start() {
        Thread.currentThread().setName("AutoSave");
        //registryPersister.load();
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                    registryPersister.save();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
