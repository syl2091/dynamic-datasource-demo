package com.lege.aspect;

import com.lege.datasource.DataSourceType;
import com.lege.dynamic.DynamicDataSourceContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * @author lege
 * @Description
 * @create 2022-06-08 14:45
 */
@Aspect
@Component
@Order(10)
public class GloabDataSourceAspect {

    @Autowired
    HttpSession session;

    @Pointcut("execution(* com.lege.service.*.*(..))")
    public void pc(){

    }

    @Around("pc()")
    public Object around(ProceedingJoinPoint pjp){
        DynamicDataSourceContextHolder.setDataSourceType((String) session.getAttribute(DataSourceType.DS_SESSION_KEY));
        try {
            return pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }finally {
            DynamicDataSourceContextHolder.clearDataSourceType();
        }
        return null;
    }
}
