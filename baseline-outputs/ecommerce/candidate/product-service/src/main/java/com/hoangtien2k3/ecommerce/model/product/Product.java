package com.hoangtien2k3.ecommerce.model.product;
 import lombok;
import jakarta.persistence;
import java.io.Serial;
import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = { "category" })
@Data
@Builder
@Entity
@Table(name = "products")
public class Product extends AbstractMappedEntityimplements Serializable{

@Serial
 private  long serialVersionUID;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "product_id", unique = true, nullable = false, updatable = false)
 private  Integer productId;

@Column(name = "product_title")
 private  String productTitle;

@Column(name = "image_url")
 private  String imageUrl;

@Column(unique = true)
 private  String sku;

@Column(name = "price_unit", columnDefinition = "decimal")
 private  Double priceUnit;

@Column(name = "quantity")
 private  Integer quantity;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "category_id")
 private  Category category;


}