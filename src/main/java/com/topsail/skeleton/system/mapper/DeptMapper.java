package com.topsail.skeleton.system.mapper;

import com.topsail.skeleton.system.domain.Dept;
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
        "#{createTime,jdbcType=TIMESTAMP}, #{enabled,jdbcType=BIT})"
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

    @Update({
        "updateByPrimaryKey dept",
        "set name = #{name,jdbcType=VARCHAR},",
          "pid = #{pid,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "enabled = #{enabled,jdbcType=BIT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Dept record);
}