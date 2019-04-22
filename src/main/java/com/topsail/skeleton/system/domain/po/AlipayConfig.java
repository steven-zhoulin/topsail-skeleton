package com.topsail.skeleton.system.domain.po;

import java.io.Serializable;
import lombok.Data;

@Data
public class AlipayConfig implements Serializable {
    private Long id;

    private String appId;

    private String charset;

    private String format;

    private String gatewayUrl;

    private String notifyUrl;

    private String returnUrl;

    private String signType;

    private String sysServiceProviderId;

    private String privateKey;

    private String publicKey;

    private static final long serialVersionUID = 1L;
}