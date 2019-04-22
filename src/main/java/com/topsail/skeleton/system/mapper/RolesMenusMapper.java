package com.topsail.skeleton.system.mapper;

import com.topsail.skeleton.system.domain.po.RolesMenus;
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
public interface RolesMenusMapper {
    @Delete({
        "delete from roles_menus",
        "where menu_id = #{menuId,jdbcType=BIGINT}",
          "and role_id = #{roleId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(@Param("menuId") Long menuId, @Param("roleId") Long roleId);

    @Insert({
        "insert into roles_menus (menu_id, role_id)",
        "values (#{menuId,jdbcType=BIGINT}, #{roleId,jdbcType=BIGINT})"
    })
    int insert(RolesMenus record);

    @Select({
        "select",
        "menu_id, role_id",
        "from roles_menus"
    })
    @Results({
        @Result(column="menu_id", property="menuId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.BIGINT, id=true)
    })
    List<RolesMenus> selectAll();
}