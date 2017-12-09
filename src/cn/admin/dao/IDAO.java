package cn.admin.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDAO<V> {
    /**
     * 实现数据增加的操做
     * @param vo 表示要操作的对象
     * @return 成功返回true 失败返回flase
     * @throw SQLEXCEPTIOM
     */
    public  boolean doCreate(V vo)throws SQLException;



}
