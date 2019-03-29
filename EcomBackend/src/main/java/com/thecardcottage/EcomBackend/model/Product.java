package com.thecardcottage.EcomBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;


import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pdtid;
	
	@Column(nullable=false)
	@NotEmpty
	@Pattern(regexp="[a-zA-Z ]{3,255}",message="Can Contain only Alphabets max 255 characters ")
	private String pdtname;
	
	@Column(nullable=false, columnDefinition="test")
	private String pdtdesc;
	

   @ManyToOne
	private Category pdtcategory;
   
   @ManyToOne
	private Seller pdtseller;
	
   @Column(nullable=false)
   @Min(value=100)
   @Max(value=1000)
    private int pdtstock;
	
   @Column(nullable=false)
   @Min(value=100)
   @Max(value=1000)
    private int pdtprice;


	public int getPdtprice() {
		return pdtprice;
	}


	public void setPdtprice(int pdtprice) {
		this.pdtprice = pdtprice;
	}


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


	public Seller getPdtseller() {
		return pdtseller;
	}


	public void setPdtseller(Seller pdtseller) {
		this.pdtseller = pdtseller;
	}


	public int getPdtstock() {
		return pdtstock;
	}


	public void setPdtstock(int pdtstock) {
		this.pdtstock = pdtstock;
	}
	
	
		
	
}
