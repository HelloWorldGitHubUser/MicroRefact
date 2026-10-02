package com.hoangtien2k3.ecommerce.repository.user;
 import com.hoangtien2k3.ecommerce.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{


@Query("SELECT u FROM User u WHERE u.username = :username")
public Optional<User> findByUsername(String username)
;

@Query("SELECT u FROM User u WHERE u.id = :id")
public Optional<User> findById(Long id)
;

@Query("SELECT CASE WHEN COUNT(u) > 0 " + "THEN true " + "ELSE false " + "END FROM User u " + "WHERE u.username = :username")
public Boolean existsByUsername(String username)
;

@Query("SELECT CASE WHEN COUNT(u) > 0 " + "THEN true " + "ELSE false " + "END FROM User u WHERE u.email = :email")
public Boolean existsByEmail(String email)
;

@Query("SELECT u FROM User u WHERE u.email = :email")
public Optional<User> findByEmail(String name)
;

@Query("SELECT CASE WHEN COUNT(u) > 0 " + "THEN true " + "ELSE false " + "END FROM User u WHERE u.phone = :phone")
public Boolean existsByPhoneNumber(String phone)
;

}