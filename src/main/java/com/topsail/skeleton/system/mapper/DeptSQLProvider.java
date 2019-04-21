package com.topsail.skeleton.system.mapper;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author Steven
 */
public class DeptSQLProvider {

    public String getSelectLikeName(@Param("content") String content, @Param("enabled") boolean enabled) {
        SQL sql = new SQL();
        sql.SELECT("id", "name", "pid", "create_time", "enabled");
        sql.FROM("dept");
        sql.WHERE("enabled = #{enabled}");
        if (StringUtils.isNotBlank(content)) {
            sql.AND().WHERE("name LIKE CONCAT('%',#{content},'%')");
        }

        return sql.toString();
    }
}
