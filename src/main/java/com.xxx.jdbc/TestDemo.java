package com.xxx.jdbc;

import model.entity.Account;
import model.service.impl.AccountServiceImpl;

public class TestDemo {
    public static void main(String[] args) {
        AccountServiceImpl accountService = new AccountServiceImpl();
        /**
         * 测试转账功能
         */
//        String result = accountService.transfer("1", "123456", "2", 100);
//        System.out.println(result);

        /**
         * 测试注册功能
         */
        Account account = new Account("3", "123456", "weipy", 100, "15918983899");
        String result = accountService.register(account);
        System.out.println(result);

        /**
         * 测试登录功能
         */
//        accountService.login("1", "123456");

        /**
         * 测试查看所有信息
         */
//        accountService.showAllAccount().forEach(System.out::println);

        /**
         * 测试查看一条信息
         */
//        System.out.println(accountService.select("1"));

        /**
         * 测试删除功能
         */
//        accountService.delete("4");
    }
}
