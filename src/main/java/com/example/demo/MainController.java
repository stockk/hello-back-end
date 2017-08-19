package com.example.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Yurii on 19.08.2017.
 */

@RestController
@RequestMapping(value = "/hello/contacts")
public class MainController {

    @Autowired
    ContactService contactService;

    private static final Logger LOGGER = Logger.getLogger(MainController.class);

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Contact>> getAllContacts(@RequestParam("nameFilter") final String filter) {
        LOGGER.info("Received a request for contacts using a filter " + filter);
        return new ResponseEntity<>(contactService.getContactsByFilter(filter), HttpStatus.OK);
    }

}
