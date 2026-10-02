package com.hoangtien2k3.ecommerce.helper;
 import com.hoangtien2k3.ecommerce.dto.FavouriteDto;
import com.hoangtien2k3.ecommerce.dto.FavouriteUserDto;
import com.hoangtien2k3.ecommerce.dto.response.ProductResponse;
import com.hoangtien2k3.ecommerce.model.favourite.Favourite;
public class FavouriteMappingHelper {


public Favourite map(FavouriteDto favouriteDto){
    return Favourite.builder().userId(favouriteDto.getUserId()).productId(favouriteDto.getProductId()).likeDate(favouriteDto.getLikeDate()).build();
}


}