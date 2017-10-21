package com.ozgr.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
  
private String address1;
  private String address2;
  private String ilce;
  private String il;
  private String postaKodu;
public Address() {
	super();
}
public Address(String address1, String address2, String ilce, String il,
		String postaKodu) {
	super();
	this.address1 = address1;
	this.address2 = address2;
	this.ilce = ilce;
	this.il = il;
	this.postaKodu = postaKodu;
}
public String getAddress1() {
	return address1;
}
public void setAddress1(String address1) {
	this.address1 = address1;
}
public String getAddress2() {
	return address2;
}
public void setAddress2(String address2) {
	this.address2 = address2;
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
@Override
public boolean equals(Object o)
{
	Address a =(Address)o;
	if(this.il.equalsIgnoreCase(a.getIl())&&this.ilce.equalsIgnoreCase(a.getIlce())&&this.address1.
			equalsIgnoreCase(a.getAddress1())&&this.address2.equalsIgnoreCase(a.getAddress2())&&
			this.postaKodu.equals(a.getPostaKodu())){
		return true;
	}
	return false;
}

@Override
public String toString() {
	return "Address [address1=" + address1 + ", address2=" + address2
			+ ", ilce=" + ilce + ", il=" + il + ", postaKodu=" + postaKodu
			+ "]";
}
}
