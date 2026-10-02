package com.hoangtien2k3.ecommerce.controller;
 import com.hoangtien2k3.ecommerce.dto.order.OrderDto;
import com.hoangtien2k3.ecommerce.service.OrderService;
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
@RequestMapping("/api/orders")
@Tag(name = "OrderController", description = "Operations related to orders")
public class OrderController {

 private  OrderService orderService;


@GetMapping("/{orderId}")
@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
public ResponseEntity<OrderDto> findById(String orderId){
    log.info("*** OrderDto, resource; fetch order by id *");
    return ResponseEntity.ok(orderService.findById(Integer.parseInt(orderId)));
}


@PostMapping
@PreAuthorize("hasAuthority('USER')")
public ResponseEntity<OrderDto> save(OrderDto orderDto){
    log.info("*** OrderDto, resource; save order *");
    return ResponseEntity.ok(orderService.save(orderDto));
}


@DeleteMapping("/{orderId}")
@PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
public ResponseEntity<Boolean> deleteById(String orderId){
    log.info("*** Boolean, resource; delete order by id *");
    orderService.deleteById(Integer.parseInt(orderId));
    return ResponseEntity.ok(true);
}


@PutMapping("/{orderId}")
@PreAuthorize("hasAuthority('USER')")
public ResponseEntity<OrderDto> update(String orderId,OrderDto orderDto){
    log.info("*** OrderDto, resource; update order with orderId *");
    return ResponseEntity.ok(orderService.update(Integer.parseInt(orderId), orderDto));
}


@GetMapping("/all")
@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
public ResponseEntity<Page<OrderDto>> findAll(int page,int size,String sortBy,String sortOrder){
    return ResponseEntity.ok(orderService.findAll(page, size, sortBy, sortOrder));
}


@GetMapping("/existOrderId")
public Boolean existsByOrderId(Integer orderId){
    return orderService.existsByOrderId(orderId);
}


}