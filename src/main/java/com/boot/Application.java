package com.boot;



import javax.servlet.MultipartConfigElement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;



@SpringBootApplication  //该注解等价于默认使用@Configuration,@EnableAutoConfiguration,@ComponentScan
@EnableAutoConfiguration
@MapperScan("com.boot.mapper")
public class Application {
   public static void main(String[] args) {
	   SpringApplication.run(Application.class,args);
   }  


@Bean
public MultipartConfigElement multipartConfigElement() { 
    MultipartConfigFactory factory = new MultipartConfigFactory();
    //// 设置文件大小限制 ,超了，页面会抛出异常信息，这时候就需要进行异常信息的处理了;
  //KB,MB
    /// 设置总上传数据总大小

    //Sets the directory location where files will be stored.
    //factory.setLocation("路径地址");
    return factory.createMultipartConfig(); 
  }
}
