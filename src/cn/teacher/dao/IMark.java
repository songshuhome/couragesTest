package cn.teacher.dao;

import java.sql.SQLException;

public interface IMark {
    /**
     * 实现缺到学生扣分
     * @param tid 老师工号
     * @param number 所扣分数
     * @return 成功返回true，失败返回flase
     * @throws SQLException
     */
  public boolean decreaseMark(String tid, int number)throws SQLException;

  public boolean increaseGrade(String sid,int number,String tid)throws SQLException;
}
