package com.prasad.intervewPrep.util;

import com.prasad.intervewPrep.model.AddressBook;
import com.prasad.intervewPrep.model.Contact;

import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

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

    /** returns the age difference in days between given two contact names
     *If there is more then one contact with given name
     *the first one will be selected.
     * @param firstContactName name of first Contact
     * @param secondContactName name of second Contact
     * @return age difference in days. If second person is older this number will be negative.
     * */

    public static Optional<Long> getAgeDifferenceInDays(AddressBook aAddressBook, String firstContactName, String secondContactName){
        Optional<Contact> c1 =getContactByName(aAddressBook, firstContactName);
        Optional<Contact> c2 =getContactByName(aAddressBook, secondContactName);
        if(c1.isPresent() && c2.isPresent()) {
            Date dob1 = c1.get().getDob();
            Date dob2 = c2.get().getDob();
            long days = TimeUnit.DAYS.convert((dob1.getTime()-dob2.getTime()),TimeUnit.MILLISECONDS);
            return Optional.of(days);
        }else {
            return Optional.empty();
        }

    }

    /** returns Contact object for a given Name, if multiple entries with same names returns the first item
     *
     * TODO : partial string searching is a potential improvement . i.e c.getName.contains or substring etc
     *
     * @param aAddressBook
     * @param aName
     * @return Contact from the addressBook
     *
     */
    public static Optional<Contact> getContactByName(AddressBook aAddressBook, String aName){
        return aAddressBook.getContacts().stream().filter(c -> c.getName().equals(aName)).findFirst();
    }
}
