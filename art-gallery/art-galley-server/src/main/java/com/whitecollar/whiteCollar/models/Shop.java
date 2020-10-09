package com.whitecollar.whiteCollar.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Shop 
{
	private @Id @GeneratedValue Long idShop;
	private String name;
	private int maxStorage;
	private int currentStorage;
	
	@OneToMany(mappedBy="shop")
	@JsonIgnore
    private Set<Picture> pictures;
	
	public Shop() 
	{
		
	}
	
	public Shop(String name, int maxStorage) 
	{
	    this.name = name;
	    this.maxStorage=maxStorage;
	    this.currentStorage=0;
	}
	
}
