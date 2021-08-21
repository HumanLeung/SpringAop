package com.company.aop.service;

import com.company.aop.dao.AccountDao;
import com.company.aop.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl {

    private final AccountDao accountDao;
    @Autowired
    public ServiceImpl (AccountDao accountDao){
        this.accountDao = accountDao;
    }

    public void TestAccount(Account account) {
        accountDao.addAccount(account);
    }


    public void addAccount(Account account, boolean is) {
        accountDao.addAccount(account,is);
        System.out.println(accountDao);
    }

    public void testPrivate() {
        accountDao.testPrivate();
//        accountDao.addAccount();
        System.out.println(accountDao);

    }
    public void testInvoke() {
//        accountDao.addAccount();
    }

    public void testGetter() {
        accountDao.setServiceCode("34534");
        accountDao.setName("john");
        accountDao.addAccount(new Account());
    }

    public void findAccounts(){
//        accountDao.findAccounts();
          accountDao.findAccounts(true);
    }


}
