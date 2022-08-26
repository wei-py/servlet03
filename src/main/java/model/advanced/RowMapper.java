package model.advanced;

import java.sql.ResultSet;

/**
 * 约定，接受结果集。创建对象
 */
public interface RowMapper<T> {
    public T getRow(ResultSet resultSet);
}