package cn.admin.facory;

import cn.admin.service.IAbsent;
import cn.admin.service.IAdminService;
import cn.admin.service.IGrade;
import cn.admin.service.Impl.AbsentSplitImpl;
import cn.admin.service.Impl.AdminServiceImpl;
import cn.admin.service.Impl.getAllGradeImpl;

public class FactoryService {
    public static IAdminService ServiceInsertInstance(){
        return new AdminServiceImpl();
    }
    public static IAbsent getAbsentInstance(){
        return new AbsentSplitImpl();
    }
    public static IGrade getGradeInstance(){
        return new getAllGradeImpl();
    }
}
