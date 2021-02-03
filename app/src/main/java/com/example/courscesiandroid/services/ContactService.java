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

    public void addContact(String firstName, String lastName, String phone, String mail, String avatarUrl) {
        Contact contact = new Contact(firstName, lastName, phone, mail, avatarUrl);
        contacts.add(contact);
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public Contact getContact(int id) {
        return contacts.get(id);
    }

    public List<Contact> searchContacts(String search) {
        List<Contact> result = new ArrayList<>();
        for(Contact c:contacts) {
            if(c.getFirstName().contains(search)) {
                result.add(c);
            }
        }
        return result;
    }
}
