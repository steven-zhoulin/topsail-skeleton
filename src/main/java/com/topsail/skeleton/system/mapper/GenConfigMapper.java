package com.topsail.skeleton.system.mapper;

import com.topsail.skeleton.system.domain.po.GenConfig;
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
public interface GenConfigMapper {
    @Delete({
        "delete from gen_config",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into gen_config (author, cover, ",
        "module_name, pack, ",
        "path, api_path)",
        "values (#{author,jdbcType=VARCHAR}, #{cover,jdbcType=BIT}, ",
        "#{moduleName,jdbcType=VARCHAR}, #{pack,jdbcType=VARCHAR}, ",
        "#{path,jdbcType=VARCHAR}, #{apiPath,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(GenConfig record);

    @Select({
        "select",
        "id, author, cover, module_name, pack, path, api_path",
        "from gen_config",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="author", property="author", jdbcType=JdbcType.VARCHAR),
        @Result(column="cover", property="cover", jdbcType=JdbcType.BIT),
        @Result(column="module_name", property="moduleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="pack", property="pack", jdbcType=JdbcType.VARCHAR),
        @Result(column="path", property="path", jdbcType=JdbcType.VARCHAR),
        @Result(column="api_path", property="apiPath", jdbcType=JdbcType.VARCHAR)
    })
    GenConfig selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, author, cover, module_name, pack, path, api_path",
        "from gen_config"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="author", property="author", jdbcType=JdbcType.VARCHAR),
        @Result(column="cover", property="cover", jdbcType=JdbcType.BIT),
        @Result(column="module_name", property="moduleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="pack", property="pack", jdbcType=JdbcType.VARCHAR),
        @Result(column="path", property="path", jdbcType=JdbcType.VARCHAR),
        @Result(column="api_path", property="apiPath", jdbcType=JdbcType.VARCHAR)
    })
    List<GenConfig> selectAll();

    @Update({
        "updateByPrimaryKey gen_config",
        "set author = #{author,jdbcType=VARCHAR},",
          "cover = #{cover,jdbcType=BIT},",
          "module_name = #{moduleName,jdbcType=VARCHAR},",
          "pack = #{pack,jdbcType=VARCHAR},",
          "path = #{path,jdbcType=VARCHAR},",
          "api_path = #{apiPath,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(GenConfig record);
}