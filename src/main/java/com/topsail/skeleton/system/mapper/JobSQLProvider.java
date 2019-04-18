package com.topsail.skeleton.system.mapper;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author Steven
 */
public class JobSQLProvider {

    public String getSelectLikeName(@Param("content") String content, @Param("enabled") boolean enabled) {
        SQL sql = new SQL();
        sql.SELECT("id", "name", "enabled", "create_time", "sort", "dept_id");
        sql.FROM("job");
        sql.WHERE("enabled = #{enabled}");
        if (StringUtils.isNotBlank(content)) {
            sql.WHERE("name LIKE CONCAT('%',#{content},'%')");
        }

        return sql.toString();
    }
}
