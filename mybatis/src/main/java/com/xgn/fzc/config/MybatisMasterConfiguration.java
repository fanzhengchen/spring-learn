package com.xgn.fzc.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2018-07-07
 * Time: 6:56 PM
 *
 * @author: MarkFan
 * @since v1.0.0
 */
@Configuration
@MapperScan(value = "com.xgn.fzc.mapper.master", sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MybatisMasterConfiguration {



    @Autowired
    @Qualifier("masterDataSource")
    DataSource masterDataSource;



    @Bean(name = "masterSqlSessionFactory")
    public SqlSessionFactory masterSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(masterDataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:mybatis-mapper/*.xml"));
        return sessionFactoryBean.getObject();

    }

    @Bean
    public SqlSessionTemplate masterSqlSessionTemplate() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(masterSqlSessionFactory());
        return template;
    }
}
