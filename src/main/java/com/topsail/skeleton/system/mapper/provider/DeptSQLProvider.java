package com.topsail.skeleton.system.mapper.provider;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author Steven
 */
public class DeptSQLProvider {

    public String getSelectLikeName(@Param("content") String content, @Param("enabled") Boolean enabled) {
        return new SQL() {{
            SELECT("id", "name", "pid", "create_time", "enabled");
            FROM("dept");
            if (null != enabled) {
                WHERE("enabled = #{enabled}");
            }

            if (StringUtils.isNotBlank(content)) {
                WHERE("name LIKE CONCAT('%',#{content},'%')");
            }
        }}.toString();
    }
}
