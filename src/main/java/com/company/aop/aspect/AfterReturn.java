package com.company.aop.aspect;

import com.company.aop.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class AfterReturn {
    @AfterReturning(pointcut = "execution(* com.company.aop.dao.AccountDao.findAccounts(..))",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, List<Account> result){
        String method = joinPoint.getSignature().toShortString();
        System.out.println(" this is afterReturning" + method);
        // print out the results of the method call
        System.out.println("=====>>> result is: " + result);
        convert(result);
        System.out.println("=====>>> upperCase is: " + result);
    }
    private void convert(List<Account> result) {
        for (Account tempAccount : result) {
            String theUpperName = tempAccount.getName().toUpperCase();
            tempAccount.setName(theUpperName);
        }
    }
}
