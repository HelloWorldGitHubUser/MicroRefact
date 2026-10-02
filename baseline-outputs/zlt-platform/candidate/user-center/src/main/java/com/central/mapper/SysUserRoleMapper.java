package com.central.mapper;
 import java.util.List;
import com.central.entity.SysRoleUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.central.entity.SysRole;
@Mapper
public interface SysUserRoleMapper extends SuperMapper<SysRoleUser>{


@Insert("insert into sys_role_user(user_id, role_id) values(#{userId}, #{roleId})")
public int saveUserRoles(Long userId,Long roleId)
;

public int deleteUserRole(Long userId,Long roleId)
;

@Select("<script>select r.*,ru.user_id from sys_role_user ru inner join sys_role r on r.id = ru.role_id where ru.user_id IN " + " <foreach item='item' index='index' collection='list' open='(' separator=',' close=')'> " + " #{item} " + " </foreach>" + "</script>")
public List<SysRole> findRolesByUserIds(List<Long> userIds)
;

public List<SysRole> findRolesByUserId(Long userId)
;

}