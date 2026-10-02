package com.hoangtien2k3.ecommerce.controller;
 import com.hoangtien2k3.ecommerce.dto.ProductDto;
import com.hoangtien2k3.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {

@Autowired
 private  ProductService productService;


@GetMapping("/{productId}")
public ResponseEntity<ProductDto> findById(String productId){
    log.info("ProductDto, resource; fetch product by id");
    return ResponseEntity.ok(productService.findById(Integer.parseInt(productId)));
}


@PostMapping
public ResponseEntity<ProductDto> save(ProductDto productDto){
    log.info("ProductDto, resource; save product");
    return ResponseEntity.ok(productService.save(productDto));
}


@DeleteMapping("/{productId}")
public ResponseEntity<Boolean> deleteById(String productId){
    log.info("Boolean, resource; delete product by id");
    productService.deleteById(Integer.parseInt(productId));
    return ResponseEntity.ok(true);
}


@PutMapping("/{productId}")
public ResponseEntity<ProductDto> update(String productId,ProductDto productDto){
    log.info("ProductDto, resource; update product with productId");
    return ResponseEntity.ok(productService.update(Integer.parseInt(productId), productDto));
}


@GetMapping
public ResponseEntity<List<ProductDto>> findAll(){
    log.info("ProductDto List, controller; fetch all categories");
    return ResponseEntity.ok(productService.findAll());
}


}