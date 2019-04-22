package com.topsail.skeleton.system.mapper;

import com.topsail.skeleton.system.domain.po.Log;
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
public interface LogMapper {
    @Delete({
        "delete from log",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into log (create_time, description, ",
        "log_type, method, ",
        "request_ip, time, ",
        "username, exception_detail, ",
        "params)",
        "values (#{createTime,jdbcType=TIMESTAMP}, #{description,jdbcType=VARCHAR}, ",
        "#{logType,jdbcType=VARCHAR}, #{method,jdbcType=VARCHAR}, ",
        "#{requestIp,jdbcType=VARCHAR}, #{time,jdbcType=BIGINT}, ",
        "#{username,jdbcType=VARCHAR}, #{exceptionDetail,jdbcType=LONGVARCHAR}, ",
        "#{params,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Log record);

    @Select({
        "select",
        "id, create_time, description, log_type, method, request_ip, time, username, ",
        "exception_detail, params",
        "from log",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="log_type", property="logType", jdbcType=JdbcType.VARCHAR),
        @Result(column="method", property="method", jdbcType=JdbcType.VARCHAR),
        @Result(column="request_ip", property="requestIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="time", property="time", jdbcType=JdbcType.BIGINT),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="exception_detail", property="exceptionDetail", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="params", property="params", jdbcType=JdbcType.LONGVARCHAR)
    })
    Log selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, create_time, description, log_type, method, request_ip, time, username, ",
        "exception_detail, params",
        "from log"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="log_type", property="logType", jdbcType=JdbcType.VARCHAR),
        @Result(column="method", property="method", jdbcType=JdbcType.VARCHAR),
        @Result(column="request_ip", property="requestIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="time", property="time", jdbcType=JdbcType.BIGINT),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="exception_detail", property="exceptionDetail", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="params", property="params", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Log> selectAll();

    @Update({
        "updateByPrimaryKey log",
        "set create_time = #{createTime,jdbcType=TIMESTAMP},",
          "description = #{description,jdbcType=VARCHAR},",
          "log_type = #{logType,jdbcType=VARCHAR},",
          "method = #{method,jdbcType=VARCHAR},",
          "request_ip = #{requestIp,jdbcType=VARCHAR},",
          "time = #{time,jdbcType=BIGINT},",
          "username = #{username,jdbcType=VARCHAR},",
          "exception_detail = #{exceptionDetail,jdbcType=LONGVARCHAR},",
          "params = #{params,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Log record);
}