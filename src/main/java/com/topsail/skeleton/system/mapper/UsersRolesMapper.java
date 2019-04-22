package com.topsail.skeleton.system.mapper;

import com.topsail.skeleton.system.domain.po.UsersRoles;
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
public interface UsersRolesMapper {
    @Delete({
        "delete from users_roles",
        "where user_id = #{userId,jdbcType=BIGINT}",
          "and role_id = #{roleId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(@Param("userId") Long userId, @Param("roleId") Long roleId);

    @Insert({
        "insert into users_roles (user_id, role_id)",
        "values (#{userId,jdbcType=BIGINT}, #{roleId,jdbcType=BIGINT})"
    })
    int insert(UsersRoles record);

    @Select({
        "select",
        "user_id, role_id",
        "from users_roles"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.BIGINT, id=true)
    })
    List<UsersRoles> selectAll();
}