package com.nttdata.springboot.product.configuration;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "cache")
public class CacheProperties {
    private String port;
    private int size;

}
