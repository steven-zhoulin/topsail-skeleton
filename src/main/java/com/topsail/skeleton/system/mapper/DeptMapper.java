package com.topsail.skeleton.system.mapper;

import com.topsail.skeleton.system.domain.Dept;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Delete({
        "delete from dept",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into dept (name, pid, ",
        "create_time, enabled)",
        "values (#{name,jdbcType=VARCHAR}, #{pid,jdbcType=BIGINT}, ",
        "now(), #{enabled,jdbcType=BIT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Dept record);

    @Select({
        "select",
        "id, name, pid, create_time, enabled",
        "from dept",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="pid", property="pid", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="enabled", property="enabled", jdbcType=JdbcType.BIT)
    })
    Dept selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, name, pid, create_time, enabled",
        "from dept"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="pid", property="pid", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="enabled", property="enabled", jdbcType=JdbcType.BIT)
    })
    List<Dept> selectAll();

    @SelectProvider(type = DeptSQLProvider.class, method="getSelectLikeName")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "pid", property = "pid", jdbcType = JdbcType.BIGINT),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "enabled", property = "enabled", jdbcType = JdbcType.BIT)
    })
    List<Dept> selectLikeName(@Param("content")String content, @Param("enabled") Boolean enabled);

    @Update({
        "update dept",
        "set name = #{name,jdbcType=VARCHAR},",
          "pid = #{pid,jdbcType=BIGINT},",
          "enabled = #{enabled,jdbcType=BIT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Dept record);
}