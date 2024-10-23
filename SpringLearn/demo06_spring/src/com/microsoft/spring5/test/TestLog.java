package com.microsoft.spring5.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * 测试log4j2
 */
public class TestLog {
    private static final Logger logger = LogManager.getLogger(TestLog.class);
    @Test
    public void testLog() {
        System.out.println("fuck");
        logger.debug("This is a debug message.");
        logger.info("This is an info message.");
        logger.warn("This is a warning message.");
        logger.error("This is an error message.");

        logger.info("hello {}", "${java:vm}");
    }

}
