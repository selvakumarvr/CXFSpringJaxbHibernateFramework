package com.spring.dao;

import com.spring.model.Person;

import java.util.List;

public interface PersonDao {
    public void saveOrUpdate(Person person);
    public void delete(Person person);
    public void find(int id);
    public List<Person> findAllPersons();
}
