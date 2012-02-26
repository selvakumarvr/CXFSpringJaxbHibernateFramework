package com.junit;

import com.spring.SpringContext;
import com.spring.model.Person;
import com.spring.service.PersonManager;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class PersonManagerTest {

    private static Logger logger = Logger.getLogger(PersonManagerTest.class);
    
    @Test
    public void testInsertPerson() throws Exception {
        
        logger.debug("Create Spring contex");
        SpringContext context = SpringContext.getInstance();
        
        // Object creation
        Person person1 = new Person("Jorge", "Tapia", "Oshyn");
        logger.debug("person1 = " + person1);
        Person person2 = new Person("Foo", "Bar", "X");
        logger.debug("person2 = " + person2);
        
        List<Person> persons = new ArrayList<Person>();
        persons.add(person1);
        persons.add(person2);
        logger.debug("persons = " + persons);
        
        // Get Manager
        PersonManager personManager = (PersonManager)context.
                getBean("personManager");
        
        // Insert
        personManager.insertPersons(persons);
        
        // Retrieve Person list
        List<Person> personList = personManager.findAllPersons();
        
        logger.debug("persons retornadas = " + personList);
        
        // Verify if persons exist
        assertTrue(personList.contains(person1) && personList.
                contains(person2));
    }
}