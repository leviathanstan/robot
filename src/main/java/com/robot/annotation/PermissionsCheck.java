package com.robot.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author asce
 * @date 2018/11/14
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface PermissionsCheck {
    String access() default "manager";
    enum access{MANAGER,ORGANIZER,USER}     //MANAGER:超级管理员，ORGANIZER:主办方
}
