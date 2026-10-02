package com.hoangtien2k3.ecommerce.service;
 import com.hoangtien2k3.ecommerce.model.user.Role;
import com.hoangtien2k3.ecommerce.model.user.RoleName;
import java.util.List;
import java.util.Optional;
public interface RoleService {


public boolean revokeRole(Long id,String roleName)
;

public Optional<Role> findByName(RoleName name)
;

public boolean assignRole(Long id,String roleName)
;

public List<String> getUserRoles(Long id)
;

}