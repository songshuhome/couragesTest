package cn.teacher.sevice.Impl;

import cn.student.vo.Grade;
import cn.student.vo.absent;
import cn.teacher.factory.DAOFactory;
import cn.teacher.sevice.IStudentAbsent;
import cn.teacher.sevice.IStudentIn;
import util.dbc.DatabaseConnection;

import javax.servlet.annotation.WebServlet;
import java.util.HashMap;
import java.util.Map;
public class AbsentStudent implements IStudentIn {
    DatabaseConnection jdbc=new DatabaseConnection();
    @Override
    public Map<String, Object> getGrade(String stept,String tid) throws Exception {
        Map<String,Object> map=new HashMap<String,Object>();
        try {
            map.put("allGrade", DAOFactory.getStudentSelect(this.jdbc.getConn()).findAllGrade(stept,tid));
            return map;
        }catch (Exception e){
            throw  e;
        }finally {
            this.jdbc.close();
        }

    }


    }

