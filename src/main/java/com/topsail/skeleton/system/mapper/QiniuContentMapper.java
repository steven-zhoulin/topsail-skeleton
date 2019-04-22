package com.topsail.skeleton.system.mapper;

import com.topsail.skeleton.system.domain.po.QiniuContent;
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
public interface QiniuContentMapper {
    @Delete({
        "delete from qiniu_content",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into qiniu_content (bucket, name, ",
        "size, type, update_time, ",
        "url)",
        "values (#{bucket,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{size,jdbcType=VARCHAR}, #{type,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{url,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(QiniuContent record);

    @Select({
        "select",
        "id, bucket, name, size, type, update_time, url",
        "from qiniu_content",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="bucket", property="bucket", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="size", property="size", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR)
    })
    QiniuContent selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, bucket, name, size, type, update_time, url",
        "from qiniu_content"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="bucket", property="bucket", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="size", property="size", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR)
    })
    List<QiniuContent> selectAll();

    @Update({
        "updateByPrimaryKey qiniu_content",
        "set bucket = #{bucket,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "size = #{size,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "url = #{url,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(QiniuContent record);
}