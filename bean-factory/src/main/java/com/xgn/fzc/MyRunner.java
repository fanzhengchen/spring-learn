package com.xgn.fzc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2018-07-22
 * Time: 4:36 PM
 *
 * @author: MarkFan
 * @since v1.0.0
 */
@Slf4j
@Component
public class MyRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("MyRunner Info");
        log.debug("MyRunner debug");
        log.error("MyRunner error");
        log.warn("MyRunner warn");
        log.trace("MyRunner trace");
    }
}
