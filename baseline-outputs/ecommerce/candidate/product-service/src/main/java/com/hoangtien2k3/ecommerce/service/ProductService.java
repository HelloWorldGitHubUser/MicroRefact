package com.hoangtien2k3.ecommerce.service;
 import com.hoangtien2k3.ecommerce.dto.ProductDto;
import java.util.List;
public interface ProductService {


public ProductDto findById(Integer productId)
;

public ProductDto save(ProductDto productDto)
;

public void deleteById(Integer productId)
;

public ProductDto update(Integer productId,ProductDto productDto)
;

public List<ProductDto> findAll()
;

}