package com.hoangtien2k3.ecommerce.controller;
 import com.hoangtien2k3.ecommerce.dto.CategoryDto;
import com.hoangtien2k3.ecommerce.dto.ProductDto;
import com.hoangtien2k3.ecommerce.helper.CategoryMappingHelper;
import com.hoangtien2k3.ecommerce.helper.ProductMappingHelper;
import com.hoangtien2k3.ecommerce.repository.product.CategoryRepository;
import com.hoangtien2k3.ecommerce.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collections;
import java.util.List;
@RestController
@RequestMapping("/backoffice")
@RequiredArgsConstructor
public class ProductBackofficeController {

 private  ProductRepository productRepository;

 private  CategoryRepository categoryRepository;


@GetMapping("/brands/by-ids")
public ResponseEntity<List<?>> getBrandsByIds(List<Long> ids){
    return ResponseEntity.ok(Collections.emptyList());
}


@GetMapping("/categories/by-ids")
public ResponseEntity<List<CategoryDto>> getCategoriesByIds(List<Integer> ids){
    List<CategoryDto> categories = categoryRepository.findAllById(ids).stream().map(CategoryMappingHelper::map).toList();
    return ResponseEntity.ok(categories);
}


@GetMapping("/products/by-ids")
public ResponseEntity<List<ProductDto>> getProductsByIds(List<Integer> ids){
    List<ProductDto> products = productRepository.findAllById(ids).stream().map(ProductMappingHelper::map).toList();
    return ResponseEntity.ok(products);
}


}