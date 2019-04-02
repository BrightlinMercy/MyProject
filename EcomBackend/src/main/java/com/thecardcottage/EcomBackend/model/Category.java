package com.thecardcottage.EcomBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cateid;

	@Column(nullable = false, unique = true)
	@NotEmpty(message = "Category Name is Mandatory")
	@Pattern(regexp = "[a-zA-Z ]{3,255}", message = "Can Contain only Alphabets max 255 characters ")
	private String catename;

	@Column(nullable = false)
	@NotEmpty(message = "Category Description is Mandatory")
	@Pattern(regexp = "[0-9a-zA-Z ]{3,255}", message = "Can Contain only Alphabets & Numbers max 255 characters ")
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
