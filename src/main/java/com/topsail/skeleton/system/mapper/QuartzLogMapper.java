package com.topsail.skeleton.system.mapper;

import com.topsail.skeleton.system.domain.QuartzLog;
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
public interface QuartzLogMapper {
    @Delete({
        "delete from quartz_log",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into quartz_log (baen_name, create_time, ",
        "cron_expression, is_success, ",
        "job_name, method_name, ",
        "params, time, exception_detail)",
        "values (#{baenName,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{cronExpression,jdbcType=VARCHAR}, #{isSuccess,jdbcType=BIT}, ",
        "#{jobName,jdbcType=VARCHAR}, #{methodName,jdbcType=VARCHAR}, ",
        "#{params,jdbcType=VARCHAR}, #{time,jdbcType=BIGINT}, #{exceptionDetail,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(QuartzLog record);

    @Select({
        "select",
        "id, baen_name, create_time, cron_expression, is_success, job_name, method_name, ",
        "params, time, exception_detail",
        "from quartz_log",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="baen_name", property="baenName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="cron_expression", property="cronExpression", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_success", property="isSuccess", jdbcType=JdbcType.BIT),
        @Result(column="job_name", property="jobName", jdbcType=JdbcType.VARCHAR),
        @Result(column="method_name", property="methodName", jdbcType=JdbcType.VARCHAR),
        @Result(column="params", property="params", jdbcType=JdbcType.VARCHAR),
        @Result(column="time", property="time", jdbcType=JdbcType.BIGINT),
        @Result(column="exception_detail", property="exceptionDetail", jdbcType=JdbcType.LONGVARCHAR)
    })
    QuartzLog selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, baen_name, create_time, cron_expression, is_success, job_name, method_name, ",
        "params, time, exception_detail",
        "from quartz_log"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="baen_name", property="baenName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="cron_expression", property="cronExpression", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_success", property="isSuccess", jdbcType=JdbcType.BIT),
        @Result(column="job_name", property="jobName", jdbcType=JdbcType.VARCHAR),
        @Result(column="method_name", property="methodName", jdbcType=JdbcType.VARCHAR),
        @Result(column="params", property="params", jdbcType=JdbcType.VARCHAR),
        @Result(column="time", property="time", jdbcType=JdbcType.BIGINT),
        @Result(column="exception_detail", property="exceptionDetail", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<QuartzLog> selectAll();

    @Update({
        "updateByPrimaryKey quartz_log",
        "set baen_name = #{baenName,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "cron_expression = #{cronExpression,jdbcType=VARCHAR},",
          "is_success = #{isSuccess,jdbcType=BIT},",
          "job_name = #{jobName,jdbcType=VARCHAR},",
          "method_name = #{methodName,jdbcType=VARCHAR},",
          "params = #{params,jdbcType=VARCHAR},",
          "time = #{time,jdbcType=BIGINT},",
          "exception_detail = #{exceptionDetail,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(QuartzLog record);
}