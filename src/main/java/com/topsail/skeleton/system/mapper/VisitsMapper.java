package com.topsail.skeleton.system.mapper;

import com.topsail.skeleton.system.domain.po.Visits;
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
public interface VisitsMapper {
    @Delete({
        "delete from visits",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into visits (create_time, date, ",
        "ip_counts, pv_counts, ",
        "week_day)",
        "values (#{createTime,jdbcType=TIMESTAMP}, #{date,jdbcType=VARCHAR}, ",
        "#{ipCounts,jdbcType=BIGINT}, #{pvCounts,jdbcType=BIGINT}, ",
        "#{weekDay,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Visits record);

    @Select({
        "select",
        "id, create_time, date, ip_counts, pv_counts, week_day",
        "from visits",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="date", property="date", jdbcType=JdbcType.VARCHAR),
        @Result(column="ip_counts", property="ipCounts", jdbcType=JdbcType.BIGINT),
        @Result(column="pv_counts", property="pvCounts", jdbcType=JdbcType.BIGINT),
        @Result(column="week_day", property="weekDay", jdbcType=JdbcType.VARCHAR)
    })
    Visits selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, create_time, date, ip_counts, pv_counts, week_day",
        "from visits"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="date", property="date", jdbcType=JdbcType.VARCHAR),
        @Result(column="ip_counts", property="ipCounts", jdbcType=JdbcType.BIGINT),
        @Result(column="pv_counts", property="pvCounts", jdbcType=JdbcType.BIGINT),
        @Result(column="week_day", property="weekDay", jdbcType=JdbcType.VARCHAR)
    })
    List<Visits> selectAll();

    @Update({
        "updateByPrimaryKey visits",
        "set create_time = #{createTime,jdbcType=TIMESTAMP},",
          "date = #{date,jdbcType=VARCHAR},",
          "ip_counts = #{ipCounts,jdbcType=BIGINT},",
          "pv_counts = #{pvCounts,jdbcType=BIGINT},",
          "week_day = #{weekDay,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Visits record);
}