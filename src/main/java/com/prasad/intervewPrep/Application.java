package com.prasad.intervewPrep;

import com.prasad.intervewPrep.model.AddressBook;
import com.prasad.intervewPrep.service.DataReadService;
import com.prasad.intervewPrep.util.AddressBookUtil;

/**
 * Created by prasadsriramula on 18/02/2016.
 */
public class Application {

    private  enum Gender {
        Male, Female
    }

    public static void main(String[] args){
        System.out.println("Address Book Application");
        System.out.println("Reading Address Book");

        AddressBook addressBook = new DataReadService().readAddressBook("/AddressBook");
        System.out.println("Read "+addressBook.getContacts().size()+" no. of records from file");
        System.out.println("1. How many males are in the address book?       ==> Ans : " + AddressBookUtil.getGenderCount(addressBook, "Male"));
        System.out.println("2. Who is the oldest person in the address book? ==> Ans : " + AddressBookUtil.getOldestContact(addressBook).get().getName());





    }
}
