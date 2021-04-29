package com.contact.controller;

import com.contact.entity.Contact;
import com.contact.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/user/{userId}")
    public List<Contact> getContact(@PathVariable("userId") Long userId){
        log.info("Inside getContact method of ContactController");
        return contactService.getContactOfUser(userId);
    }
}
