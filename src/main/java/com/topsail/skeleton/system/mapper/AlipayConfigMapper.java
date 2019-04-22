package com.topsail.skeleton.system.mapper;

import com.topsail.skeleton.system.domain.po.AlipayConfig;
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
public interface AlipayConfigMapper {
    @Delete({
        "delete from alipay_config",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into alipay_config (app_id, charset, ",
        "format, gateway_url, ",
        "notify_url, return_url, ",
        "sign_type, sys_service_provider_id, ",
        "private_key, public_key)",
        "values (#{appId,jdbcType=VARCHAR}, #{charset,jdbcType=VARCHAR}, ",
        "#{format,jdbcType=VARCHAR}, #{gatewayUrl,jdbcType=VARCHAR}, ",
        "#{notifyUrl,jdbcType=VARCHAR}, #{returnUrl,jdbcType=VARCHAR}, ",
        "#{signType,jdbcType=VARCHAR}, #{sysServiceProviderId,jdbcType=VARCHAR}, ",
        "#{privateKey,jdbcType=LONGVARCHAR}, #{publicKey,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(AlipayConfig record);

    @Select({
        "select",
        "id, app_id, charset, format, gateway_url, notify_url, return_url, sign_type, ",
        "sys_service_provider_id, private_key, public_key",
        "from alipay_config",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.VARCHAR),
        @Result(column="charset", property="charset", jdbcType=JdbcType.VARCHAR),
        @Result(column="format", property="format", jdbcType=JdbcType.VARCHAR),
        @Result(column="gateway_url", property="gatewayUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="notify_url", property="notifyUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="return_url", property="returnUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="sign_type", property="signType", jdbcType=JdbcType.VARCHAR),
        @Result(column="sys_service_provider_id", property="sysServiceProviderId", jdbcType=JdbcType.VARCHAR),
        @Result(column="private_key", property="privateKey", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="public_key", property="publicKey", jdbcType=JdbcType.LONGVARCHAR)
    })
    AlipayConfig selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, app_id, charset, format, gateway_url, notify_url, return_url, sign_type, ",
        "sys_service_provider_id, private_key, public_key",
        "from alipay_config"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.VARCHAR),
        @Result(column="charset", property="charset", jdbcType=JdbcType.VARCHAR),
        @Result(column="format", property="format", jdbcType=JdbcType.VARCHAR),
        @Result(column="gateway_url", property="gatewayUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="notify_url", property="notifyUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="return_url", property="returnUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="sign_type", property="signType", jdbcType=JdbcType.VARCHAR),
        @Result(column="sys_service_provider_id", property="sysServiceProviderId", jdbcType=JdbcType.VARCHAR),
        @Result(column="private_key", property="privateKey", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="public_key", property="publicKey", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<AlipayConfig> selectAll();

    @Update({
        "updateByPrimaryKey alipay_config",
        "set app_id = #{appId,jdbcType=VARCHAR},",
          "charset = #{charset,jdbcType=VARCHAR},",
          "format = #{format,jdbcType=VARCHAR},",
          "gateway_url = #{gatewayUrl,jdbcType=VARCHAR},",
          "notify_url = #{notifyUrl,jdbcType=VARCHAR},",
          "return_url = #{returnUrl,jdbcType=VARCHAR},",
          "sign_type = #{signType,jdbcType=VARCHAR},",
          "sys_service_provider_id = #{sysServiceProviderId,jdbcType=VARCHAR},",
          "private_key = #{privateKey,jdbcType=LONGVARCHAR},",
          "public_key = #{publicKey,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(AlipayConfig record);
}