package com.whitecollar.whiteCollar.controllers;

import java.io.File;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whitecollar.whiteCollar.models.Shop;
import com.whitecollar.whiteCollar.repositories.PictureRepository;
import com.whitecollar.whiteCollar.repositories.ShopRepository;

@RestController
public class ShopController 
{
	
	//--------------------------------------------------
	
	@Autowired
	private final ShopRepository shopRepository;
	@Autowired
	private final PictureRepository pictureRepository;

	ShopController(ShopRepository shopRepository, PictureRepository pictureRepository) 
	{
		this.shopRepository = shopRepository;
		this.pictureRepository=pictureRepository;
	}

	//--------------------------------------------------
	
	@GetMapping("/shops")
	Collection<Shop> allShops() 
	{
		return (Collection<Shop>) shopRepository.findAll();
	}

    @PostMapping("/shops")
    ResponseEntity<Shop> createShop(@Valid @RequestBody Shop newShop) 
    {
        Shop result = shopRepository.save(newShop);
        
        ObjectMapper mapper = new ObjectMapper();
        try 
        {
			String jsonString = mapper.writeValueAsString(result);
		} 
        catch (JsonProcessingException e) 
        {
			e.printStackTrace();
		}
        return ResponseEntity.ok().body(result);
    }
    
    @DeleteMapping("/shops")
	void deleteShop() 
	{
		shopRepository.deleteAll();
	}	
	
}
