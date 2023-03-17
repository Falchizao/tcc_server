package io.scarletgraph.api;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "email.from")
public class ConfigProvider {

    private String address;
    private String password;
    private String protocol;
    private Integer port;
}
