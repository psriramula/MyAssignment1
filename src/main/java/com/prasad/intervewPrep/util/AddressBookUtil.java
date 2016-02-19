package com.prasad.intervewPrep.util;

import com.prasad.intervewPrep.model.AddressBook;

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
}
