package com.topsail.skeleton.system.mapper.provider;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author Steven
 */
public class JobSQLProvider {

    public String getSelectLikeName(@Param("content") String content, @Param("enabled") Boolean enabled) {
        return new SQL() {{
            SELECT("id", "name", "enabled", "create_time", "sort", "dept_id");
            FROM("job");
            if (null != enabled) {
                WHERE("enabled = #{enabled}");
            }
            if (null != content) {
                WHERE("name LIKE CONCAT('%',#{content},'%')");
            }
        }}.toString();
    }
}
