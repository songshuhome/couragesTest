package cn.login.service;

import java.sql.SQLException;

public interface IADOService {
    /**
     * 实现管理员的登录检查操作，调用IAdminDAO 中findLogin;
     * @param aid 表示要操作的用户名
     * @param password 表示要操作的密码
     * @return 成功返回true 失败返回flase
     * @throws SQLException
     */
    public boolean alogin(String aid, String password)throws SQLException;
    /**
     * 实现管理员的登录检查操作，调用IAdminDAO 中findLogin;
     * @param aid 表示要操作的用户名
     * @param password 表示要操作的密码
     * @return 成功返回true 失败返回flase
     * @throws SQLException
     */
    public boolean tlogin(String aid, String password)throws SQLException;
    /**
     * 实现管理员的登录检查操作，调用IAdminDAO 中findLogin;
     * @param aid 表示要操作的用户名
     * @param password 表示要操作的密码
     * @return 成功返回true 失败返回flase
     * @throws SQLException
     */
    public boolean slogin(String aid, String password)throws SQLException;

    public int theSuperAdmin(String aid)throws Exception;

}
