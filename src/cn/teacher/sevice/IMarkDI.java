package cn.teacher.sevice;

import java.sql.SQLException;

public interface IMarkDI {
    /**
     *  实现缺到学生的扣分操作
     * @param tid 表示当前上课老师的学工号
     * @param number 要扣除的分数
     * @return 成功返回true，失败返回flase
     * @throws SQLException
     */
    public boolean MarkDecrease(String tid,int number)throws SQLException;
    /**
     * 实现分数增加操作
     * @param sid 表示要操作的主键
     * @param number 增加的分数
     * @return 成功返回true,失败返回flase
     * @throws SQLException
     */
    public boolean IncreaseMark(String sid,int number,String tid)throws SQLException;
}
