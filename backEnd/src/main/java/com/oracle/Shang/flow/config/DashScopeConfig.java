package com.oracle.Shang.flow.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "dashscope")
public class DashScopeConfig {

    /**
     * application-local.yml中的api-key
     */
    private String apiKey;

    /**
     * application.yml中的model
     */
    private String model;

}