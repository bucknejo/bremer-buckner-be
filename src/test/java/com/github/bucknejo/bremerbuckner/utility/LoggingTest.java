package com.github.bucknejo.bremerbuckner.utility;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggingTest {

    private final static Logger LOG = LoggerFactory.getLogger(LoggingTest.class);

    @Test
    public void confirmLogBack() {
        LOG.trace("Start trace");
        LOG.debug("Start debug");
        LOG.info("Start info");
        LOG.warn("Start warn");
        LOG.error("Start error");
    }

}
