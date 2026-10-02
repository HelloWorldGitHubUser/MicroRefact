package com.hoangtien2k3.ecommerce.controller;
 import com.hoangtien2k3.ecommerce.exception.wrapper.TokenErrorOrAccessTimeOut;
import com.hoangtien2k3.ecommerce.utils.HeaderGenerator;
import com.hoangtien2k3.ecommerce.dto.request.ChangePasswordRequest;
import com.hoangtien2k3.ecommerce.dto.request.SignUp;
import com.hoangtien2k3.ecommerce.dto.request.UserDto;
import com.hoangtien2k3.ecommerce.dto.response.ResponseMessage;
import com.hoangtien2k3.ecommerce.model.user.User;
import com.hoangtien2k3.ecommerce.security.jwt.JwtProvider;
import com.hoangtien2k3.ecommerce.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation;
@Slf4j
@RestController
@RequestMapping("/api/manager")
@Tag(name = "User API", description = "Operations related to users")
public class UserManager {

 private  ModelMapper modelMapper;

 private  UserService userService;

 private  HeaderGenerator headerGenerator;

 private  JwtProvider jwtProvider;

@Autowired
public UserManager(UserService userService, HeaderGenerator headerGenerator, JwtProvider jwtProvider, ModelMapper modelMapper) {
    this.userService = userService;
    this.headerGenerator = headerGenerator;
    this.jwtProvider = jwtProvider;
    this.modelMapper = modelMapper;
}
@Operation(summary = "Get all users (admin)")
@GetMapping("/all")
@PreAuthorize("hasAuthority('ADMIN')")
public ResponseEntity<Page<UserDto>> getAllUsers(int page,int size,String sortBy,String sortOrder){
    Page<UserDto> usersPage = userService.findAllUsers(page, size, sortBy, sortOrder);
    return new ResponseEntity<>(usersPage, headerGenerator.getHeadersForSuccessGetMethod(), HttpStatus.OK);
}


@Operation(summary = "Get user by ID", description = "Retrieve user information based on the provided ID.")
@ApiResponses({ @ApiResponse(responseCode = "200", description = "User retrieved successfully"), @ApiResponse(responseCode = "404", description = "User not found") })
@GetMapping("/user/{id}")
@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER') and principal.id == #id")
public ResponseEntity<?> getUserById(Long id){
    User user = userService.findById(id);
    UserDto userDto = modelMapper.map(user, UserDto.class);
    return new ResponseEntity<>(userDto, headerGenerator.getHeadersForSuccessGetMethod(), HttpStatus.OK);
}


@Operation(summary = "Get user by username", description = "Retrieve user information based on the provided username.")
@GetMapping("/user")
@PreAuthorize("hasAuthority('ADMIN') or (isAuthenticated() and hasAuthority('USER') and #p0 == authentication.name)")
public ResponseEntity<?> getUserByUsername(String username){
    User user = userService.findByUsername(username);
    UserDto userDto = modelMapper.map(user, UserDto.class);
    return new ResponseEntity<>(userDto, headerGenerator.getHeadersForSuccessGetMethod(), HttpStatus.OK);
}


@Operation(summary = "Update user information", description = "Update the user information with the provided details.")
@ApiResponses({ @ApiResponse(responseCode = "200", description = "User updated successfully"), @ApiResponse(responseCode = "400", description = "Bad Request") })
@PutMapping("update/{id}")
@PreAuthorize("isAuthenticated() and hasAuthority('USER')")
public ResponseEntity<ResponseMessage> update(Long id,SignUp updateDTO){
    try {
        userService.update(id, updateDTO);
        return new ResponseEntity<>(new ResponseMessage("Update user: " + updateDTO.getUsername() + " successfully."), HttpStatus.OK);
    } catch (Exception error) {
        return new ResponseEntity<>(new ResponseMessage("Update user: " + updateDTO.getUsername() + " failed " + error.getMessage()), HttpStatus.BAD_REQUEST);
    }
}


@Operation(summary = "Get user information from token", description = "Retrieve user information based on the provided JWT token.")
@ApiResponses({ @ApiResponse(responseCode = "200", description = "User information retrieved successfully"), @ApiResponse(responseCode = "404", description = "User not found") })
@GetMapping("/info")
public ResponseEntity<?> getUserInfo(String token){
    String username = jwtProvider.getUserNameFromToken(token);
    User user = userService.findByUsername(username);
    if (user == null) {
        throw new TokenErrorOrAccessTimeOut("Token error or access timeout");
    }
    UserDto userDto = modelMapper.map(user, UserDto.class);
    return new ResponseEntity<>(userDto, headerGenerator.getHeadersForSuccessGetMethod(), HttpStatus.OK);
}


@Operation(summary = "Delete user", description = "Delete a user with the specified ID.")
@DeleteMapping("delete/{id}")
@PreAuthorize("isAuthenticated() and (hasAuthority('USER') or hasAuthority('ADMIN'))")
public ResponseEntity<String> delete(Long id){
    return ResponseEntity.ok(userService.delete(id));
}


@Operation(summary = "Change user password", description = "Change the password for the authenticated user.")
@PutMapping("/change-password")
@PreAuthorize("isAuthenticated() and hasAuthority('USER')")
public ResponseEntity<String> changePassword(ChangePasswordRequest request){
    return ResponseEntity.ok(userService.changePassword(request));
}


}