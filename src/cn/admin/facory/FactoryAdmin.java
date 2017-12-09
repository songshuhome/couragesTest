package cn.admin.facory;

import cn.admin.dao.IAbsent;
import cn.admin.dao.IDAO;
import cn.admin.dao.IGrade;
import cn.admin.dao.Impl.AbsentImpl;
import cn.admin.dao.Impl.GradeImpl;
import cn.admin.dao.Impl.InsetAdmin;

import java.sql.Connection;

public class FactoryAdmin {
    public static IDAO getAdminInstance(Connection conn){
        return  new InsetAdmin(conn);
    }
    public static IAbsent getAbsentInstance(Connection conn){
        return new AbsentImpl(conn);
    }
    public static IGrade getGradeInstance(Connection conn){return new GradeImpl(conn);}
}
