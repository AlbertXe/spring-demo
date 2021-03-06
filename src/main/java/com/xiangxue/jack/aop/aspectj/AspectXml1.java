package com.xiangxue.jack.aop.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class AspectXml1 {
    public void before(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName());
        System.out.println(joinPoint.getSignature().toString());
        System.out.println(joinPoint.getSignature().getDeclaringType());
        System.out.println(joinPoint.getSignature().getDeclaringTypeName());
        System.out.println(joinPoint.getSignature().toLongString());
        System.out.println(joinPoint.getSignature().toShortString());
        System.out.println("AspectXml1====前置通知");
    }

    public void afterReturning(JoinPoint joinPoint, Object returnVal){
        System.out.println("AspectXml1=====后置通知-->返回值:"+returnVal);
    }

    //ProceedingJoinPoint is only supported for around advice
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        System.out.println("AspectXml1=====环绕通知前");
        Object object= joinPoint.proceed();
        System.out.println("AspectXml1=====环绕通知后");
        return object;
    }

    public void afterThrowing(Exception e){
        System.out.println("AspectXml1======异常通知:"+ e.getMessage());
    }

    public void after(JoinPoint joinPoint){
        System.out.println("AspectXml1=====最终通知");
    }
}
