package com.hoangtien2k3.ecommerce.service.impl;
 import com.hoangtien2k3.ecommerce.dto.PaymentDto;
import com.hoangtien2k3.ecommerce.dto.PaymentEventDto;
import com.hoangtien2k3.ecommerce.dto.order.OrderDto;
import com.hoangtien2k3.ecommerce.dto.response.OrderResponse;
import com.hoangtien2k3.ecommerce.dto.response.UserResponse;
import com.hoangtien2k3.ecommerce.event.PaymentSuccessEvent;
import com.hoangtien2k3.ecommerce.exception.wrapper.PaymentNotFoundException;
import com.hoangtien2k3.ecommerce.helper.PaymentMappingHelper;
import com.hoangtien2k3.ecommerce.model.user.User;
import com.hoangtien2k3.ecommerce.repository.payment.PaymentRepository;
import com.hoangtien2k3.ecommerce.service.OrderService;
import com.hoangtien2k3.ecommerce.service.PaymentService;
import com.hoangtien2k3.ecommerce.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain;
import org.springframework.stereotype.Service;
import java.util.List;
import com.hoangtien2k3.ecommerce.Interface.OrderService;
import com.hoangtien2k3.ecommerce.Interface.UserService;
@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{

 private  PaymentRepository paymentRepository;

 private  ModelMapper modelMapper;

 private  OrderService orderService;

 private  UserService userService;

 private  ApplicationEventPublisher eventPublisher;


public void enrichWithOrder(PaymentDto paymentDto){
    try {
        OrderResponse orderResponse = buildOrderResponse(paymentDto.getOrderId());
        paymentDto.setOrderDto(orderResponse);
    } catch (Exception e) {
        log.error("Error fetching order info: {}", e.getMessage());
    }
}


public OrderResponse buildOrderResponse(Integer orderId){
    OrderDto orderDto = orderService.findById(orderId);
    return OrderResponse.builder().orderId(orderDto.getOrderId()).orderDate(orderDto.getOrderDate()).orderDesc(orderDto.getOrderDesc()).orderFee(orderDto.getOrderFee()).productId(orderDto.getProductId()).productDto(orderDto.getProductDto()).build();
}


public UserResponse buildUserResponse(Long userId){
    User user = userService.findById(userId);
    return UserResponse.builder().id(user.getId()).username(user.getUsername()).email(user.getEmail()).build();
}


@Override
public PaymentDto findById(Integer paymentId){
    log.info("*** PaymentDto, service; fetch payment by id *");
    PaymentDto paymentDto = paymentRepository.findById(paymentId).map(PaymentMappingHelper::map).orElseThrow(() -> new PaymentNotFoundException(String.format("Payment with id: %d not found", paymentId)));
    try {
        OrderResponse orderResponse = buildOrderResponse(paymentDto.getOrderId());
        paymentDto.setOrderDto(orderResponse);
        UserResponse userResponse = buildUserResponse(paymentDto.getUserId());
        paymentDto.setUserDto(userResponse);
    } catch (Exception e) {
        log.error("Error fetching order or user info: {}", e.getMessage());
    }
    return paymentDto;
}


@Override
public PaymentDto save(PaymentDto paymentDto){
    log.info("PaymentDto, service; save payment");
    if (paymentRepository.existsByOrderIdAndIsPayed(paymentDto.getOrderId())) {
        throw new PaymentNotFoundException("Order has already been paid.");
    }
    PaymentDto savedPaymentDto = PaymentMappingHelper.map(paymentRepository.save(PaymentMappingHelper.map(paymentDto)));
    PaymentEventDto paymentEventDto = PaymentEventDto.builder().paymentId(savedPaymentDto.getPaymentId()).isPayed(savedPaymentDto.getIsPayed()).paymentStatus(savedPaymentDto.getPaymentStatus()).orderId(savedPaymentDto.getOrderId()).userId(savedPaymentDto.getUserId()).build();
    eventPublisher.publishEvent(new PaymentSuccessEvent(this, paymentEventDto));
    return savedPaymentDto;
}


@Override
public void deleteById(Integer paymentId){
    log.info("Void, service; delete payment by id");
    paymentRepository.deleteById(paymentId);
}


@Override
public PaymentDto update(Integer paymentId,PaymentDto paymentDto){
    log.info("PaymentDto, service; update payment with paymentId");
    PaymentDto existingPaymentDto = findById(paymentId);
    modelMapper.map(paymentDto, existingPaymentDto);
    return PaymentMappingHelper.map(paymentRepository.save(PaymentMappingHelper.map(existingPaymentDto)));
}


public OrderResponse getOrderDto(Integer orderId){
    return buildOrderResponse(orderId);
}


@Override
public Page<PaymentDto> findAll(int page,int size,String sortBy,String sortOrder){
    log.info("PaymentDto List, service; fetch all payments with paging and sorting");
    Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortBy);
    Pageable pageable = PageRequest.of(page, size, sort);
    List<PaymentDto> paymentDtos = paymentRepository.findAll(pageable).stream().map(PaymentMappingHelper::map).peek(this::enrichWithOrder).toList();
    return new PageImpl<>(paymentDtos, pageable, paymentDtos.size());
}


}