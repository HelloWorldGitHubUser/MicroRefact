package com.hoangtien2k3.ecommerce.controller;
 import com.hoangtien2k3.ecommerce.dto.CategoryDto;
import com.hoangtien2k3.ecommerce.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

@Autowired
 private  CategoryService categoryService;


@GetMapping("/{categoryId}")
public ResponseEntity<CategoryDto> findById(String categoryId){
    log.info("CategoryDto, resource; fetch category by id");
    return ResponseEntity.ok(categoryService.findById(Integer.parseInt(categoryId)));
}


@PostMapping
public ResponseEntity<CategoryDto> save(CategoryDto categoryDto){
    log.info("CategoryDto, resource; save category");
    return ResponseEntity.ok(categoryService.save(categoryDto));
}


@DeleteMapping("/{categoryId}")
public ResponseEntity<Boolean> deleteById(String categoryId){
    log.info("Boolean, resource; delete category by id");
    categoryService.deleteById(Integer.parseInt(categoryId));
    return ResponseEntity.ok(true);
}


@PutMapping("/{categoryId}")
public ResponseEntity<CategoryDto> update(String categoryId,CategoryDto categoryDto){
    log.info("CategoryDto, resource; update category with categoryId");
    return ResponseEntity.ok(categoryService.update(Integer.parseInt(categoryId), categoryDto));
}


@GetMapping("/paging")
public ResponseEntity<Page<CategoryDto>> getAllCategories(int page,int size){
    Page<CategoryDto> categoryPage = categoryService.findAllCategory(page, size);
    return new ResponseEntity<>(categoryPage, HttpStatus.OK);
}


@GetMapping
public ResponseEntity<List<CategoryDto>> findAll(){
    log.info("CategoryDto List, controller; fetch all categories");
    return ResponseEntity.ok(categoryService.findAll());
}


@GetMapping("/paging-and-sorting")
public ResponseEntity<List<CategoryDto>> getAllEmployees(Integer pageNo,Integer pageSize,String sortBy){
    List<CategoryDto> list = categoryService.getAllCategories(pageNo, pageSize, sortBy);
    return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
}


}