package cn.login.dao;

import java.sql.SQLException;

public interface IDAO {
    /**
     * 实现登录操作管理员登录
     * @return
     * @throws SQLException
     */
    public boolean aFondlogin(String aid, String password)throws SQLException;

    /**
     * 实现学生登录
     * @param aid 登录用户名
     * @param password 登录密码
     * @return 成功返回true 失败返回flase
     * @throws SQLException
     */
    public boolean sFondlogin(String aid, String password)throws SQLException;
    /**
     * 实现老师登录
     * @param aid 登录用户名
     * @param password 登录密码
     * @return 成功返回true 失败返回flase
     * @throws SQLException
     */
    public boolean tFondlogin(String aid, String password)throws SQLException;

    /**
     * 实现用户最后一次登录时间数据更新操作
     * @param aid  表示要更新数据的主键
     * @return 成功返回true ，失败返回flase
     * @throws SQLException
     */
    public boolean adoUpdateByLastDate(String aid)throws SQLException;

    /**
     * 实现用户最后一次登录时间数据更新操作
     * @param aid  表示要更新数据的主键
     * @return 成功返回true ，失败返回flase
     * @throws SQLException
     */
    public boolean sdoUpdateByLastDate(String aid)throws SQLException;


    /**
     * 实现用户最后一次登录时间数据更新操作
     * @param aid  表示要更新数据的主键
     * @return 成功返回true ，失败返回flase
     * @throws SQLException
     */
    public boolean tdoUpdateByLastDate(String aid)throws SQLException;

    /**
     * 查询是否是超级管理员
     * @param aid
     * @return
     * @throws SQLException
     */
    public int superAdmin(String aid)throws SQLException;

}
