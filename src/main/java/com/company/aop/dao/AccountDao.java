package com.company.aop.dao;

import com.company.aop.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDao {

    public AccountDao accountDao;
    private String serviceCode;
    private String name;

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
        System.out.println("service");
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("name");
    }

    public void addAccount(Account theAccount) {
        System.out.println(getClass() + "do some on account" + theAccount);
    }

    @Autowired
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT WITH BOOLEAN TRUE");
    }

    protected void addAccount() {
        System.out.println("this is private account");
    }

    public boolean doWork() {
        System.out.println(getClass()+ ": doWork()");
        return false;
    }
    // protected is ok
    // public is ok

    public void testPrivate() {
       accountDao.addAccount();
        System.out.println(this);
    }

    public List<Account> findAccounts(){
        List<Account> myAccounts = new ArrayList<>();
        // create sample accounts
        Account temp1 = new Account("John","Silver");
        Account temp2 = new Account("Madhu","Platinum");
        Account temp3 = new Account("Luca","Gold");

        // add them to our accounts list
        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);
        return myAccounts;
    }

    public List<Account> findAccounts(boolean tripWire) {
        // for academic purpose ... simulate an exception
//        if (tripWire) {
//            throw new RuntimeException("No soup for you!!!");
//        }
        List<Account> Accounts = new ArrayList<>();
        // create sample accounts
        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("Madhu", "Platinum");
        Account temp3 = new Account("Luca", "Gold");

        // add them to our accounts list
        Accounts.add(temp1);
        Accounts.add(temp2);
        Accounts.add(temp3);

        return Accounts;
    }



}
