package com.wxh.email2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Auther: WXH
 * @Date: 2022/9/21 - 09 - 21 - 12:29
 */
@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(info())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wxh.email2.controller"))
                .build();

}
   private ApiInfo info(){
       return new ApiInfoBuilder()
               .contact(new Contact("王鑫豪", "https://www.bilibili.com", "2776318846@qq.com"))
               .title("图书管理系统 - 在线API接口文档")
               .description("欢迎前端人员来使用")
               .build();
   }
}
