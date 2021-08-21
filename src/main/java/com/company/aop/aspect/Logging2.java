package com.company.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging2 {

    @Pointcut("execution(* com.company.aop.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("execution(* com.company.aop.dao*.get*(..))")
    private void getter() {}

    @Pointcut("execution(* com.company.aop.dao.*.set*(..))")
    private void setter() {}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter() {}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter2() {}

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice() {
        System.out.println("Before is running");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics() {
        System.out.println("Before is running 2");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdviceGetSet() {
        System.out.println("NoGetterSetter");
    }
    // pointcut -> execution
}
