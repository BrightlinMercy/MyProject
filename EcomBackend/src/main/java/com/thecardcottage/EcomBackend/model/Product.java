package com.thecardcottage.EcomBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pdtid;
	
	@Column(nullable=false)
	private String pdtname;
	
	@Column(nullable=false)
	private String pdtdesc;
	

   @ManyToOne
	private Category pdtcategory;
	
	@Column(nullable=false)
	private int pdtstock;
	
	@Column(nullable=false)
	private int pdtprice;

	public int getPdtid() {
		return pdtid;
	}

	public void setPdtid(int pdtid) {
		this.pdtid = pdtid;
	}

	public String getPdtname() {
		return pdtname;
	}

	public void setPdtname(String pdtname) {
		this.pdtname = pdtname;
	}

	public String getPdtdesc() {
		return pdtdesc;
	}

	public void setPdtdesc(String pdtdesc) {
		this.pdtdesc = pdtdesc;
	}

	public Category getPdtcategory() {
		return pdtcategory;
	}

	public void setPdtcategory(Category pdtcategory) {
		this.pdtcategory = pdtcategory;
	}

	public int getPdtstock() {
		return pdtstock;
	}

	public void setPdtstock(int pdtstock) {
		this.pdtstock = pdtstock;
	}

	public int getPdtprice() {
		return pdtprice;
	}

	public void setPdtprice(int pdtprice) {
		this.pdtprice = pdtprice;
	}
	
	
	
	
}
