package com.hoangtien2k3.ecommerce.controller;
 import com.hoangtien2k3.ecommerce.dto.PaymentDto;
import com.hoangtien2k3.ecommerce.dto.response.OrderResponse;
import com.hoangtien2k3.ecommerce.service.PaymentService;
import com.hoangtien2k3.ecommerce.service.impl.PaymentServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation;
import java.util.List;
@RestController
@RequestMapping("/api/payments")
@Slf4j
@RequiredArgsConstructor
public class PaymentController {

 private  PaymentService paymentService;

 private  PaymentServiceImpl paymentServiceImpl;


@GetMapping("/{paymentId}")
@PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
public ResponseEntity<PaymentDto> findById(String paymentId){
    log.info("*** PaymentDto, resource; fetch payment by id *");
    return ResponseEntity.ok(paymentService.findById(Integer.parseInt(paymentId)));
}


@PostMapping
@PreAuthorize("hasAuthority('USER')")
public ResponseEntity<PaymentDto> save(PaymentDto paymentDto){
    log.info("*** PaymentDto, resource; save payment *");
    return ResponseEntity.ok(paymentService.save(paymentDto));
}


@DeleteMapping("/{paymentId}")
@PreAuthorize("hasAuthority('USER')")
public ResponseEntity<Boolean> deleteById(Integer paymentId){
    log.info("*** Boolean, resource; delete payment by id *");
    paymentService.deleteById(paymentId);
    return ResponseEntity.ok(true);
}


@PutMapping("/{paymentId}")
@PreAuthorize("hasAuthority('USER')")
public ResponseEntity<PaymentDto> update(Integer paymentId,PaymentDto paymentDto){
    log.info("*** PaymentDto, resource; update payment with paymentId *");
    return ResponseEntity.ok(paymentService.update(paymentId, paymentDto));
}


@GetMapping("/getOrder/{orderId}")
public ResponseEntity<OrderResponse> getOrderDto(Integer orderId){
    return ResponseEntity.ok(paymentServiceImpl.getOrderDto(orderId));
}


@GetMapping("/all")
@PreAuthorize("hasAuthority('ADMIN')")
public ResponseEntity<Page<PaymentDto>> findAll(int page,int size,String sortBy,String sortOrder){
    return ResponseEntity.ok(paymentService.findAll(page, size, sortBy, sortOrder));
}


}