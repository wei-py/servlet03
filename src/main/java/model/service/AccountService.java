package model.service;

import model.entity.Account;

import java.util.List;

public interface AccountService {
    /**
     * 转账功能
     *
     * @param card_id   付款方卡号
     * @param password  付款方卡密
     * @param toCard_id 收款方卡号
     * @param money     转账金额
     * @return 返回字符串提示信息
     */
    String transfer(String card_id, String password, String toCard_id, double money);

    /**
     * 注册功能
     *
     * @param account Account对象
     * @return 返回字符串提示信息
     */
    String register(Account account);

    /**
     * 登录功能
     * @param card_id 卡号
     * @param password 卡密
     * @return 返回字符串提示信息
     */
    Account login(String card_id, String password);

    /**
     * 查询所有账户信息（经理权限）
     */
    List<Account> showAllAccount();

    /**
     * 销户
     * @param card_id
     * @return
     */
    String delete(String card_id);

    /**
     * 查一条信息
     * @param card_id 卡号
     * @return 返回查到的一个Account对象
     */
    Account select(String card_id);
}