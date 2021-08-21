package com.company.aop.aspect;

import org.springframework.stereotype.Component;

@Component
public class MemberDAO {
   public boolean addMember() {
       System.out.println(getClass() + ":this is member ");
       return true;
   }

   public void goToSleep() {
       System.out.println(getClass() +" : go to sleep");
   }
}
