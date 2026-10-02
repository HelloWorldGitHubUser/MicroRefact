package com.goodskill.service;
 import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.goodskill.entity.mysql.Permission;
import com.goodskill.entity.mysql.Role;
import com.goodskill.entity.mysql.User;
import com.goodskill.dto.UserDTO;
import java.util.Set;
public interface UserService extends IService<User>{


public User getUserInfoById(String userId)
;

public boolean removeById(int userId)
;

public boolean checkPassword(String password,String passwordInput)
;

public User findByUserAccount(String username)
;

public boolean updateLastLoginTime(Integer id)
;

public Set<Permission> findPermissions(String username)
;

public IPage<User> page(Page<User> page)
;

public Set<Role> findRoles(String username)
;

public boolean addRole(int userId,int roleId)
;

public void register(UserDTO user)
;

}