package cn.admin.dao;

import java.sql.SQLException;
import java.util.List;

public interface IAbsent<V> {
    /**
     * 实现数据分页操作
     * @param column 表示要执行查询列
     * @param keyWord 表示查询关键字
     * @param currentPage 表示当前页
     * @param lineSize 表示每页显示的记录数
     * @return 成功返回true 失败示范户flase
     * @throws SQLException
     */
    public List<V> findAllById(String column, String keyWord, Integer currentPage, Integer lineSize)throws SQLException;
    /**
     * 实现数据统计操作
     * @param column 表示要执行操作统计列
     * @param keyWord 表示统计查询关键字
     * @return 成功返回true 失败返回flase
     * @throws SQLException
     */
    public Integer getAllCount(String column,String keyWord)throws SQLException;

    /**
     * 查询缺到学生信息
     * @param sid 表示要查找的主键
     * @return成功返回学生信息
     * @throws SQLException
     */
    public List<V>  getAbsentStudents(String sid)throws SQLException;


}
