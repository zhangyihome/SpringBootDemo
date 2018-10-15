package com.example.demo4.aop;

import com.example.demo4.annotation.MyLog;
import com.example.demo4.dao.SysLogDao;
import com.example.demo4.pojo.SysLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.annotations.common.util.impl.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class LogAspect {
    @Autowired
    private SysLogDao sysLogDao;
    
    @Pointcut("@annotation(com.example.demo4.annotation.MyLog)")
    public void pointcut() { }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        try {
            // 执行方法
            result = point.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        // 保存日志
        saveLog(point, time);
        return result;
    }
	private void saveLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysLog sysLog = new SysLog();
        MyLog logAnnotation = method.getAnnotation(MyLog.class);
        if (logAnnotation != null) {
            // 注解上的描述
            sysLog.setOperation(logAnnotation.value());
        }
        // 设置IP地址
        // 模拟一个用户名
        sysLog.setUsername("mrbird");
        sysLog.setcTime(new Date());
        // 保存系统日志
        sysLogDao.saveLog(sysLog);
    }
}