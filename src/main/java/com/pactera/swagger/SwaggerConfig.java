package com.pactera.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author wjwei
 * swagger 配置
 */
@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackages = "com.pactera.api.controller")
public class SwaggerConfig extends WebMvcConfigurationSupport{



    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pactera.api.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new  ApiInfoBuilder()
                .title("swagger2")
                .description("测试swagger2在springmvc项目中的应用")
                .termsOfServiceUrl("http://localhost:8081/swagger-ui.html")
                .contact(new Contact("王建伟","http://blog.csdn.net/u014231523/article/details/54411026","gentlelions@163.com"))
                .version("v1.1.0")
                .build();
    }


}


