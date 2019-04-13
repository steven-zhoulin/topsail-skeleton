package com.topsail.skeleton.system.mapper;

import com.topsail.skeleton.system.domain.QuartzJob;
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
public interface QuartzJobMapper {
    @Delete({
        "delete from quartz_job",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into quartz_job (bean_name, cron_expression, ",
        "is_pause, job_name, method_name, ",
        "params, remark, ",
        "update_time)",
        "values (#{beanName,jdbcType=VARCHAR}, #{cronExpression,jdbcType=VARCHAR}, ",
        "#{isPause,jdbcType=BIT}, #{jobName,jdbcType=VARCHAR}, #{methodName,jdbcType=VARCHAR}, ",
        "#{params,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(QuartzJob record);

    @Select({
        "select",
        "id, bean_name, cron_expression, is_pause, job_name, method_name, params, remark, ",
        "update_time",
        "from quartz_job",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="bean_name", property="beanName", jdbcType=JdbcType.VARCHAR),
        @Result(column="cron_expression", property="cronExpression", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_pause", property="isPause", jdbcType=JdbcType.BIT),
        @Result(column="job_name", property="jobName", jdbcType=JdbcType.VARCHAR),
        @Result(column="method_name", property="methodName", jdbcType=JdbcType.VARCHAR),
        @Result(column="params", property="params", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    QuartzJob selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, bean_name, cron_expression, is_pause, job_name, method_name, params, remark, ",
        "update_time",
        "from quartz_job"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="bean_name", property="beanName", jdbcType=JdbcType.VARCHAR),
        @Result(column="cron_expression", property="cronExpression", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_pause", property="isPause", jdbcType=JdbcType.BIT),
        @Result(column="job_name", property="jobName", jdbcType=JdbcType.VARCHAR),
        @Result(column="method_name", property="methodName", jdbcType=JdbcType.VARCHAR),
        @Result(column="params", property="params", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<QuartzJob> selectAll();

    @Update({
        "updateByPrimaryKey quartz_job",
        "set bean_name = #{beanName,jdbcType=VARCHAR},",
          "cron_expression = #{cronExpression,jdbcType=VARCHAR},",
          "is_pause = #{isPause,jdbcType=BIT},",
          "job_name = #{jobName,jdbcType=VARCHAR},",
          "method_name = #{methodName,jdbcType=VARCHAR},",
          "params = #{params,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(QuartzJob record);
}