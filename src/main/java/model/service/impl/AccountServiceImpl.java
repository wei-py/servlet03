package model.service.impl;

import model.dao.impl.AccountDaoImpl;
import model.entity.Account;
import model.service.AccountService;
import model.utils.DBUtils;

import java.util.List;

/**
 * 业务逻辑层
 */
public class AccountServiceImpl implements AccountService {
    private AccountDaoImpl accountDao = new AccountDaoImpl();

    /**
     * 转账功能实现
     *
     * @param card_id   付款方卡号
     * @param password  付款方卡密
     * @param toCard_id 收款方卡号
     * @param money     转账金额
     * @return 返回字符串提示信息
     */
    @Override
    public String transfer(String card_id, String password, String toCard_id, double money) {
        String result = "转账失败！";

        try {
            DBUtils.begin();
            Account account = null;
            try {
                account = accountDao.select(card_id);
            } catch (Exception e) {
                throw new RuntimeException("卡号不存在！");
            }

            if (!account.getPassword().equals(password)) {
                throw new RuntimeException("密码错误！");
            }
            if (account.getBalance() < money) {
                throw new RuntimeException("卡内余额不足！");
            }
            Account toAccount = null;
            try {
                toAccount = accountDao.select(toCard_id);
            } catch (Exception e) {
                throw new RuntimeException("收款方卡号不存在！");
            }

            account.setBalance(account.getBalance() - money);
            accountDao.update(account);
            toAccount.setBalance(toAccount.getBalance() + money);
            accountDao.update(toAccount);

            DBUtils.commit();
            return "转账成功！";
        } catch (Exception e) {
            e.printStackTrace();
            DBUtils.rollback();
        }
        return result;
    }

    /**
     * 注册功能实现
     *
     * @param account Account对象
     * @return 返回字符串提示信息
     */
    @Override
    public String register(Account account) {
        try {
            DBUtils.begin();
            Account checkAccount = accountDao.select(account.getCard_id());
            if (checkAccount != null) {
                throw new RuntimeException("卡号已存在！");
            }
            int result = accountDao.insert(account);
            if (result > 0) {
                DBUtils.commit();
                return "注册成功！";
            } else {
                return "注册失败！";
            }
        } catch (Exception e) {
            DBUtils.rollback();
            e.printStackTrace();
        }
        return "注册失败！";
    }

    /**
     * 登录功能实现
     *
     * @param card_id  卡号
     * @param password 卡密
     * @return 返回一个校验过的Account对象；没有校验通过就返回null
     */
    @Override
    public Account login(String card_id, String password) {
        Account checkAccount = accountDao.select(card_id);
        if (checkAccount == null)
            throw new RuntimeException("卡号不存在！");
        if (checkAccount.getPassword().equals(password)) {
            System.out.println("登陆成功！");
            return checkAccount;
        }
        System.out.println("登录失败！");
        return null;
    }

    @Override
    public List<Account> showAllAccount() {
        return accountDao.selectAll();
    }

    /**
     * 删除功能实现
     *
     * @param card_id 卡号
     * @return 返回字符串提示信息
     */
    @Override
    public String delete(String card_id) {
        try {
            DBUtils.begin();
            int result = accountDao.delete(card_id);
            if (result > 0) {
                DBUtils.commit();
                return "删除成功！";
            } else {
                return "删除失败！";
            }
        } catch (Exception e) {
            DBUtils.rollback();
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Account select(String card_id) {
        Account result = accountDao.select(card_id);
        if (result != null) {
            return result;
        }
        System.out.println("您查询的卡号信息不存在！");
        return null;
    }
}