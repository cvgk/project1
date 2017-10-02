package com.ozgr.dao;

import java.util.List;

import com.ozgr.model.Address;
import com.ozgr.model.Person;

public interface PersonDAO {
    public void kaydet(Person person);
    public List<Person> getPersons();
    public void delete(String firstName,String lastName);
    public boolean ara(String firstName,String lastName);
    public void update(String firstName,String lastName,Address adress,String[] phones,String email);
    public Person incele(String firstName,String lastName);
}
