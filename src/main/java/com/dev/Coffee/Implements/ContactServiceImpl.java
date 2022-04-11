package com.dev.Coffee.Implements;

import com.dev.Coffee.entities.ContactEntities;
import com.dev.Coffee.model.Contact;
import com.dev.Coffee.repository.ContactRepository;
import com.dev.Coffee.services.ContactService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact createContact(Contact contact) {
        ContactEntities contactEntities = new ContactEntities();

        contact.setCreated_date(new Date());
        BeanUtils.copyProperties(contact, contactEntities);

        contactRepository.save(contactEntities);
        return contact;
    }

    @Override
    public boolean deleteContact(Long id) {
        ContactEntities contactEntities = contactRepository.findById(id).get();
        contactRepository.delete(contactEntities);

        return true;
    }

    @Override
    public Contact getContactById(Long id) {
        ContactEntities contactEntities = contactRepository.findById(id).get();
        Contact contact = new Contact();
        BeanUtils.copyProperties(contactEntities, contact);
        return contact;
    }

    @Override
    public List<Contact> getAllContact() {
        List<ContactEntities> contactEntities = contactRepository.findAll();
        List<Contact> contacts = contactEntities
                .stream()
                .map(con -> new Contact(
                        con.getId(),
                        con.getStatus(),
                        con.getCreated_by(),
                        con.getUpdated_by(),
                        con.getCreated_date(),
                        con.getUpdated_date(),
                        con.getName(),
                        con.getEmail(),
                        con.getMessage()
                )).collect(Collectors.toList());

        return contacts;
    }
}
