package com.hoangtien2k3.ecommerce.dto.request;
 import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@RequiredArgsConstructor
public class ChangePasswordRequest {

 private String oldPassword;

 private String newPassword;

 private String confirmPassword;


}