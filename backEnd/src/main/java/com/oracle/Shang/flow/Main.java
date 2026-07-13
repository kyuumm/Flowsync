package com.oracle.Shang.flow;

import com.oracle.Shang.flow.entiy.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.ArrayList;

import java.util.List;
import java.util.ArrayList;
/**
 * 类：Main
 * 描述：TODO
 *
 * @author Shang
 * @version 1.0
 * @date 2026-07-10 10:32:23
 */
@SpringBootApplication
@MapperScan(basePackages = "com.oracle.Shang.flow.mapper")
//标记当前项目
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SpringApplication.run(Main.class,args);
    }
}