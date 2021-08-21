package com.company.aop.aspect;

import com.company.aop.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class Logging3 {
    @Before("com.company.aop.aspect.Logging2.forDaoPackageNoGetterSetter2()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("this is JoinPoint");
        // display the method signature
        MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
        System.out.println(Arrays.toString(theJoinPoint.getArgs()) + " this is methods Args");
        System.out.println(theJoinPoint.getTarget().getClass() + " this is target");
        System.out.println("this is Method shows : "+ methodSig);
    }

    @Around("execution(* com.company.aop.service.*.getFortune())")
    public Object aroundGetFortune(
            ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("this is around " + method);
        // get begin timestamp
        long begin = System.currentTimeMillis();
        // now, let's execute the method
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Exception throwable) {
            throwable.printStackTrace();
            // rethrow exception
            throw throwable;
        }
        // get end timestamp
        long end = System.currentTimeMillis();
        // compute duration and display it
        long duration = end - begin;
        System.out.println("this is duration "+ duration);
        return result;
    }

    @AfterThrowing(pointcut = "execution(* com.company.aop.dao.AccountDao.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowing(JoinPoint joinPoint, Throwable theExc) throws Throwable {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("AfterThrowing " + method);
        System.out.println("Throwing "+ theExc.getMessage()+ " new Exception");
        throw theExc;
    }
}
