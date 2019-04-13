package com.topsail.skeleton.system.mapper;

import com.topsail.skeleton.system.domain.DictDetail;
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
public interface DictDetailMapper {
    @Delete({
        "delete from dict_detail",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into dict_detail (label, value, ",
        "sort, dict_id)",
        "values (#{label,jdbcType=VARCHAR}, #{value,jdbcType=VARCHAR}, ",
        "#{sort,jdbcType=VARCHAR}, #{dictId,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(DictDetail record);

    @Select({
        "select",
        "id, label, value, sort, dict_id",
        "from dict_detail",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="label", property="label", jdbcType=JdbcType.VARCHAR),
        @Result(column="value", property="value", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.VARCHAR),
        @Result(column="dict_id", property="dictId", jdbcType=JdbcType.BIGINT)
    })
    DictDetail selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, label, value, sort, dict_id",
        "from dict_detail"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="label", property="label", jdbcType=JdbcType.VARCHAR),
        @Result(column="value", property="value", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.VARCHAR),
        @Result(column="dict_id", property="dictId", jdbcType=JdbcType.BIGINT)
    })
    List<DictDetail> selectAll();

    @Update({
        "updateByPrimaryKey dict_detail",
        "set label = #{label,jdbcType=VARCHAR},",
          "value = #{value,jdbcType=VARCHAR},",
          "sort = #{sort,jdbcType=VARCHAR},",
          "dict_id = #{dictId,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(DictDetail record);
}