package com.loca.addressbook.registry;

import java.util.UUID;

/**
 * Created by Loca on 2016-12-20.
 */
public class UniqueIdGenerator {

    public static UUID generateUUID() {
        UUID idOne = UUID.randomUUID();
        return idOne;
    }
}
