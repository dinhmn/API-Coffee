package com.dev.Coffee.services;

import com.dev.Coffee.model.Contact;

import java.util.List;

public interface ContactService {

    Contact createContact(Contact contact);
    boolean deleteContact(Long id);
    Contact getContactById(Long id);
    List<Contact> getAllContact();
}
