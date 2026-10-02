package com.hoangtien2k3.ecommerce.repository.product;
 import com.hoangtien2k3.ecommerce.model.product.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CategoryRepository extends JpaRepository<Category, Integer>{


public Page<Category> findByCategoryTitleContaining(String categoryTitle,Pageable pageable)
;

public Page<Category> findAll(Pageable pageable)
;

}