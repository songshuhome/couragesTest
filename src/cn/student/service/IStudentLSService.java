package cn.student.service;

import java.sql.SQLException;
import cn.student.vo.student;
public interface IStudentLSService {
    /**
     * 签到
     * @param vo 表示要操作的对想
     * @return 成功返回true，失败返回flase
     * @throws Exception
     */
    public boolean updateSignStudent(student vo)throws SQLException;
    /**
     * 请假
     * @param vo 表示要操作的对想
     * @return 成功返回true，失败返回flase
     * @throws Exception
     */
    public boolean updateLeaveStudent(student vo)throws SQLException;
}
