package com.dh.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan(basePackages = "com.dh.*.controller")
public class SwaggerConfig {

    @Bean
    public Docket categoryApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("category-api")
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.regex("(?!/error.*).*"))
                .paths(categoryPaths())
                .build()
                .enableUrlTemplating(true);
    }


    private Predicate<String> categoryPaths() {
        return or(regex("/*.*"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("微服务接口文档")
                .description("")
                .termsOfServiceUrl("http://springfox.io")
                .contact("国网区块链项目接口文档")
                .version("1.0")
                .build();
    }

    @Bean
    public UiConfiguration uiConfig() {
        return UiConfiguration.DEFAULT;
    }

}