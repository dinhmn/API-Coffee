package com.dev.Coffee.controller;

import com.dev.Coffee.model.Contact;
import com.dev.Coffee.services.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v2")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/contact")
    public Contact createContact(@RequestBody Contact contact) {
        return contactService.createContact(contact);
    }
    @GetMapping("/contact")
    public List<Contact> getAllContact(){
        return contactService.getAllContact();
    }

    @DeleteMapping("/contact/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteContact(@PathVariable Long id){
        boolean deteted = false;
        deteted = contactService.deleteContact(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", deteted);

        return ResponseEntity.ok(response);
    }
    @GetMapping("/contact/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id){
        Contact contact = contactService.getContactById(id);
        return ResponseEntity.ok(contact);
    }
}
