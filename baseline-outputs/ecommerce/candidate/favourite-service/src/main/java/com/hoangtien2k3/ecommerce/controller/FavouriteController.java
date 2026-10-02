package com.hoangtien2k3.ecommerce.controller;
 import com.hoangtien2k3.ecommerce.constants.AppConstant;
import com.hoangtien2k3.ecommerce.dto.DtoCollectionResponse;
import com.hoangtien2k3.ecommerce.dto.FavouriteDto;
import com.hoangtien2k3.ecommerce.model.favourite.FavouriteId;
import com.hoangtien2k3.ecommerce.service.FavouriteService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Slf4j
@RestController
@RequestMapping("/api/favourites")
@RequiredArgsConstructor
public class FavouriteController {

 private  FavouriteService favouriteService;


@GetMapping("/find")
public ResponseEntity<FavouriteDto> findById(FavouriteId favouriteId){
    return ResponseEntity.ok(this.favouriteService.findById(favouriteId));
}


@PostMapping
public ResponseEntity<FavouriteDto> save(FavouriteDto favouriteDto){
    return ResponseEntity.ok(this.favouriteService.save(favouriteDto));
}


@DeleteMapping("/delete")
public ResponseEntity<Boolean> deleteById(FavouriteId favouriteId){
    favouriteService.deleteById(favouriteId);
    return ResponseEntity.ok(true);
}


@PutMapping
public ResponseEntity<FavouriteDto> update(FavouriteDto favouriteDto){
    return ResponseEntity.ok(this.favouriteService.update(favouriteDto));
}


@GetMapping
public ResponseEntity<DtoCollectionResponse<FavouriteDto>> findAll(){
    return ResponseEntity.ok(new DtoCollectionResponse<>(this.favouriteService.findAll()));
}


}