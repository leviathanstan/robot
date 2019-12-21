package com.robot.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogHelper {

    public static final Logger scheduleTaskLog = LogManager.getLogger("scheduleTask");
    public static final Logger accessLog = LogManager.getLogger("access");
    public static final Logger errorLog = LogManager.getLogger("error");
}
