package com.xxx.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.db.DBUtils;
import model.entites.User;

/**
 * User{id=1, username='ziph', password='123456', sex='男', email='mylifes1110@163.com', address='河北省'}
 * User{id=2, username='marry', password='123456', sex='女', email='marry@163.com', address='北京市'}
 */
public class OrmSelect {
    public static void main(String[] args) {
        Connection connection = DBUtils.getConnection();
        String sql = "select id,username,password,sex,email,address from user";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {//拿到每一行数据
                //拿到每一列数据
                User user = new User();
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String sex = resultSet.getString("sex");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                //将一行中零散的数据，封装在一个User对象里
                user.setId(id);
                user.setUsername(username);
                user.setPassword(password);
                user.setSex(sex);
                user.setEmail(email);
                user.setAddress(address);
                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(connection, preparedStatement, resultSet);
        }
    }
}