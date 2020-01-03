package com.edu.global.config;

import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                // .pathMapping("/")// base，最终调用接口后会和paths拼接在一起
                .select()
                // .paths(Predicates.or(PathSelectors.regex("/api/.*")))//过滤的接口
//                .apis(RequestHandlerSelectors.basePackage("com.edu.dmsjportal.swagger")) //过滤的接口
                .paths(PathSelectors.any())
                .build()
                //忽略某些参数,不需要swagger描述
                .ignoredParameterTypes(HttpSession.class, HttpServletRequest.class, HttpServletResponse.class, BindResult.class);
    }

    private ApiInfo getApiInfo() {
        // 定义联系人信息
        Contact contact = new Contact("白幽幽","", "2023763532@qq.com");
        return new ApiInfoBuilder()
                .title("演示 Swagger 的用法") // 标题
                .description("演示Swagger中各种注解的用法") // 描述信息
                .version("1.0.SNAPSHOT") // //版本
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .contact(contact)
                .build();
    }

}

