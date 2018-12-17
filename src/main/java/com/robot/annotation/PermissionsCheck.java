package com.robot.annotation;

import com.robot.enums.PermissionsModel;

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
    PermissionsModel access() default PermissionsModel.MANAGER;
}
