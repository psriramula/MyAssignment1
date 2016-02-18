package com.prasad.intervewPrep.service;

import com.prasad.intervewPrep.model.Contact;
import org.junit.Test;
import org.supercsv.exception.SuperCsvCellProcessorException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;


/**
 * Created by prasadsriramula on 18/02/2016.
 */
public class TestDataReadService {

    private DataReadService dataReadService = new DataReadService();


    @Test(expected=NullPointerException.class)
    public void shouldThrowNullPointerExceptionForInvalidFile()  {
        String aDataFile = "/NoFile";
        List<Contact> list = dataReadService.readAddressBook(aDataFile).getContacts();
    }

    @Test
    public void shouldReturnNonEmptyAddressBook() {
        String aDataFile = "/AddressBook";
        List<Contact> list = dataReadService.readAddressBook(aDataFile).getContacts();
        assertThat(list).hasSize(5);
    }

    @Test(expected = SuperCsvCellProcessorException.class)
    public void shouldThrowSuperCsvCellProcessorExceptionForInvalidData() {
        String aDataFile = "/AddressBookInvalidData";
        List<Contact> list = dataReadService.readAddressBook(aDataFile).getContacts();
    }

    @Test
    public void shouldReturnNonEmptyAddressBookWithValidData() throws ParseException{
        String aDataFile = "/AddressBook";
        List<Contact> list = dataReadService.readAddressBook(aDataFile).getContacts();
        assertThat(list).hasSize(5);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        assertThat(list.get(0).getDob() == formatter.parse("16/03/77"));
    }



}
