package com.hoangtien2k3.ecommerce.controller;
 import com.hoangtien2k3.ecommerce.constants.SortType;
import com.hoangtien2k3.ecommerce.dto.ProductListGetVm;
import com.hoangtien2k3.ecommerce.dto.ProductNameListVm;
import com.hoangtien2k3.ecommerce.service.ProductSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class CatalogSearchController {

 private  ProductSearchService productSearchService;


@GetMapping("/storefront/catalog-search")
public ResponseEntity<ProductListGetVm> findProductAdvance(String keyword,Integer page,Integer size,String brand,String category,String attribute,Double minPrice,Double maxPrice,SortType sortType){
    return ResponseEntity.ok(productSearchService.findProductAdvance(keyword, page, size, brand, category, attribute, minPrice, maxPrice, sortType));
}


@GetMapping("/storefront/search_suggest")
public ResponseEntity<ProductNameListVm> productSearchAutoComplete(String keyword){
    return ResponseEntity.ok(productSearchService.autoCompleteProductName(keyword));
}


}