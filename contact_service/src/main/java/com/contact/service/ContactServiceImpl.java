package com.contact.service;

import com.contact.entity.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ContactServiceImpl implements ContactService{
    //fake contact list
    List<Contact> list = List.of(
            new Contact(1L,"name1.name1.com","name1",1311L),
            new Contact(5L,"name5.name5.com","name5",1311L),
            new Contact(2L,"name2.name2.com","name2",1312L),
            new Contact(3L,"name3.name3.com","name3",1313L),
            new Contact(4L,"name4.name4.com","name4",1314L)
    );

    @Override
    public List<Contact> getContactOfUser(Long userId) {
        log.info("Inside getContactOfUser method of ContactService");
        return list.stream().filter(contact -> contact.getUserId().equals(userId)).collect(Collectors.toList());
    }
}
