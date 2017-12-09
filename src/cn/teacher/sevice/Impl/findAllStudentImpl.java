package cn.teacher.sevice.Impl;

import cn.teacher.factory.DAOFactory;
import cn.teacher.sevice.IfindAllStudent;
import util.dbc.DatabaseConnection;

import java.util.HashMap;
import java.util.Map;

public class  findAllStudentImpl implements IfindAllStudent {
    DatabaseConnection jdbc=new DatabaseConnection();
    @Override
    public Map<String, Object> findStudent( String tid) throws Exception {
        Map<String,Object> map=new HashMap<String, Object>();
        try {
               map.put("allstudent", DAOFactory.getStudentsInstance(this.jdbc.getConn()).findstudents(tid));
            return map;
        }catch (Exception e){
            throw  e;
        }finally {
            this.jdbc.close();
        }

    }
}
