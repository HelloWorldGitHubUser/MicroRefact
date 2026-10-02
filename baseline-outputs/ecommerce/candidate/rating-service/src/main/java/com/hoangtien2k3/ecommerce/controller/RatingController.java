package com.hoangtien2k3.ecommerce.controller;
 import com.hoangtien2k3.ecommerce.dto.RatingListVm;
import com.hoangtien2k3.ecommerce.dto.RatingPostVm;
import com.hoangtien2k3.ecommerce.dto.RatingVm;
import com.hoangtien2k3.ecommerce.dto.ResponeStatusVm;
import com.hoangtien2k3.ecommerce.service.RatingService;
import java.time.ZonedDateTime;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/rating")
public class RatingController {

 private  RatingService ratingService;

public RatingController(RatingService ratingService) {
    this.ratingService = ratingService;
}
@PostMapping("/storefront/ratings")
public ResponseEntity<RatingVm> createRating(RatingPostVm ratingPostVm){
    return ResponseEntity.ok(ratingService.createRating(ratingPostVm));
}


@GetMapping("/storefront/ratings/product/{productId}/average-star")
public Double getAverageStarOfProduct(Long productId){
    return ratingService.calculateAverageStar(productId);
}


@DeleteMapping("/backoffice/ratings/{id}")
public ResponseEntity<ResponeStatusVm> deleteRating(Long id){
    return ResponseEntity.ok(ratingService.deleteRating(id));
}


@GetMapping("/backoffice/ratings")
public ResponseEntity<RatingListVm> getRatingListWithFilter(String productName,String cusName,String message,ZonedDateTime createdFrom,ZonedDateTime createdTo,int pageNo,int pageSize){
    return ResponseEntity.ok(ratingService.getRatingListWithFilter(productName, cusName, message, createdFrom, createdTo, pageNo, pageSize));
}


@GetMapping({ "/storefront/ratings/products/{productId}" })
public ResponseEntity<RatingListVm> getRatingList(Long productId,int pageNo,int pageSize){
    return ResponseEntity.ok(ratingService.getRatingListByProductId(productId, pageNo, pageSize));
}


}