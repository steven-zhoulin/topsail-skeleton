package com.topsail.skeleton.system.mapper;

import com.topsail.skeleton.system.domain.Job;
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
public interface JobMapper {
    @Delete({
        "delete from job",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into job (name, enabled, ",
        "create_time, sort, ",
        "dept_id)",
        "values (#{name,jdbcType=VARCHAR}, #{enabled,jdbcType=BIT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{sort,jdbcType=BIGINT}, ",
        "#{deptId,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Job record);

    @Select({
        "select",
        "id, name, enabled, create_time, sort, dept_id",
        "from job",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="enabled", property="enabled", jdbcType=JdbcType.BIT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="sort", property="sort", jdbcType=JdbcType.BIGINT),
        @Result(column="dept_id", property="deptId", jdbcType=JdbcType.BIGINT)
    })
    Job selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, name, enabled, create_time, sort, dept_id",
        "from job"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="enabled", property="enabled", jdbcType=JdbcType.BIT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="sort", property="sort", jdbcType=JdbcType.BIGINT),
        @Result(column="dept_id", property="deptId", jdbcType=JdbcType.BIGINT)
    })
    List<Job> selectAll();

    @Update({
        "updateByPrimaryKey job",
        "set name = #{name,jdbcType=VARCHAR},",
          "enabled = #{enabled,jdbcType=BIT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "sort = #{sort,jdbcType=BIGINT},",
          "dept_id = #{deptId,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Job record);
}