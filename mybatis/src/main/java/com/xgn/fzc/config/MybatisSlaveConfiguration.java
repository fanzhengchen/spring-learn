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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2018-07-07
 * Time: 7:02 PM
 *
 * @author: MarkFan
 * @since v1.0.0
 */
@Configuration
@MapperScan(value = "com.xgn.fzc.mapper.slave", sqlSessionFactoryRef = "slaveSqlSessionFactory")
public class MybatisSlaveConfiguration {

    @Autowired
    @Qualifier("slaveDataSource")
    DataSource slaveDataSource;

    @Primary
    @Bean(name = "slaveSqlSessionFactory")
    public SqlSessionFactory slaveSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(slaveDataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:mybatis-mapper/*.xml"));
        return sessionFactoryBean.getObject();

    }

    @Bean
    public SqlSessionTemplate slaveSqlSessionTemplate() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(slaveSqlSessionFactory());
        return template;
    }

}
