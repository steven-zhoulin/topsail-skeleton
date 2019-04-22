package com.topsail.skeleton.system.mapper;

import com.topsail.skeleton.system.domain.po.Dept;
import com.topsail.skeleton.system.domain.po.Job;
import com.topsail.skeleton.system.mapper.provider.JobSQLProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

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
            "now(), #{sort,jdbcType=BIGINT}, ",
            "#{deptId,jdbcType=BIGINT})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int insert(Job record);

    @Select({
            "select",
            "id, name, enabled, create_time, sort, dept_id",
            "from job",
            "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "enabled", property = "enabled", jdbcType = JdbcType.BIT),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "sort", property = "sort", jdbcType = JdbcType.BIGINT),
            @Result(column = "dept_id", property = "deptId", jdbcType = JdbcType.BIGINT)
    })
    Job selectByPrimaryKey(Long id);

    @Select({
            "select",
            "id, name, enabled, create_time, sort, dept_id",
            "from job"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "enabled", property = "enabled", jdbcType = JdbcType.BIT),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "sort", property = "sort", jdbcType = JdbcType.BIGINT),
            @Result(column = "dept_id", property = "deptId", jdbcType = JdbcType.BIGINT),
            @Result(column = "dept_id", property = "dept", javaType = Dept.class, one = @One(select = "com.topsail.skeleton.system.mapper.DeptMapper.selectByPrimaryKey"))
    })
    List<Job> selectAll();

    @SelectProvider(type = JobSQLProvider.class, method="getSelectLikeName")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "enabled", property = "enabled", jdbcType = JdbcType.BIT),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "sort", property = "sort", jdbcType = JdbcType.BIGINT),
            @Result(column = "dept_id", property = "deptId", jdbcType = JdbcType.BIGINT)
    })
    List<Job> selectLikeName(@Param("content")String content, @Param("enabled") Boolean enabled);

    @Update({
            "update job",
            "set name = #{name,jdbcType=VARCHAR},",
            "enabled = #{enabled,jdbcType=BIT},",
            "sort = #{sort,jdbcType=BIGINT},",
            "dept_id = #{deptId,jdbcType=BIGINT}",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Job record);
}