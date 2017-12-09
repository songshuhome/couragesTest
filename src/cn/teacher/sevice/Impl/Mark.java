package cn.teacher.sevice.Impl;

import cn.teacher.dao.IMark;
import cn.teacher.factory.DAOFactory;
import cn.teacher.sevice.IStudentAbsent;
import util.dbc.DatabaseConnection;

import java.sql.SQLException;

public class Mark implements IMark, IStudentAbsent{
    DatabaseConnection jdbc= new DatabaseConnection();
    @Override
    public boolean decreaseMark(String tid, int number) throws SQLException {
        try{
        return DAOFactory.getMarkInstance(this.jdbc.getConn()).decreaseMark(tid,number);
    }catch (SQLException e){
            e.printStackTrace();
        }finally {
        this.jdbc.close();
        }
        return false;
    }

    @Override
    public boolean increaseGrade(String sid, int number,String tid) throws SQLException {
        try{
        return DAOFactory.getMarkInstance(this.jdbc.getConn()).increaseGrade(sid,number,tid);
    }catch(SQLException e){
            e.printStackTrace();
        }finally {
         this.jdbc.close();
        }
        return false;
    }

    @Override
    public boolean absentStudent(String tid) throws Exception {
       try{
        return DAOFactory.getStudentAbsent(this.jdbc.getConn()).backupStudent(tid);
    }catch (SQLException e){
           e.printStackTrace();
       }finally {
        this.jdbc.close();
       }
       return false;
    }
}
