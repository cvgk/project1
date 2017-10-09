package com.ozgr.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ozgr.model.Address;
import com.ozgr.model.Person;

public class PersonDAOImpl  implements PersonDAO{
   
	private SessionFactory factory;
        private Session session;
    {
    	    factory = new Configuration().configure().buildSessionFactory();
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
		return query.getResultList();
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
	
}
