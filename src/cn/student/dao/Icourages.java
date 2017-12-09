package cn.student.dao;
import cn.student.vo.courage;

import java.sql.SQLException;
import java.util.List;

public interface Icourages {
    /**
     * 实现课表查询操作
     */
    public List<courage> Icourages(String sid)throws SQLException;
}
