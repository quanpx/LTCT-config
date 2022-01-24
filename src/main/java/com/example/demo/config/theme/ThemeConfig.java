package com.example.demo.config.theme;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties("md-config-theme")
public class ThemeConfig {

    private String theme;

    private String language;
    
    private Integer fontSize;
}
