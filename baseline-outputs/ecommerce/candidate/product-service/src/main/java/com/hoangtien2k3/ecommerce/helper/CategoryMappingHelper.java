package com.hoangtien2k3.ecommerce.helper;
 import com.hoangtien2k3.ecommerce.model.product.Category;
import com.hoangtien2k3.ecommerce.dto.CategoryDto;
public interface CategoryMappingHelper {


public Category map(CategoryDto categoryDto){
    final var builder = Category.builder().categoryId(categoryDto.getCategoryId()).categoryTitle(categoryDto.getCategoryTitle()).imageUrl(categoryDto.getImageUrl());
    if (categoryDto.getParentCategoryDto() != null) {
        final var parentCategoryDto = categoryDto.getParentCategoryDto();
        builder.parentCategory(Category.builder().categoryId(parentCategoryDto.getCategoryId()).categoryTitle(parentCategoryDto.getCategoryTitle()).imageUrl(parentCategoryDto.getImageUrl()).build());
    }
    return builder.build();
}
;

}