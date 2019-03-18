package com.thecardcottage.EcomBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int cateid;
	
	@Column(nullable=false,unique=true)
	private String catename;
	
	@Column(nullable=false)
	private String catedesc;

	public int getCateid() {
		return cateid;
	}

	public void setCateid(int cateid) {
		this.cateid = cateid;
	}

	public String getCatename() {
		return catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}

	public String getCatedesc() {
		return catedesc;
	}

	public void setCatedesc(String catedesc) {
		this.catedesc = catedesc;
	}
	
	}
