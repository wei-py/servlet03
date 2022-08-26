package model.utils;

import model.advanced.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoUtils<T> {
    /**
     * 公共处理增、删、改方法
     * sql语句，参数列表
     *
     * @param sql  执行的sql语句
     * @param args 参数列表，占位符赋值
     * @return 受影响行数
     */
    public int commonsUpdate(String sql, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection = DBUtils.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(null, preparedStatement, null);
        }
        return 0;
    }

    /**
     * 公共查询方法（可查询单条信息，也可以查询多条信息，可以查任何一张表）
     * 实现了复用性
     *
     * @param sql       执行的sql语句
     * @param rowMapper 封装对象的接口，准备接口回调
     * @param args      参数列表，占位符赋值
     * @return 返回查询到的对象的集合
     */
    public List<T> commonsSelect(String sql, RowMapper<T> rowMapper, Object... args) {
        List<T> elements = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        connection = DBUtils.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    preparedStatement.setObject(i + 1, args[i]);
                }
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                /**
                 * 根据查询到的结果完成ORM，如何进行对象的创建及赋值呢？
                 * 接口回调---调用者提供了一个封装方法ORM
                 */
                T t = rowMapper.getRow(resultSet);
                elements.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(null, preparedStatement, resultSet);
        }
        return elements;
    }
}