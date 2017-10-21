package com.ozgr.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person implements Serializable,Comparator<Person>{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String ad;
    private String soyad;
    private String email;
    private String[] telefonNumaralari;
    @Embedded
    private Address address;
    public Person() {
		super();
	}
	public Person(String ad, String soyad, String email,
			String[] telefonNumaralari, Address address) {
		super();
		this.ad = ad;
		this.soyad = soyad;
		this.email = email;
		this.telefonNumaralari = telefonNumaralari;
		this.address = address;
	}
	public Person(String ad, String soyad) {
		super();
		this.ad = ad;
		this.soyad = soyad;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String[] getTelefonNumaralari() {
		return telefonNumaralari;
	}
	public void setTelefonNumaralari(String[] telefonNumaralari) {
		this.telefonNumaralari = telefonNumaralari;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public boolean equals(Object o)
	{
		Person p = (Person)o;
		if(this.ad.equalsIgnoreCase(p.getAd())&&this.soyad.equalsIgnoreCase(p.getSoyad())&&
				this.email.equalsIgnoreCase(p.getEmail())&&this.address.equals(p.getAddress())&&
				Arrays.equals(this.telefonNumaralari, p.getTelefonNumaralari())){
			return true;
		}
		return false;
	}
	@Override
	public int hashCode()
	{
		return ad.length();
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", ad=" + ad + ", soyad=" + soyad
				+ ", email=" + email + ", telefonNumaralari="
				+ Arrays.toString(telefonNumaralari) + ", address=" + address
				+ "]";
	}
	@Override
	public int compare(Person p1, Person p2) {
		return Integer.valueOf(p1.getId()).compareTo(Integer.valueOf(p2.getId()));
	}
}
