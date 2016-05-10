package com.example.vishnubk.contact;

/**
 * Created by vishnubk on 12/1/16.
 */
public class Contact {

    String name;
    String phone;


    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
