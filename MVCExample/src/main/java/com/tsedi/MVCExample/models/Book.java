package com.tsedi.MVCExample.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity(name ="bookprofile")
public class Book {

@Id	
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;

@NotBlank(message = "Name is mandatory")
private String bookName;

@NotBlank(message = "Author is mandatory")
private String author;



public void setId(long id) {
	// TODO Auto-generated method stub
	id = this.id;
	
}
public long getId() {
	return id;
}
public void setbooName(String bookName) {
	// TODO Auto-generated method stub
	bookName = this.bookName;
	
}
public String getbookName() {
	return bookName;
}

public void setAuthor(String author) {
	// TODO Auto-generated method stub
	author = this.author;
	
}
public String getAuthor() {
	return author;
}


}

