package com.topsail.skeleton.system.mapper;

import com.topsail.skeleton.system.domain.QiniuConfig;
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
public interface QiniuConfigMapper {
    @Delete({
        "delete from qiniu_config",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into qiniu_config (bucket, host, ",
        "type, zone, access_key, ",
        "secret_key)",
        "values (#{bucket,jdbcType=VARCHAR}, #{host,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=VARCHAR}, #{zone,jdbcType=VARCHAR}, #{accessKey,jdbcType=LONGVARCHAR}, ",
        "#{secretKey,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(QiniuConfig record);

    @Select({
        "select",
        "id, bucket, host, type, zone, access_key, secret_key",
        "from qiniu_config",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="bucket", property="bucket", jdbcType=JdbcType.VARCHAR),
        @Result(column="host", property="host", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="zone", property="zone", jdbcType=JdbcType.VARCHAR),
        @Result(column="access_key", property="accessKey", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="secret_key", property="secretKey", jdbcType=JdbcType.LONGVARCHAR)
    })
    QiniuConfig selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, bucket, host, type, zone, access_key, secret_key",
        "from qiniu_config"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="bucket", property="bucket", jdbcType=JdbcType.VARCHAR),
        @Result(column="host", property="host", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="zone", property="zone", jdbcType=JdbcType.VARCHAR),
        @Result(column="access_key", property="accessKey", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="secret_key", property="secretKey", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<QiniuConfig> selectAll();

    @Update({
        "updateByPrimaryKey qiniu_config",
        "set bucket = #{bucket,jdbcType=VARCHAR},",
          "host = #{host,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR},",
          "zone = #{zone,jdbcType=VARCHAR},",
          "access_key = #{accessKey,jdbcType=LONGVARCHAR},",
          "secret_key = #{secretKey,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(QiniuConfig record);
}