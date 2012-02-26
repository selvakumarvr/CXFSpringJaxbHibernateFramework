package com.spring.service;

import com.spring.model.Person;

import java.util.List;

public interface PersonManager {
    public void insertPersons(List<Person> persons);
    public List<Person> findAllPersons();
}
