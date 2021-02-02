package com.example.courscesiandroid.services;

import com.example.courscesiandroid.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactService {

    private static ContactService instance = null;
    private List<Contact> contacts;
    private ContactService() {
        contacts = new ArrayList<>();
    }

    public static ContactService getInstance() {
        if(instance == null)
            instance = new ContactService();
        return instance;
    }

    public void addContact(String firstName, String lastName, String phone, String mail) {
        Contact contact = new Contact(firstName, lastName, phone, mail);
        contacts.add(contact);
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
