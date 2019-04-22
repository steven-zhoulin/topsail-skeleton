package com.topsail.skeleton.system.mapper;

import com.topsail.skeleton.system.domain.po.Permission;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface PermissionMapper {
    @Delete({
            "delete from permission",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
            "insert into permission (alias, create_time, ",
            "name, pid)",
            "values (#{alias,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
            "#{name,jdbcType=VARCHAR}, #{pid,jdbcType=BIGINT})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int insert(Permission record);

    @Select({
            "select",
            "id, alias, create_time, name, pid",
            "from permission",
            "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "alias", property = "alias", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "pid", property = "pid", jdbcType = JdbcType.BIGINT)
    })
    Permission selectByPrimaryKey(Long id);

    @Select({"select id, alias, create_time, name, pid from permission"})
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "alias", property = "alias", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "pid", property = "pid", jdbcType = JdbcType.BIGINT)
    })
    List<Permission> selectAll();

    @Update({
            "update permission",
            "set alias = #{alias,jdbcType=VARCHAR},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "name = #{name,jdbcType=VARCHAR},",
            "pid = #{pid,jdbcType=BIGINT}",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Permission record);
}