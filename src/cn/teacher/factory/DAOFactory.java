package cn.teacher.factory;

import cn.teacher.dao.IDAO;
import cn.teacher.dao.IMark;
import cn.teacher.dao.IStudent;
import cn.teacher.dao.ITStudentSlect;
import cn.teacher.dao.Impl.DAOStudent;
import cn.teacher.dao.Impl.TeacherFind;

import java.sql.Connection;

public class DAOFactory {
    public static IDAO getStudentsInstance(Connection conn){
        return  new DAOStudent(conn);
    }
    public static IMark getMarkInstance(Connection conn){
        return  new DAOStudent(conn);
    }
    public static IStudent getStudentAbsent(Connection conn){
        return new DAOStudent(conn);
    }
    public static ITStudentSlect getStudentSelect(Connection conn){
        return new TeacherFind(conn);
    }
}
