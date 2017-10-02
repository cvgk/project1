package com.ozgr.model;

import java.util.Arrays;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
	
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
		// TODO Auto-generated constructor stub
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
	public String toString() {
		return "Person [id=" + id + ", ad=" + ad + ", soyad=" + soyad
				+ ", email=" + email + ", telefonNumaralari="
				+ Arrays.toString(telefonNumaralari) + ", address=" + address
				+ "]";
	}
}
