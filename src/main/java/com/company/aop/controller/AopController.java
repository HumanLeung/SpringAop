package com.company.aop.controller;

import com.company.aop.entity.Account;
import com.company.aop.service.ServiceImpl;
import com.company.aop.service.TrafficFortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop")
public class AopController {
    @Autowired
   public ServiceImpl service;

    @Autowired
    public TrafficFortuneService fortuneServices;

    @GetMapping("/add")
   public void addAccount() {
//      service.TestAccount(new Account());
      service.addAccount(new Account(), true);
        service.testPrivate();
//        service.testInvoke();
        // private method can't be invoked even thought invoked in public
   }

   @GetMapping("/test")
   public void test() {
//        service.testPrivate();
//       service.testGetter();
       service.findAccounts();
   }

   @GetMapping("/around")
    public String around() {
        return fortuneServices.getFortune();
   }

   @GetMapping("/after")
    public void after() {
    service.findAccounts();
   }

}
