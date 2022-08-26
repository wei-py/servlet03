package model.advanced.impl;

import model.advanced.RowMapper;
import model.entity.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 接口实现类，明确创建的对象，并返回
 */
public class AccountRowMapper implements RowMapper<Account> {

    @Override
    public Account getRow(ResultSet resultSet) {
        Account account = null;
        try {
            account = new Account(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4), resultSet.getString(5));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }
}