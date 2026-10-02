package com.hoangtien2k3.ecommerce.service;
 import com.hoangtien2k3.ecommerce.dto.FavouriteDto;
import com.hoangtien2k3.ecommerce.model.favourite.FavouriteId;
import java.util.List;
public interface FavouriteService {


public FavouriteDto findById(FavouriteId favouriteId)
;

public FavouriteDto save(FavouriteDto favouriteDto)
;

public void deleteById(FavouriteId favouriteId)
;

public FavouriteDto update(FavouriteDto favouriteDto)
;

public List<FavouriteDto> findAll()
;

}