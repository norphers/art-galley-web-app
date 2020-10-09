package com.whitecollar.whiteCollar.repositories;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.whitecollar.whiteCollar.models.Picture;
import com.whitecollar.whiteCollar.models.Shop;

public interface PictureRepository extends CrudRepository<Picture, Long>
{
	//Collection<Picture> findByIdShop (String name);
}
