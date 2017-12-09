package util.loginName;

import java.sql.SQLException;

public interface INameSelect {
    /**
     * 根据传入的学号查询姓名
     * @param aid 传入的主键
     * @return
     * @throws SQLException
     */
    public  String forName(String aid)throws SQLException;
}
