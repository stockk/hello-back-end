package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by Yurii on 19.08.2017.
 */

@Data
@Entity
@AllArgsConstructor
@Table(name="contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;

}
