package model.dao.impl;

import model.advanced.impl.AccountRowMapper;
import model.dao.AccountDao;
import model.entity.Account;
import model.utils.DaoUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * 数据库访问层（持久层）
 */
public class AccountDaoImpl implements AccountDao {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    /**
     * DAO通用的方法工具
     */
    private DaoUtils<Account> daoUtils = new DaoUtils<>();

    /**
     * 新增功能实现
     *
     * @param account Account对象
     * @return 返回一个受影响行数
     */
    @Override
    public int insert(Account account) {
        String sql = "insert into t_account (card_id, password, username, balance, phone) values (?, ?, ?, ?, ?)";
        Object[] args = {account.getCard_id(), account.getUsername(), account.getPassword(), account.getBalance(), account.getPhone()};
        return daoUtils.commonsUpdate(sql, args);
    }

    /**
     * 删除功能实现
     *
     * @param card_id 卡号
     * @return 返回一个受影响行数
     */
    @Override
    public int delete(String card_id) {
        return daoUtils.commonsUpdate("delete from t_account where card_id = ?", card_id);
    }

    /**
     * 修改功能实现
     *
     * @param account Account对象
     * @return 返回一个受影响行数
     */
    @Override
    public int update(Account account) {
        String sql = "update t_account set password = ?, username = ?, balance = ?, phone = ? where card_id = ?";
        Object[] args = {account.getPassword(), account.getUsername(), account.getBalance(), account.getPhone(), account.getCard_id()};
        return daoUtils.commonsUpdate(sql, args);
    }

    /**
     * 查询一条信息操作实现
     *
     * @param card_id 卡号
     * @return 返回查询到的Account对象
     */
    @Override
    public Account select(String card_id) {
        List<Account> accountList = daoUtils.commonsSelect("select card_id, password, username, balance, phone from t_account where card_id = ?", new AccountRowMapper(), card_id);
        if (accountList != null && accountList.size() != 0) {
            return accountList.get(0);
        }
        return null;
    }

    /**
     * 查询所有信息操作实现
     *
     * @return 返回查询所有信息的集合
     */
    @Override
    public List<Account> selectAll() {
        return daoUtils.commonsSelect("select card_id, password, username, balance, phone from t_account", new AccountRowMapper());
    }
}
