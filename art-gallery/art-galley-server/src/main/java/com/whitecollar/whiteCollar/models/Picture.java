package com.whitecollar.whiteCollar.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Picture 
{
	private @Id @GeneratedValue Long idPicture;
	private String author;
	private String title;
	private LocalDate registerDate; 
	private double price;
	
	@ManyToOne
    @JoinColumn(name="idShop") // I've tried with id_shop
	@JsonIgnore
	private Shop shop;
	
	public Picture() 
	{
		
	}
	
	public Picture(String author, String title, double price, Shop shop) 
	{
	    this.author = author;
	    this.title=title;
	    this.registerDate= LocalDate.now();
	    this.shop=shop;
	}
	
}
