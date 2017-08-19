package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Yurii on 19.08.2017.
 */

@Data
@Entity
@AllArgsConstructor
@Table(name="contact")
public class Contact {

    @Id
    Long id;
    String name;

}
