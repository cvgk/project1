package com.ozgr.bean;
import java.util.*;
import java.io.*;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.ozgr.model.Address;
import com.ozgr.model.Person;
import com.ozgr.service.PersonService;
import com.ozgr.service.PersonServiceImpl;
@ManagedBean
@ViewScoped
public class PersonBean implements Serializable{
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ad;
     private String soyad;
     private String telefonNumaralari;
     private String email;
     private String adres1;
     private String adres2;
     private String ilce;
     private String il;
     private String postaKodu;
     private List<Person> persons;
     private PersonService service=new PersonServiceImpl();
     @PostConstruct
	 public void init()
	 {
		 persons = service.getPersons();
	 }
     public void setService(PersonService service)
     {
    	 this.service = service;
     }
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
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
	public String getTelefonNumaralari() {
		return telefonNumaralari;
	}
	public void setTelefonNumaralari(String telefonNumaralari) {
		this.telefonNumaralari = telefonNumaralari;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdres1() {
		return adres1;
	}
	public void setAdres1(String adres1) {
		this.adres1 = adres1;
	}
	public String getAdres2() {
		return adres2;
	}
	public void setAdres2(String adres2) {
		this.adres2 = adres2;
	}
	public String getIlce() {
		return ilce;
	}
	public void setIlce(String ilce) {
		this.ilce = ilce;
	}
	public String getIl() {
		return il;
	}
	public void setIl(String il) {
		this.il = il;
	}
	public String getPostaKodu() {
		return postaKodu;
	}
	public void setPostaKodu(String postaKodu) {
		this.postaKodu = postaKodu;
	}
	public void kaydet()
	{
		if(service.hasDigit(ad)){
			 errorMessage("ad alani digit olmamali","lutfen alfabe kullanin");
			 return;
		 }
		 if(service.hasDigit(soyad)){
			 errorMessage("soyad alani digit olmamali","lutfen alfabe kullanin");
			 return;
		 }
		Address address = new Address(this.adres1,this.adres2,this.ilce,this.il,this.postaKodu);
		Person person = new Person(this.ad,this.soyad);
		person.setAddress(address);
		person.setEmail(this.email);
		String phones[] = telefonNumaralari.split("-");
		person.setTelefonNumaralari(phones);
		service.kaydet(person);
		addMessage("islem basarili","yeni kayit eklendi");
	}
	public void sil()
	{
		if(service.hasDigit(ad)){
			 errorMessage("ad alani digit olmamali","lutfen alfabe kullanin");
			 return;
		 }
		 if(service.hasDigit(soyad)){
			 errorMessage("soyad alani digit olmamali","lutfen alfabe kullanin");
			 return;
		 }
		 List<Person> list = service.getPersons();
		 for(int i=0;i<list.size();i++)
		 {
			 Person p = list.get(i);
			 if(p.getAd().equals(ad)&&p.getSoyad().equals(soyad))
			 {
				 service.delete(this.ad, this.soyad);
				 addMessage("islem basarili","kayit silindi."); 
				 return;
			 }
		 }
		 errorMessage("kayit bulunamadi.","kayit silinemedi");
		
	}
	public void ara()
	{
		if(service.ara(this.ad, this.soyad))
		{
			addMessage("islem basarili","kayit bulundu");
		}else{
			errorMessage("islem basarisiz","kayit bulunamadi");
		}
	}
	//isim ve soyisim veritabaninda kayitli olan biri secilmeli.
	public void update()
	{
		if(service.hasDigit(ad)){
			 errorMessage("ad alani digit olmamali","lutfen alfabe kullanin");
			 return;
		 }
		 if(service.hasDigit(soyad)){
			 errorMessage("soyad alani digit olmamali","lutfen alfabe kullanin");
			 return;
		 }
		Address address = new Address();
		address.setAddress1(this.adres1);
		address.setAddress2(this.adres2);
		address.setIl(this.il);
		address.setIlce(ilce);
		address.setPostaKodu(postaKodu);
		String[] phones = telefonNumaralari.split("-");
		service.update(ad, soyad,address,phones,this.email);
		addMessage("islem basarili","degisiklikler basariyla kaydedildi");
	}
	public void incele()
	{
		Person p=service.incele(ad, soyad);
		if(p==null)
		{
			errorMessage("kayit bulunamadi","lutfen tekrar deneyiniz.");
		}else{
			addMessage("kayit bulundu",p.toString());
		}
	}
	public void detayliincele()
	{
		String[] phones = telefonNumaralari.split("-");
		Address address = new Address();
		address.setAddress1(this.adres1);
		address.setAddress2(this.adres2);
		address.setIl(this.il);
		address.setIlce(ilce);
		address.setPostaKodu(postaKodu);
		Person p = service.incele(ad, soyad, email, phones, address);
		if(p==null)
		{
			errorMessage("kayit bulunamadi","lutfen tekrar deneyiniz.");
		}else{
			addMessage("kayit bulundu",p.toString());
		}
	}
	public void addMessage(String summary,String detail)
	{
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,summary,detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	public void errorMessage(String summary,String detail)
	{
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,summary,detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
