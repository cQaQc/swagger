package com.kk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration //表明该类是一个配置类
@EnableSwagger2 //开启swagger2
public class SwaggerConfig {


    @Bean
    public Docket docket(Environment environment){

        //我们有这样一个需求：希望Swagger在开发环境中，在正式环境时不能使用
        Profiles profiles = Profiles.of("dev");
        boolean flag = environment.acceptsProfiles(profiles);
        System.out.println(flag);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("柯柯")
                .enable(flag) //关闭swagger
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kk.controller")) //指定扫描的包
                // .paths(PathSelectors.ant("/kk/**")) //不扫描该路径
                .build();
    }

    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("AAA");
    }

    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("BBB");
    }

    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("CCC");
    }

    public ApiInfo apiInfo(){
        return new ApiInfo(
                "柯柯的大爹",
                "很多小可爱",
                "v1.1",
                "https://www.cnblogs.com/qqkkOvO/",
                new Contact("大王叫我来巡山", "https://www.cnblogs.com/qqkkOvO/", "446783737@qq.com"),
                "Apache2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
    }

}
