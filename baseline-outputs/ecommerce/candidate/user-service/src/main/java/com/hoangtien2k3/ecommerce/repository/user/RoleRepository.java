package com.hoangtien2k3.ecommerce.repository.user;
 import com.hoangtien2k3.ecommerce.model.user.Role;
import com.hoangtien2k3.ecommerce.model.user.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{


@Query("SELECT u.roles FROM User u WHERE u.id = :id")
public List<Role> findByUserId(Long id)
;

@Query("SELECT r FROM Role r WHERE r.name = :name")
public Optional<Role> findByName(RoleName name)
;

}