package com.zp.pharmacysys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zp.pharmacysys.mapper")  // mapper 接口类扫描包配置
public class pharmacysysApplication {
	public static void main(String[] args) {
        SpringApplication.run(pharmacysysApplication.class, args);
    }
}
