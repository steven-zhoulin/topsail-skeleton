package com.topsail.skeleton.system.mapper;

import com.topsail.skeleton.system.domain.po.EmailConfig;
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
public interface EmailConfigMapper {
    @Delete({
        "delete from email_config",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into email_config (from_user, host, ",
        "pass, port, user)",
        "values (#{fromUser,jdbcType=VARCHAR}, #{host,jdbcType=VARCHAR}, ",
        "#{pass,jdbcType=VARCHAR}, #{port,jdbcType=VARCHAR}, #{user,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(EmailConfig record);

    @Select({
        "select",
        "id, from_user, host, pass, port, user",
        "from email_config",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="from_user", property="fromUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="host", property="host", jdbcType=JdbcType.VARCHAR),
        @Result(column="pass", property="pass", jdbcType=JdbcType.VARCHAR),
        @Result(column="port", property="port", jdbcType=JdbcType.VARCHAR),
        @Result(column="user", property="user", jdbcType=JdbcType.VARCHAR)
    })
    EmailConfig selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, from_user, host, pass, port, user",
        "from email_config"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="from_user", property="fromUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="host", property="host", jdbcType=JdbcType.VARCHAR),
        @Result(column="pass", property="pass", jdbcType=JdbcType.VARCHAR),
        @Result(column="port", property="port", jdbcType=JdbcType.VARCHAR),
        @Result(column="user", property="user", jdbcType=JdbcType.VARCHAR)
    })
    List<EmailConfig> selectAll();

    @Update({
        "updateByPrimaryKey email_config",
        "set from_user = #{fromUser,jdbcType=VARCHAR},",
          "host = #{host,jdbcType=VARCHAR},",
          "pass = #{pass,jdbcType=VARCHAR},",
          "port = #{port,jdbcType=VARCHAR},",
          "user = #{user,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(EmailConfig record);
}