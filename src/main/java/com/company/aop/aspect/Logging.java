package com.company.aop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging{

//    @Before("execution(public void addAccount())")
//    @Before("execution(public void add*())")
    @Before("execution(* add*())")
//   @Before("execution(* add*(com.company.aop.entity.Account))")
// 	@Before("execution(public void com.company.aop.dao.AccountDAO.addAccount())")
    public void before(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName()+"this is before");
        System.out.println("beforeAccount is got called");
    }


}
