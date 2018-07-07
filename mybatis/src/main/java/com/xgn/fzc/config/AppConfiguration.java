package com.xgn.fzc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2018-07-07
 * Time: 6:46 PM
 *
 * @author: MarkFan
 * @since v1.0.0
 */
@Configuration
public class AppConfiguration {

    @Bean(name = "masterDataSource")
    @ConfigurationProperties(prefix = "datasource.master")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "slaveDataSource")
    @ConfigurationProperties(prefix = "datasource.slave")
    public DataSource slaveDataSource() {
        return DataSourceBuilder.create().build();
    }

}
