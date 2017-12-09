package cn.teacher.dao;

import java.sql.SQLException;
import java.util.List;
import cn.student.vo.student;
public interface IDAO {
    /**
     * 收索老师但前上的课学生信息
     * @param tid 查询主键
     * @return 返回学生的信息集合
     * @throws SQLException
     */
    public List<student> findstudents(String tid)throws SQLException;

    /**
     * 根据缺到扣分
     * @param tid 查询主键
     * @return 返回学生信息
     * @throws SQLException
     */
    public List<student>  setDecution(String tid)throws SQLException;
}
