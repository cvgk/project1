package com.ozgr.service;

import java.util.List;

import com.ozgr.dao.PersonDAO;
import com.ozgr.dao.PersonDAOImpl;
import com.ozgr.model.Address;
import com.ozgr.model.Person;

public class PersonServiceImpl implements PersonService {
    private PersonDAO persondao = new PersonDAOImpl();
	@Override
	public void kaydet(Person person) {
		persondao.kaydet(person);
	}
	@Override
	public List<Person> getPersons() {
	   List<Person> persons = persondao.getPersons();
		return persons;
	}
	@Override
	public void delete(String firstName,String lastName) {
		persondao.delete(firstName, lastName);
		
	}
	@Override
	public boolean ara(String firstName, String lastName) {
		
		return persondao.ara(firstName, lastName);
	}
	@Override
	public void update(String firstName, String lastName, Address adress,
			String[] phones, String email) {
		persondao.update(firstName, lastName, adress, phones, email);
		
	}
	@Override
	public Person incele(String firstName, String lastName) {
		
		return persondao.incele(firstName, lastName);
	}
	@Override
	public boolean hasDigit(String name)
	{
		for(int i=0;i<name.length();i++)
		{
			if(name.charAt(i)=='0'||name.charAt(i)=='1'||name.charAt(i)=='2'||
			name.charAt(i)=='3'||name.charAt(i)=='4'||name.charAt(i)=='5'||name.charAt(i)=='6'
			||name.charAt(i)=='7'||name.charAt(i)=='8'||name.charAt(i)=='9')
			{
				return true;
			}
		}
		return false;
	}
	@Override
	public Person incele(String firstName, String lastName, String email,
			String[] telefonNumaralari, Address address) {

		return persondao.incele(firstName, lastName, email, telefonNumaralari, address);
	}
}
