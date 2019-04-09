package com.zp.pharmacysys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.zp.pharmacysys.mapper")  // mapper 接口类扫描包配置
@EnableCaching  //开启springboot对缓存的支持
public class pharmacysysApplication {
	public static void main(String[] args) {
        SpringApplication.run(pharmacysysApplication.class, args);
    }
	
	@Bean 
	public EmbeddedServletContainerCustomizer containerCustomizer(){ 
	       return new EmbeddedServletContainerCustomizer() { 
	@Override 
	 public void customize(ConfigurableEmbeddedServletContainer container) { 
	       container.setSessionTimeout(7200);//单位为S 
	            } 
	       }; 
	   } 
}
