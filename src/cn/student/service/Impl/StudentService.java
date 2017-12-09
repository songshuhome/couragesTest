package cn.student.service.Impl;

import cn.student.factory.StudentFactory;
import cn.student.service.IStudentSerive;
import cn.student.vo.courage;
import util.dbc.DatabaseConnection;
import cn.student.*;
import java.sql.SQLException;
import java.util.List;

public class StudentService implements IStudentSerive {
    DatabaseConnection dbc=new DatabaseConnection();
    @Override
    public List<courage> list(cn.student.vo.student vo) throws Exception {

        try{
        return StudentFactory.getStudentInstance(this.dbc.getConn()).findClass(vo);
    }catch (Exception e){
           throw e;
    }finally {
        this.dbc.close();
        }
        }
}
