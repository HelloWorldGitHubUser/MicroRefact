package com.hoangtien2k3.ecommerce.service;
 import com.hoangtien2k3.ecommerce.dto.CategoryDto;
import org.springframework.data.domain.Page;
import java.util.List;
public interface CategoryService {


public CategoryDto findById(Integer categoryId)
;

public Page<CategoryDto> findAllCategory(int page,int size)
;

public CategoryDto save(CategoryDto categoryDto)
;

public void deleteById(Integer categoryId)
;

public CategoryDto update(Integer categoryId,CategoryDto categoryDto)
;

public List<CategoryDto> getAllCategories(Integer pageNo,Integer pageSize,String sortBy)
;

public List<CategoryDto> findAll()
;

}