package com.company.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logging4 {
    @After("execution(* com.company.aop.dao.AccountDao.findAccounts(..))")
    public void afterFinal(JoinPoint joinPoint) {
    String method = joinPoint.getSignature().toShortString();
    String method2 = joinPoint.getSignature().toString();
        System.out.println("@After " + method);
        System.out.println("After2 " + method2);
    }
}
