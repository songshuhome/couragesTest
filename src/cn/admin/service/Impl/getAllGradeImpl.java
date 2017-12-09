package cn.admin.service.Impl;

import cn.admin.facory.FactoryAdmin;
import cn.admin.service.IGrade;
import util.dbc.DatabaseConnection;

import java.util.HashMap;
import java.util.Map;

public class getAllGradeImpl implements IGrade {
    DatabaseConnection jdbc=new DatabaseConnection();

    @Override
    public Map<String, Object> getAllGrade(String stept) throws Exception {
        Map<String,Object> map=new HashMap<String, Object>();
        try {
            map.put("allGrade", FactoryAdmin.getGradeInstance(this.jdbc.getConn()).getGradeIf(stept));
        }catch (Exception e){
            throw e;
        }finally {
            this.jdbc.close();
        }
        return map;
    }
}
