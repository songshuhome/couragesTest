package cn.student.dao;

import java.sql.SQLException;
import cn.student.vo.student;
public interface ILeave {
    /**
     * 学生签到
     * @param vo 表示要操作的对象
     * @return 成功返回 true,失败返回flase
     * @throws SQLException
     */
    public boolean updateLeave(student vo)throws SQLException;
    /**
     * 学生签到
     * @param vo 表示要操作的对象
     * @return 成功返回 true,失败返回flase
     * @throws SQLException
     */
    public boolean updateSign(student vo)throws SQLException;
}
