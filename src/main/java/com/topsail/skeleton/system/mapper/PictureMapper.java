package com.topsail.skeleton.system.mapper;

import com.topsail.skeleton.system.domain.po.Picture;
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
public interface PictureMapper {
    @Delete({
        "delete from picture",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into picture (create_time, delete_url, ",
        "filename, height, ",
        "size, url, username, ",
        "width)",
        "values (#{createTime,jdbcType=TIMESTAMP}, #{deleteUrl,jdbcType=VARCHAR}, ",
        "#{filename,jdbcType=VARCHAR}, #{height,jdbcType=VARCHAR}, ",
        "#{size,jdbcType=VARCHAR}, #{url,jdbcType=VARCHAR}, #{username,jdbcType=VARCHAR}, ",
        "#{width,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Picture record);

    @Select({
        "select",
        "id, create_time, delete_url, filename, height, size, url, username, width",
        "from picture",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="delete_url", property="deleteUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="filename", property="filename", jdbcType=JdbcType.VARCHAR),
        @Result(column="height", property="height", jdbcType=JdbcType.VARCHAR),
        @Result(column="size", property="size", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="width", property="width", jdbcType=JdbcType.VARCHAR)
    })
    Picture selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, create_time, delete_url, filename, height, size, url, username, width",
        "from picture"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="delete_url", property="deleteUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="filename", property="filename", jdbcType=JdbcType.VARCHAR),
        @Result(column="height", property="height", jdbcType=JdbcType.VARCHAR),
        @Result(column="size", property="size", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="width", property="width", jdbcType=JdbcType.VARCHAR)
    })
    List<Picture> selectAll();

    @Update({
        "updateByPrimaryKey picture",
        "set create_time = #{createTime,jdbcType=TIMESTAMP},",
          "delete_url = #{deleteUrl,jdbcType=VARCHAR},",
          "filename = #{filename,jdbcType=VARCHAR},",
          "height = #{height,jdbcType=VARCHAR},",
          "size = #{size,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR},",
          "username = #{username,jdbcType=VARCHAR},",
          "width = #{width,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Picture record);
}