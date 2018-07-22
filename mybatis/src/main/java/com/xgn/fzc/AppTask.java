package com.xgn.fzc;


import com.xgn.fzc.mapper.master.MasterUserMapper;
import com.xgn.fzc.mapper.slave.SlaveUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.nio.channels.SocketChannel;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2018-07-05
 * Time: 8:19 PM
 *
 * @author: MarkFan
 * @since v1.0.0
 */
@Slf4j
@Component
public class AppTask implements ApplicationRunner, ApplicationContextAware {


    @Override
    public void run(ApplicationArguments args) throws Exception {


    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        MasterUserMapper masterMapper =
                applicationContext.getBean(MasterUserMapper.class);
        SlaveUserMapper slaveMapper =
                applicationContext.getBean(SlaveUserMapper.class);
        log.info("{} {}", masterMapper, slaveMapper);
        MultipleDataSource.setDataSourceKey("masterDataSource");
        log.info("master {}", masterMapper.countAll());
        MultipleDataSource.setDataSourceKey("slaveDataSource");
        log.info("master {}", slaveMapper.countAll());
        SocketChannel socketChannel;

    }
}
