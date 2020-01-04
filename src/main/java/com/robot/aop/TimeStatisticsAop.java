package com.robot.aop;

import com.robot.util.AccessUtil;
import com.robot.util.GsonUtil;
import com.robot.util.LogHelper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author asce
 * @date 2019/12/21
 */
@Order(1)
@Aspect
@Component
public class TimeStatisticsAop {

    TimeStatisticsAop() {

    }

//    @Pointcut("execution (* com.robot.service.*.*(..)) || execution (* com.robot.controller.*.*(..))")//切面范围
    @Pointcut("execution (* com.robot.controller.*.*(..))")//切面范围
    public void access(){

    }

    @Before("access()")
    public void accessBefore(JoinPoint point) {
//        LogHelper.accessLog.info(AccessUtil.getAccessInfo(point));//记录访问资源信息
    }

    @Around("access()")
    public Object check(ProceedingJoinPoint point) throws Throwable{
        long beginTime = System.currentTimeMillis();
        String methodName = point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName();
        try {
            return point.proceed();
        } catch (Exception e) {
            return returnError(point, e);
        } finally {
            long endTime = System.currentTimeMillis();
            double timeConsume = (endTime - beginTime*1.0)/1000;
            System.out.println(methodName + " ----- 耗时(秒)：" + timeConsume);
        }
    }

    private boolean checkAccessUser(ProceedingJoinPoint point){
        Object[] args = point.getArgs();
        String str = null;
        accessErrorRecord(point, str);

        return true;
    }

    private void accessErrorRecord(ProceedingJoinPoint point, String msg){
        StringBuilder sb = new StringBuilder();
        sb.append("[权限警告] == ")
                .append(msg)
                .append(" ,[accessInfo]>>>>>")
                .append(AccessUtil.getAccessInfo(point));
        LogHelper.errorLog.error(sb.toString());
    }

    private Object returnError(ProceedingJoinPoint point, Exception e) {
        e.printStackTrace();
        return GsonUtil.getErrorJson(e.getMessage());
    }
}
