package cn.student.service.Impl;

import cn.student.factory.StudentFactory;
import cn.student.service.IStudentsCourage;
import util.dbc.DatabaseConnection;

import java.util.HashMap;
import java.util.Map;

public class StudentsCourage implements IStudentsCourage {
    DatabaseConnection jdbc=new DatabaseConnection();
    @Override
    public Map<String, Object> getAllCourages(String sid) throws Exception {
        Map<String,Object> map=new HashMap<String,Object>();
        try {
            map.put("allCourages", StudentFactory.getStudentCourgeInstance(this.jdbc.getConn()).Icourages(sid));
        }catch (Exception e){
            throw e;
        }finally {
            this.jdbc.close();
        }
        return map;
    }
}
