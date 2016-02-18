package com.prasad.intervewPrep.model;
/**
 * Created by prasadsriramula on 18/02/2016.
 */

import java.util.Collections;
import java.util.List;

public class AddressBook {


    private List<Contact> contacts;

    public AddressBook(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Contact> getContacts() {
        return Collections.unmodifiableList(contacts);
    }

}
