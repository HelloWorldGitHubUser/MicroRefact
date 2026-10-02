package com.hoangtien2k3.ecommerce.service.impl;
 import com.hoangtien2k3.ecommerce.dto.order.CartDto;
import com.hoangtien2k3.ecommerce.dto.response.UserResponse;
import com.hoangtien2k3.ecommerce.exception.wrapper.CartNotFoundException;
import com.hoangtien2k3.ecommerce.helper.CartMappingHelper;
import com.hoangtien2k3.ecommerce.model.order.Cart;
import com.hoangtien2k3.ecommerce.model.user.User;
import com.hoangtien2k3.ecommerce.repository.order.CartRepository;
import com.hoangtien2k3.ecommerce.repository.order.OrderRepository;
import com.hoangtien2k3.ecommerce.service.CartService;
import com.hoangtien2k3.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.hoangtien2k3.ecommerce.Interface.UserService;
@Slf4j
@RequiredArgsConstructor
@Service("cartServiceImpl")
public class CartServiceImpl implements CartService{

 private  CartRepository cartRepository;

 private  OrderRepository orderRepository;

 private  ModelMapper modelMapper;

 private  UserService userService;


public void enrichWithUser(CartDto cartDto){
    try {
        if (cartDto.getUserDto() == null || cartDto.getUserDto().getId() == null) {
            return;
        }
        User user = userService.findById(cartDto.getUserDto().getId());
        cartDto.setUserDto(UserResponse.builder().id(user.getId()).fullname(user.getFullname()).username(user.getUsername()).email(user.getEmail()).gender(user.getGender()).phone(user.getPhone()).avatar(user.getAvatar()).build());
    } catch (Exception e) {
        log.error("Error fetching user info: {}", e.getMessage());
    }
}


@Transactional(value = "mysqlTransactionManager", readOnly = true)
@Override
public CartDto findById(Integer cartId){
    log.info("CartDto, service; fetch cart by id");
    CartDto cartDto = cartRepository.findById(cartId).map(CartMappingHelper::map).orElseThrow(() -> new CartNotFoundException(String.format("Cart with id: %d not found", cartId)));
    enrichWithUser(cartDto);
    return cartDto;
}


@Override
public CartDto save(CartDto cartDto){
    log.info("CartDto, service; save cart");
    return modelMapper.map(cartRepository.save(modelMapper.map(cartDto, Cart.class)), CartDto.class);
}


@Override
@Transactional("mysqlTransactionManager")
public void deleteById(Integer cartId){
    log.info("Void, service; delete cart by id");
    cartRepository.findById(cartId).ifPresent(cart -> {
        orderRepository.deleteAllByCart(cart);
        cartRepository.deleteById(cartId);
    });
}


@Transactional("mysqlTransactionManager")
@Override
public CartDto update(Integer cartId,CartDto cartDto){
    log.info("CartDto, service; update cart with cartId");
    CartDto existingCartDto = findById(cartId);
    modelMapper.map(cartDto, existingCartDto);
    return CartMappingHelper.map(cartRepository.save(CartMappingHelper.map(existingCartDto)));
}


@Transactional(value = "mysqlTransactionManager", readOnly = true)
@Override
public Page<CartDto> findAll(int page,int size,String sortBy,String sortOrder){
    log.info("CartDto List, service; fetch all carts with paging and sorting");
    Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortBy);
    Pageable pageable = PageRequest.of(page, size, sort);
    List<CartDto> cartDtos = cartRepository.findAll(pageable).stream().map(CartMappingHelper::map).peek(this::enrichWithUser).toList();
    return new PageImpl<>(cartDtos, pageable, cartDtos.size());
}


}