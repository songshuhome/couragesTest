package cn.admin.service;

import java.sql.SQLException;
import cn.student.vo.*;
public interface IAdminService {
    /**
     * 增加管理员
     * @param vo 表示要操作的对象
     * @return 成功返回true 失败flase
     * @throws SQLException
     */
    public boolean InsertAdmin(admin vo)throws Exception;
}
