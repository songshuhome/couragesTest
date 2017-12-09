package cn.student.dao;
import cn.student.vo.*;

import java.sql.SQLException;
import java.util.List;

public interface IStudent {
    /**
     * 查询当前时间的课程信息
     * @param vo 表示要操作的对象
     * @return 成功返回true,失败返回flase
     * @throws SQLException
     */
     public List<courage> findClass(student vo)throws SQLException;
}
