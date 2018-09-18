package org.best.alpha.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Configuration
@ComponentScan(basePackages = {"org.best.alpha"}, useDefaultFilters = false,
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
                value = {RestController.class, Controller.class, RestControllerAdvice.class, ControllerAdvice.class})})
public class RootConfig {

    @Bean
    public DozerBeanMapper dozerBeanMapper() {
        return new DozerBeanMapper();
    }

}
