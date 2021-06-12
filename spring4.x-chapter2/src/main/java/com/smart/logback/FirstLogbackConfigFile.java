package com.smart.logback;

import com.smart.Parent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstLogbackConfigFile {
    private static Logger logger = LoggerFactory.getLogger(FirstLogbackConfigFile.class);

    public static void main(String[] args){
        firstLog();
    }

    public static void firstLog() {
        Parent.printLog();
        logger.debug("execute com.smart.logback.firstlog()");
    }

}
