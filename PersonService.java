package com.ozgr.service;

import java.util.List;

import cinsiyet.Cinsiyet;

import com.ozgr.model.Address;
import com.ozgr.model.Person;

public interface PersonService {
    public void kaydet(Person person);
    public List<Person> getPersons();
    public void delete(String firstName,String lastName);
    public boolean ara(String firstName,String lastName);
    public void update(String firstName,String lastName ,Address adress,String[] phones,String email);
    public Person incele(String firstName,String lastName);
    public Person incele(String firstName,String lastName,String email,String[] telefonNumaralari,Address address);
    public boolean hasDigit(String name);
    public Cinsiyet cinsiyetiGoster(String cinsiyet);
}
