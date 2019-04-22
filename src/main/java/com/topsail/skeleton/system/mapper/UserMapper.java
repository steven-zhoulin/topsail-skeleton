package com.topsail.skeleton.system.mapper;

import com.topsail.skeleton.system.domain.po.User;
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
//@Repository
public interface UserMapper {
    @Delete({
        "delete from user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into user (avatar, create_time, ",
        "email, enabled, password, ",
        "username, last_password_reset_time, ",
        "dept_id, phone, job_id)",
        "values (#{avatar,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{email,jdbcType=VARCHAR}, #{enabled,jdbcType=BIGINT}, #{password,jdbcType=VARCHAR}, ",
        "#{username,jdbcType=VARCHAR}, #{lastPasswordResetTime,jdbcType=TIMESTAMP}, ",
        "#{deptId,jdbcType=BIGINT}, #{phone,jdbcType=VARCHAR}, #{jobId,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(User record);

    @Select({
        "select",
        "id, avatar, create_time, email, enabled, password, username, last_password_reset_time, ",
        "dept_id, phone, job_id",
        "from user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="enabled", property="enabled", jdbcType=JdbcType.BIGINT),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_password_reset_time", property="lastPasswordResetTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="dept_id", property="deptId", jdbcType=JdbcType.BIGINT),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="job_id", property="jobId", jdbcType=JdbcType.BIGINT)
    })
    User selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, avatar, create_time, email, enabled, password, username, last_password_reset_time, ",
        "dept_id, phone, job_id",
        "from user"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="enabled", property="enabled", jdbcType=JdbcType.BIGINT),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_password_reset_time", property="lastPasswordResetTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="dept_id", property="deptId", jdbcType=JdbcType.BIGINT),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="job_id", property="jobId", jdbcType=JdbcType.BIGINT)
    })
    List<User> selectAll();

    @Update({
        "updateByPrimaryKey user",
        "set avatar = #{avatar,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "email = #{email,jdbcType=VARCHAR},",
          "enabled = #{enabled,jdbcType=BIGINT},",
          "password = #{password,jdbcType=VARCHAR},",
          "username = #{username,jdbcType=VARCHAR},",
          "last_password_reset_time = #{lastPasswordResetTime,jdbcType=TIMESTAMP},",
          "dept_id = #{deptId,jdbcType=BIGINT},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "job_id = #{jobId,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(User record);
}