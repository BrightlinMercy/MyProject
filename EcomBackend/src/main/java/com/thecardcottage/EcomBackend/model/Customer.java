package com.thecardcottage.EcomBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Customer {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int custid;

@Column(nullable=false)
private String custname;

@Column(nullable=false,unique=true)
private String custemailid;

@Column(nullable=false,unique=true)
private String custphno;

@Transient
private String custpassword;

public int getCustid() {
	return custid;
}

public void setCustid(int custid) {
	this.custid = custid;
}

public String getCustname() {
	return custname;
}

public void setCustname(String custname) {
	this.custname = custname;
}

public String getCustemailid() {
	return custemailid;
}

public void setCustemailid(String custemailid) {
	this.custemailid = custemailid;
}

public String getCustphno() {
	return custphno;
}

public void setCustphno(String custphno) {
	this.custphno = custphno;
}

public String getCustpassword() {
	return custpassword;
}

public void setCustpassword(String custpassword) {
	this.custpassword = custpassword;
}


}
