package cn.student.factory;

import cn.student.dao.ILeave;
import cn.student.dao.IStudent;
import cn.student.dao.Icourages;
import cn.student.dao.Imp.CourageImpl;
import cn.student.dao.Imp.StudentImp;
import cn.student.dao.Imp.StudentLS;

import java.sql.Connection;

public class StudentFactory {
    public static IStudent getStudentInstance(Connection conn){
        return new StudentImp(conn);
    }
    public static ILeave getStudentLSInstance(Connection conn){
        return new StudentLS(conn);
    }
    public static Icourages getStudentCourgeInstance(Connection conn){ return new CourageImpl(conn);}
}
