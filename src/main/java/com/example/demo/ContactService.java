package com.example.demo;

import lombok.Setter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Yurii on 19.08.2017.
 */

@Service
@Setter
public class ContactService {
    @Autowired
    ContactRepository contactRepository;

    private static final Logger LOGGER = Logger.getLogger(ContactService.class);

    public List<Contact> getContactsByFilter(String filter) {

        List<Contact> contacts = new LinkedList<>();
        contactRepository.findAll()
                .forEach(contacts::add);

        LOGGER.info("All contacts were received from the database");
        LinkedList<Contact> filterContacts = new LinkedList<>();
        contacts.stream()
                .filter(s -> !s.getName().matches(filter))
                .forEach(filterContacts::add);

        LOGGER.info("All contacts have been filtered");
        return filterContacts;
    }
}
