package com.robot.annotation;

import com.robot.enums.Permission;
import com.robot.enums.Role;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
        import java.lang.annotation.Target;

/**
 * Created by Ning on 2019/5/9
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Authority {
    Permission permission() default Permission.NORMAL;
    Role role() default Role.NORMAL;
}
