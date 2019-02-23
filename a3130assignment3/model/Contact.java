package com.example.acme.a3130assignment3.model;

import java.io.Serializable;

/*
Simple POJO class to hold Contact information
in Realtime database or Firestore database
 */
public class Contact implements Serializable {

    public String id;
    public String name;
    public String email;
    public String bn;
    public String pb;
    public String address;
    public String province;

    public  Contact()
    {

    }

    public Contact(String name, String email, String bn, String pb, String address, String province)
    {
        this.name = name;
        this.email = email;
        this.bn = bn;
        this.pb = pb;
        this.address = address;
        this.province = province;

    }


    @Override
    public String toString()
    {
        return "Name: " + name + " e-mail: " + email + "Business Number: " + bn + "Primary Business: " + pb + "Address: " + address + "Province: " + province;
    }
}
