package com.juebingliu.boot4learn.config.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author juebing
 * @date 2018/12/7 14:18
 * @description
 */
@Aspect
@Component
@Order(1)//order的值越小优先级越高，实现Ordered接口返回的值越小优先级越高
public class WebLogAspect {
    private Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution(public * com.juebingliu.boot4learn.controller..*.*(..))")
    public void webLog(){}

//    @Around("webLog()")
//    public void doBefore(ProceedingJoinPoint joinPoint) throws Throwable {
//        // 接收到请求，记录请求内容
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//
//        // 记录下请求内容
//        logger.info("URL : " + request.getRequestURL().toString());
//        logger.info("HTTP_METHOD : " + request.getMethod());
//        logger.info("IP : " + request.getRemoteAddr());
//        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
//
//        Object o = joinPoint.proceed();
//        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
//        Method method = ms.getMethod();
//
//        //判断是否包含了 无需记录日志的方法
//        Log logAnno = AnnotationUtils.getAnnotation(method, Log.class);
//        if(logAnno != null && logAnno.ignore()) {
//            logger.info("日志打印忽略");
//        }
//        logger.info("log注解描述：{}", logAnno.desc());
//    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterThrowing(pointcut="webLog()",throwing="e")
    public void afterThrowable(Throwable e) {
        logger.error("切面发生了异常：", e);
        //这里可以做个统一异常处理
        //自定义一个异常 包装后排除
        //throw new AopException("xxx);
    }

    /**
     * 该方法返回的值越小优先级越高
     * @return
     */

    @After("webLog()")
    public void doAfter() {
        logger.info("MISSION COMPLETE");
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
    }
}