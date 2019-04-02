package com.thecardcottage.EcomBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Customer {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int custid;

@Column(nullable=false)
@NotEmpty(message = "Category Name is Mandatory")
@Pattern(regexp = "[a-zA-Z ]{3,255}", message = "Name cannot have numbers ")
private String custname;

@Column(nullable=false,unique=true)
@Pattern(regexp = "^(.+)@(.+)$",message="invalid mailid")
private String custemailid;

@Column(nullable=false,unique=true)

private String custphno;

@Transient
@Pattern(regexp="^(?i)(?=.*[a-z])(?=.*[0-9])[a-z0-9#.!@$*&_]{5,12}$")
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
