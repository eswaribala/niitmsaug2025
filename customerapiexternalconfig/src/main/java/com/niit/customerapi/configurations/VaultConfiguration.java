package com.niit.customerapi.configurations;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties
public class VaultConfiguration {
    private String postgresusername;
    private String postgrespassword;
}
