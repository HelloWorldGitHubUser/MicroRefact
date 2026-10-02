package com.hoangtien2k3.ecommerce.controller;
 import com.hoangtien2k3.ecommerce.dto.DtoCollectionResponse;
import com.hoangtien2k3.ecommerce.dto.OrderItemDto;
import com.hoangtien2k3.ecommerce.model.shipping.OrderItemId;
import com.hoangtien2k3.ecommerce.service.OrderItemService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation;
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/shippings")
public class OrderItemController {

 private  OrderItemService orderItemService;


@GetMapping("/find")
@PreAuthorize("isAuthenticated()")
public ResponseEntity<OrderItemDto> findById(OrderItemId orderItemId){
    log.info("OrderItemDto, resource; fetch orderItem by id");
    return ResponseEntity.ok(this.orderItemService.findById(orderItemId));
}


@PostMapping
@PreAuthorize("isAuthenticated()")
public ResponseEntity<OrderItemDto> save(OrderItemDto orderItemDto){
    log.info("OrderItemDto, resource; save orderItem");
    return ResponseEntity.ok(this.orderItemService.save(orderItemDto));
}


@DeleteMapping("/delete")
@PreAuthorize("isAuthenticated()")
public ResponseEntity<Boolean> deleteById(OrderItemId orderItemId){
    log.info("Boolean, resource; delete orderItem by id");
    this.orderItemService.deleteById(orderItemId);
    return ResponseEntity.ok(true);
}


@PutMapping
@PreAuthorize("isAuthenticated()")
public ResponseEntity<OrderItemDto> update(OrderItemDto orderItemDto){
    log.info("OrderItemDto, resource; update orderItem");
    return ResponseEntity.ok(this.orderItemService.update(orderItemDto));
}


@GetMapping
@PreAuthorize("isAuthenticated()")
public ResponseEntity<DtoCollectionResponse<OrderItemDto>> findAll(){
    log.info("OrderItemDto List, controller; fetch all orderItems");
    return ResponseEntity.ok(new DtoCollectionResponse<>(this.orderItemService.findAll()));
}


}