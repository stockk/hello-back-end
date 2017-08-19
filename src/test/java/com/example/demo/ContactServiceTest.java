package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Yurii on 19.08.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class ContactServiceTest {

    private ContactService contactService;
    private ContactRepository mockContactRepository = mock(ContactRepository.class);
    private LinkedList<Contact> testContacts;

    @Before
    public void setUp() throws Exception {

        contactService = new ContactService();
        contactService.setContactRepository(mockContactRepository);

        testContacts = new LinkedList<>();
        testContacts.add(new Contact(1L,"Ivan"));
        testContacts.add(new Contact(2L,"Anet"));
        testContacts.add(new Contact(3L,"Elena"));
        testContacts.add(new Contact(4L,"Anton"));
        testContacts.add(new Contact(5L,"Adolf"));

    }

    @Test
    public void shouldReturnAllContactsNotStartingWithA() throws Exception {

        LinkedList<Contact> correctContacts = new LinkedList<>();
        correctContacts.add(new Contact(1L,"Ivan"));
        correctContacts.add(new Contact(3L,"Elena"));

        when(mockContactRepository.findAll()).thenReturn(testContacts);

        List<Contact> returnContacts = contactService.getContactsByFilter("^A.*$");

        assertEquals(correctContacts.toString(), returnContacts.toString());
    }

    @Test
    public void shouldReturnAllContactsDoNotContainAEI() throws Exception {

        LinkedList<Contact> correctContacts = new LinkedList<>();
        correctContacts.add(new Contact(4L,"Anton"));
        correctContacts.add(new Contact(5L,"Adolf"));

        when(mockContactRepository.findAll()).thenReturn(testContacts);

        List<Contact> returnContacts = contactService.getContactsByFilter("^.*[aei].*$");

        assertEquals(correctContacts.toString(), returnContacts.toString());

    }

    @Test
    public void shouldCorrectWorkWithMillionContacts() throws Exception {

        testContacts = new LinkedList<Contact>();

        for (long i = 1; i <= Math.pow(10, 6); i++) {
            testContacts.add(new Contact(i,"Name"));
        }

        when(mockContactRepository.findAll()).thenReturn(testContacts);

        List<Contact> returnContacts = contactService.getContactsByFilter("");

        assertEquals(returnContacts.size(), (int)Math.pow(10, 6));

    }



}
