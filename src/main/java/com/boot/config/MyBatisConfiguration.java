package com.boot.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;  
import org.springframework.context.annotation.Bean;  
import org.springframework.context.annotation.Configuration;  
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;  
  
@Configuration  
@ConfigurationProperties(prefix = "spring.datasource")  
public class MyBatisConfiguration {  
      
    private String url;  
    private String driverClassName;  
    private String username;  
    private String password;  
  
  
    public String getUrl() {  
        return url;  
    }  
  
    public void setUrl(String url) {  
        this.url = url;  
    }  
  
    public String getDriverClassName() {  
        return driverClassName;  
    }  
  
    public void setDriverClassName(String driverClassName) {  
        this.driverClassName = driverClassName;  
    }  
  
    public String getUsername() {  
        return username;  
    }  
  
    public void setUsername(String username) {  
        this.username = username;  
    }  
  
    public String getPassword() {  
        return password;  
    }  
  
    public void setPassword(String password) {  
        this.password = password;  
    }  
      
    @Bean(name = "dataSource")  
    public DriverManagerDataSource dataSource(){  
         DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();  
         driverManagerDataSource.setDriverClassName(driverClassName);  
         driverManagerDataSource.setUrl(url);  
         driverManagerDataSource.setUsername(username);  
         driverManagerDataSource.setPassword(password);  
         return driverManagerDataSource;  
    }  
    
  @Bean(name="sqlSessionFactory")
    public SqlSessionFactory  sqlSessionFactoryBean() throws Exception{
    	/* Resource[]resources = new Resource[] { 
    			 getMapperXMLPathResource(UserMapper.class)  	   
         };  */
    	SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
    	sqlSessionFactoryBean.setDataSource(dataSource());
    	 PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
 		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:com/boot/maps/*Mapper.xml"));
    	return sqlSessionFactoryBean.getObject();
    }
  

/*    public static Resource getMapperXMLPathResource(Class<?> clazz) {  
        return new ClassPathResource(clazz.getName()  
                     .replace(".", File.separator).concat(".xml"));  
 }  */
}  
