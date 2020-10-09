package com.whitecollar.whiteCollar.repositories;

import org.springframework.data.repository.CrudRepository;

import com.whitecollar.whiteCollar.models.Shop;

public interface ShopRepository extends CrudRepository<Shop, Long> 
{
	Shop findByIdShop (String name); // check if the controller method is findByShopId 
}
