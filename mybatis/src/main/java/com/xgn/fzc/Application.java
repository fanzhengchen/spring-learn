package com.xgn.fzc;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2018-07-05
 * Time: 8:18 PM
 *
 * @author: MarkFan
 * @since v1.0.0
 */
@ComponentScan("com.xgn.fzc")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
