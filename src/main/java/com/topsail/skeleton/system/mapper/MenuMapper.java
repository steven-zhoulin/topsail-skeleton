package com.topsail.skeleton.system.mapper;

import com.topsail.skeleton.system.domain.Menu;
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
public interface MenuMapper {
    @Delete({
        "delete from menu",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into menu (create_time, i_frame, ",
        "name, component, ",
        "pid, sort, icon, ",
        "path)",
        "values (#{createTime,jdbcType=TIMESTAMP}, #{iFrame,jdbcType=BIT}, ",
        "#{name,jdbcType=VARCHAR}, #{component,jdbcType=VARCHAR}, ",
        "#{pid,jdbcType=BIGINT}, #{sort,jdbcType=BIGINT}, #{icon,jdbcType=VARCHAR}, ",
        "#{path,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Menu record);

    @Select({
        "select",
        "id, create_time, i_frame, name, component, pid, sort, icon, path",
        "from menu",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="i_frame", property="iFrame", jdbcType=JdbcType.BIT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="component", property="component", jdbcType=JdbcType.VARCHAR),
        @Result(column="pid", property="pid", jdbcType=JdbcType.BIGINT),
        @Result(column="sort", property="sort", jdbcType=JdbcType.BIGINT),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="path", property="path", jdbcType=JdbcType.VARCHAR)
    })
    Menu selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, create_time, i_frame, name, component, pid, sort, icon, path",
        "from menu"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="i_frame", property="iFrame", jdbcType=JdbcType.BIT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="component", property="component", jdbcType=JdbcType.VARCHAR),
        @Result(column="pid", property="pid", jdbcType=JdbcType.BIGINT),
        @Result(column="sort", property="sort", jdbcType=JdbcType.BIGINT),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="path", property="path", jdbcType=JdbcType.VARCHAR)
    })
    List<Menu> selectAll();

    @Update({
        "updateByPrimaryKey menu",
        "set create_time = #{createTime,jdbcType=TIMESTAMP},",
          "i_frame = #{iFrame,jdbcType=BIT},",
          "name = #{name,jdbcType=VARCHAR},",
          "component = #{component,jdbcType=VARCHAR},",
          "pid = #{pid,jdbcType=BIGINT},",
          "sort = #{sort,jdbcType=BIGINT},",
          "icon = #{icon,jdbcType=VARCHAR},",
          "path = #{path,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Menu record);
}