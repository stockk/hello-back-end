package com.example.demo;

import org.springframework.data.repository.CrudRepository;


/**
 * Created by Yurii on 19.08.2017.
 */

public interface ContactRepository extends CrudRepository<Contact, String> {

}
