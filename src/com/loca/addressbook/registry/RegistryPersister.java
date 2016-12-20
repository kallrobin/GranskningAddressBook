package com.loca.addressbook.registry;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Loca on 2016-12-20.
 */
public class RegistryPersister {



    public  void load(List<Contact> localRegistry) {
        File f = new File("contacts.data");
        //Check if file exists
        if (f.isFile() && f.canRead()) {
            try {
                FileInputStream fileIn = new FileInputStream("contacts.data");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                localRegistry = (List<Contact>) in.readObject();
                in.close();
                fileIn.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized static void save(ArrayList<Contact> c) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream("contacts.data")) {
            try (ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(c);
            }
        }
    }
}
