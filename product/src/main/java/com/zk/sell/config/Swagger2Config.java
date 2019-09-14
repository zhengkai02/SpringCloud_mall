package com.zk.sell.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhengKai
 * @data 2019-09-09 12:55
 */
@Deprecated
@EnableSwagger2
@Configuration
public class Swagger2Config {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zk.sell.controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContextList());
    }

    private ApiInfo apiInfo(){
        Contact contact=new Contact("zk","http://localhost:10001","xju_zk@163.com");
        return new ApiInfoBuilder()
                .title("后台系统")
                .description("后台管理模块")
                .contact(contact)
                .version("V1")
                .build();
    }

    private List<ApiKey> securitySchemes(){
        // 设置请求头信息
        List<ApiKey> apiKeyList=new ArrayList<ApiKey>();
        ApiKey apiKey=new ApiKey("Aythotization","Authorization","header");
        apiKeyList.add(apiKey);
        return apiKeyList;
    }

    private List<SecurityContext> securityContextList(){
        // 设置需要登录认证的路径
        List<SecurityContext> result=new ArrayList<>();
        result.add(getContextByPath("/bra"));
        result.add(getContextByPath("/bra"));
        return result;
    }

    private SecurityContext getContextByPath(String pathRegex){
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex(pathRegex))
                .build();

    }

    private List<SecurityReference> defaultAuth(){
        List<SecurityReference> securityReferences=new ArrayList<>();
        AuthorizationScope authorizationScope=new AuthorizationScope("global","accessEverything");
        AuthorizationScope[] authorizationScopes=new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        securityReferences.add(new SecurityReference("Authrization",authorizationScopes));
        return securityReferences;
    }
}
