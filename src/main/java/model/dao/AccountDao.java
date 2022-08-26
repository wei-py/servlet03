package model.dao;

import model.entity.Account;

import java.util.List;

/**
 * 增、删、改、查一条信息、查所有信息
 */
public interface AccountDao {
    /**
     * 新增操作
     *
     * @param account Account对象
     * @return 返回一条影响行数
     */
    int insert(Account account);

    /**
     * 删除操作
     *
     * @param card_id 卡号
     * @return 返回一条受影响行数
     */
    int delete(String card_id);

    /**
     * 修改操作
     *
     * @param account Account对象
     * @return 返回一条影响行数
     */
    int update(Account account);

    /**
     * 查询一条信息操作
     *
     * @param card_id 卡号
     * @return 根据卡号返回一条Account对象信息
     */
    Account select(String card_id);

    /**
     * 查询所有信息操作
     *
     * @return 查询出所有信息返回所有Account对象集合
     */
    List<Account> selectAll();
}