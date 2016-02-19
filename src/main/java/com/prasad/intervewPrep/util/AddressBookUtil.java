package com.prasad.intervewPrep.util;

import com.prasad.intervewPrep.model.AddressBook;
import com.prasad.intervewPrep.model.Contact;

import java.util.Optional;

/**
 * Created by prasadsriramula on 18/02/2016.
 */
public class AddressBookUtil {

    /**
     * returns total number of people of given gender type.
     *
     * @param aAddressBook addressBook object
     * @param aGender gender String ( Male or Female )
     * @return number of people
     */
    public static long getGenderCount(AddressBook aAddressBook, String aGender) {
        return aAddressBook.getContacts().stream().filter( c -> c.getGender().equals(aGender) ).count();
    }


    /**
     * returns oldest contact from the given address Book.
     *
     * @param aAddressBook addressBook object
     *
     * @return oldest contact by age in address book
     */
    public static Optional<Contact> getOldestContact(AddressBook aAddressBook) {
        return aAddressBook.getContacts().stream().min( (c1, c2) -> c1.getDob().compareTo(c2.getDob()));
    }
}
