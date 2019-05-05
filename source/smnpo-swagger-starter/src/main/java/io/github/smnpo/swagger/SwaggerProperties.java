package io.github.smnpo.gourd.api.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: Ming.Zhao
 * @create: 2019-05-05 16:08
 **/
@Data
@ConfigurationProperties(
        prefix = "spring.swagger"
)
public class SwaggerProperties {
    private String title;
    private String description;
    private String termsOfServiceUrl;
    private String contactName;
    private String contactUrl;
    private String contactEmail;
    private String license;
    private String licenseUrl;
    private String version;
    private Boolean enable;
    private String basePackage;
}
