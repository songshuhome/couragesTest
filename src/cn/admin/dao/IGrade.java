package cn.admin.dao;

import java.sql.SQLException;
import java.util.List;

public interface IGrade<V> {
    /**
     * 实现全班考勤查询
     * @return 全班数据
     * @throws SQLException
     */
    public List<V> getGradeIf(String stept)throws SQLException;
}
