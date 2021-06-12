package com.smart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 专门且仅仅测试logback的功能
 */
public class Parent {
    private static Logger logger = LoggerFactory.getLogger(Parent.class);

    public static void printLog() {
        logger.debug("execute Parent.printlog()");
    }

}
