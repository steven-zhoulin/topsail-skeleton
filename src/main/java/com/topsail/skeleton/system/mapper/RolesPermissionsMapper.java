package com.topsail.skeleton.system.mapper;

import com.topsail.skeleton.system.domain.RolesPermissions;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface RolesPermissionsMapper {
    @Delete({
        "delete from roles_permissions",
        "where role_id = #{roleId,jdbcType=BIGINT}",
          "and permission_id = #{permissionId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);

    @Insert({
        "insert into roles_permissions (role_id, permission_id)",
        "values (#{roleId,jdbcType=BIGINT}, #{permissionId,jdbcType=BIGINT})"
    })
    int insert(RolesPermissions record);

    @Select({
        "select",
        "role_id, permission_id",
        "from roles_permissions"
    })
    @Results({
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="permission_id", property="permissionId", jdbcType=JdbcType.BIGINT, id=true)
    })
    List<RolesPermissions> selectAll();
}