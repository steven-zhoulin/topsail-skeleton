package com.topsail.skeleton.system.mapper;

import com.topsail.skeleton.system.domain.RolesDepts;
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
public interface RolesDeptsMapper {
    @Delete({
        "delete from roles_depts",
        "where role_id = #{roleId,jdbcType=BIGINT}",
          "and dept_id = #{deptId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(@Param("roleId") Long roleId, @Param("deptId") Long deptId);

    @Insert({
        "insert into roles_depts (role_id, dept_id)",
        "values (#{roleId,jdbcType=BIGINT}, #{deptId,jdbcType=BIGINT})"
    })
    int insert(RolesDepts record);

    @Select({
        "select",
        "role_id, dept_id",
        "from roles_depts"
    })
    @Results({
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="dept_id", property="deptId", jdbcType=JdbcType.BIGINT, id=true)
    })
    List<RolesDepts> selectAll();
}