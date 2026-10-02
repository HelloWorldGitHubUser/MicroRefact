package com.hoangtien2k3.ecommerce.helper;
 import com.hoangtien2k3.ecommerce.model.product.Category;
import com.hoangtien2k3.ecommerce.model.product.Product;
import com.hoangtien2k3.ecommerce.dto.CategoryDto;
import com.hoangtien2k3.ecommerce.dto.ProductDto;
public interface ProductMappingHelper {


public Product map(ProductDto productDto){
    return Product.builder().productId(productDto.getProductId()).productTitle(productDto.getProductTitle()).imageUrl(productDto.getImageUrl()).sku(productDto.getSku()).priceUnit(productDto.getPriceUnit()).quantity(productDto.getQuantity()).category(Category.builder().categoryId(productDto.getCategoryDto().getCategoryId()).categoryTitle(productDto.getCategoryDto().getCategoryTitle()).imageUrl(productDto.getCategoryDto().getImageUrl()).build()).build();
}
;

}