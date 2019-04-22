package com.topsail.skeleton.system.mapper;

import com.topsail.skeleton.system.domain.po.VerificationCode;
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
public interface VerificationCodeMapper {
    @Delete({
        "delete from verification_code",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into verification_code (code, create_time, ",
        "status, type, value, ",
        "scenes)",
        "values (#{code,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=BIT}, #{type,jdbcType=VARCHAR}, #{value,jdbcType=VARCHAR}, ",
        "#{scenes,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(VerificationCode record);

    @Select({
        "select",
        "id, code, create_time, status, type, value, scenes",
        "from verification_code",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="value", property="value", jdbcType=JdbcType.VARCHAR),
        @Result(column="scenes", property="scenes", jdbcType=JdbcType.VARCHAR)
    })
    VerificationCode selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, code, create_time, status, type, value, scenes",
        "from verification_code"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="value", property="value", jdbcType=JdbcType.VARCHAR),
        @Result(column="scenes", property="scenes", jdbcType=JdbcType.VARCHAR)
    })
    List<VerificationCode> selectAll();

    @Update({
        "updateByPrimaryKey verification_code",
        "set code = #{code,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=BIT},",
          "type = #{type,jdbcType=VARCHAR},",
          "value = #{value,jdbcType=VARCHAR},",
          "scenes = #{scenes,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(VerificationCode record);
}