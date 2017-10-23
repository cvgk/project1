package com.ozgr.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ozgr.model.Address;
import com.ozgr.model.Person;

public class PersonDAOImpl  implements PersonDAO{
    @SuppressWarnings("unused")
	private SessionFactory factory;
    private Session session;
    {
    	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	    session = factory.openSession();
    }
	@Override
	public void kaydet(Person person) {
		
		session.beginTransaction();
		session.save(person);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getPersons() {
		Query query = session.createQuery("FROM Person");
		List<Person> listOfPerson =query.getResultList();
		Collections.sort(listOfPerson,new Person());
		return listOfPerson;
	}

	@Override
	public void delete(String firstName,String lastName) {
		session.beginTransaction();
		List<Person> list = getPersons();
		for(int i=0;i<list.size();i++)
		{
			Person p=list.get(i);
			if(p.getAd().equals(firstName)&&p.getSoyad().equals(lastName))
			{
				session.delete(p);
			}
		}
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public boolean ara(String firstName, String lastName) {
		List<Person> list = getPersons();
		for(int i=0;i<list.size();i++)
		{
			Person p = list.get(i);
			if(p.getAd().equals(firstName)&&p.getSoyad().equals(lastName))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public void update(String firstName, String lastName,Address adress,String[] phones,String email) {
		List<Person> list = getPersons();
		session.beginTransaction();
		for(int i=0;i<list.size();i++){
			Person p =list.get(i);
			
			if(p.getAd().equals(firstName)&&p.getSoyad().equals(lastName))
			{
				p.setAddress(adress);
				p.setTelefonNumaralari(phones);
				p.setEmail(email);
				session.update(p);
			}
		}
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Person incele(String firstName, String lastName) {
		List<Person> list = getPersons();
		for(int i=0;i<list.size();i++)
		{
			Person p = list.get(i);
			if(p.getAd().equals(firstName)&&p.getSoyad().equals(lastName))
			{
				return p;
			}
		}
		return null;
	}

	@Override
	public Person incele(String firstName, String lastName, String email,
			String[] telefonNumaralari, Address address) {
		Person person = new Person(firstName,lastName,email,telefonNumaralari,address);
		List<Person> listOfPerson = getPersons();
		HashMap<Person,Integer> map = new HashMap<Person,Integer>();
		for(int i=0;i<listOfPerson.size();i++)
		{
			Person p = listOfPerson.get(i);
			map.put(p, Integer.valueOf(p.getId()));
		}
		Integer val = map.get(person);
		if(val!=null){
			Person p1 = session.get(Person.class, val);
			return p1;
		}
		return null;
	}
	
}
