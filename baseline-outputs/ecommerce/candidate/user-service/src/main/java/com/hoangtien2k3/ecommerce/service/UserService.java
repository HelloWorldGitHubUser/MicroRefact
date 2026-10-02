package com.hoangtien2k3.ecommerce.service;
 import com.hoangtien2k3.ecommerce.dto.request.ChangePasswordRequest;
import com.hoangtien2k3.ecommerce.dto.request.Login;
import com.hoangtien2k3.ecommerce.dto.request.SignUp;
import com.hoangtien2k3.ecommerce.dto.request.UserDto;
import com.hoangtien2k3.ecommerce.dto.response.JwtResponseMessage;
import com.hoangtien2k3.ecommerce.model.user.User;
import org.springframework.data.domain.Page;
public interface UserService {


public void logout()
;

public User findByUsername(String userName)
;

public User findById(Long userId)
;

public User update(Long userId,SignUp update)
;

public Page<UserDto> findAllUsers(int page,int size,String sortBy,String sortOrder)
;

public JwtResponseMessage login(Login signInForm)
;

public String delete(Long id)
;

public User register(SignUp signUp)
;

public String changePassword(ChangePasswordRequest request)
;

}