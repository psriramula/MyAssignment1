package com.prasad.intervewPrep.service;

/**
 * Created by prasadsriramula on 18/02/2016.
 */

import com.prasad.intervewPrep.model.AddressBook;
import com.prasad.intervewPrep.model.Contact;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DataReadService {

    public DataReadService(){

    }

    public AddressBook readAddressBook(String csvFileName) {

        List<Contact> contacts = new ArrayList();
        ICsvBeanReader beanReader = null;
        CellProcessor[] processors = new CellProcessor[]{
                new NotNull(),
                new NotNull(),
                new ParseDate("dd/MM/yy")
        };

        try {
            beanReader = new CsvBeanReader(new FileReader(new File(this.getClass().getResource(csvFileName).getFile())),
                    CsvPreference.STANDARD_PREFERENCE);
            String[] header = beanReader.getHeader(true);
            Contact contactBean;
            while ((contactBean = beanReader.read(Contact.class, header, processors)) != null) {
                contacts.add(contactBean);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Could not find the CSV file: " + ex);
        } catch (IOException ex) {
            System.err.println("Error reading the CSV file: " + ex);
        } finally {
            if (beanReader != null) {
                try {
                    beanReader.close();
                } catch (IOException ex) {
                    System.err.println("Error closing the reader: " + ex);
                }
            }
        }
        return new AddressBook(contacts);
    }


}
