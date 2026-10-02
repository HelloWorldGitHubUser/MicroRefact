package com.hoangtien2k3.ecommerce.controller;
 import com.hoangtien2k3.ecommerce.dto.order.CartDto;
import com.hoangtien2k3.ecommerce.service.CartService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation;
import java.util.List;
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/carts")
@Tag(name = "CartController", description = "Operations related to carts")
public class CartController {

 private  CartService cartService;


@GetMapping("/{cartId}")
@PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
public ResponseEntity<CartDto> findById(String cartId){
    log.info("*** CartDto, resource; fetch cart by id *");
    return ResponseEntity.ok(cartService.findById(Integer.parseInt(cartId)));
}


@PostMapping
@PreAuthorize("hasAuthority('USER')")
public ResponseEntity<CartDto> save(CartDto cartDto){
    log.info("*** CartDto, resource; save cart *");
    return ResponseEntity.ok(cartService.save(cartDto));
}


@DeleteMapping("/{cartId}")
@PreAuthorize("hasAuthority('USER')")
public ResponseEntity<Boolean> deleteById(String cartId){
    log.info("*** Boolean, resource; delete cart by id *");
    cartService.deleteById(Integer.parseInt(cartId));
    return ResponseEntity.ok(true);
}


@PutMapping("/{cartId}")
@PreAuthorize("hasAuthority('USER')")
public ResponseEntity<CartDto> update(String cartId,CartDto cartDto){
    log.info("*** CartDto, resource; update cart with cartId *");
    return ResponseEntity.ok(cartService.update(Integer.parseInt(cartId), cartDto));
}


@GetMapping("/all")
@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
public ResponseEntity<Page<CartDto>> findAll(int page,int size,String sortBy,String sortOrder){
    return ResponseEntity.ok(cartService.findAll(page, size, sortBy, sortOrder));
}


}