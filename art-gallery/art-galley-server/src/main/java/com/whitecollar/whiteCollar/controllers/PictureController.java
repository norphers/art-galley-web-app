package com.whitecollar.whiteCollar.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.whitecollar.whiteCollar.models.Picture;
import com.whitecollar.whiteCollar.repositories.PictureRepository;
import com.whitecollar.whiteCollar.repositories.ShopRepository;

@RestController
public class PictureController 
{
	
	//--------------------------------------------------
	
	@Autowired
	private final ShopRepository shopRepository;
	@Autowired
	private final PictureRepository pictureRepository;

	PictureController(ShopRepository shopRepository, PictureRepository pictureRepository) 
	{
		this.shopRepository = shopRepository;
		this.pictureRepository=pictureRepository;
	}

	//--------------------------------------------------
	
	@GetMapping("/shops/{idShop}/pictures") 
    Collection<Picture> allArtwork() 
	{
		return (Collection<Picture>) pictureRepository.findAll();
	}
    
	@PostMapping(value="/shops/{idShop}/pictures")
	@ResponseBody
	ResponseEntity<Picture> createPicture(@PathVariable Long idShop,@RequestBody Picture newPicture) 
    {	
		shopRepository.findById(idShop);
		Picture result = pictureRepository.save(newPicture);
        return ResponseEntity.ok().body(result);
    }
	
	@DeleteMapping("/shops/{idShop}/pictures") //dubto de la sintaxis del idPicture, falta seleccionar la shop
	void deletePicture(@PathVariable Long idPicture) 
	{
		pictureRepository.deleteById(idPicture);
	}	
	
}
