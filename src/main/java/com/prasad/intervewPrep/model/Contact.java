package com.prasad.intervewPrep.model;

/**
 * Created by prasadsriramula on 18/02/2016.
 */

import java.util.Date;

public class Contact  {

    private String name;
    private String gender;
    private Date dob;

    public Contact(){

    }

    public String getName() {
        return name;
    }

    public void setName(String aName){
        this.name=aName.trim();//precaution to trim any additional space chars before after the String
    }

    public String getGender() {
        return gender;
    }

    public void  setGender(String aGender){
        this.gender=aGender.trim(); //precaution to trim any additional space chars before after the String
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date aDob){
        this.dob=aDob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (!name.equals(contact.name)) return false;
        if (!gender.equals(contact.gender)) return false;
        return dob.equals(contact.dob);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + dob.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("Contact{name='%s', gender=%s, birthday=%s}", name, gender, dob);
    }
}
