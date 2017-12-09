package cn.student.dao.Imp;

import cn.student.dao.IStudent;
import cn.student.vo.*;
import util.AbstractDAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class StudentImp extends AbstractDAOImpl implements IStudent {
    public StudentImp(Connection conn) {
        super(conn);
    }

    @Override
    public List<courage> findClass(student vo) throws SQLException {
        String clas=getStudent(vo.getSid());
        String date=getdate();
        List<courage> all=new ArrayList<courage>();
        String sql="SELECT grade,lesson,week,site,teacher FROM courages WHERE grade=? AND week=?";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,clas);
        super.pstmt.setString(2,date);
        ResultSet rs=super.pstmt.executeQuery();
        if(rs.next()){
            courage cg=new courage();
            cg.setGrade(rs.getString(1));
            cg.setLesson(rs.getString(2));
            cg.setDate(rs.getString(3));
            cg.setSite(rs.getString(4));
            cg.setTeacher(rs.getString(5));
            all.add(cg);
        }
        return all;
    }

    private String getdate() {
        Calendar cal=Calendar.getInstance();
        int  week=cal.get(Calendar.DAY_OF_WEEK)-1;//获取星期几
        int hour=cal.get(Calendar.HOUR_OF_DAY);//小时
        if(hour>=0&&hour<10){
            hour=8;
        }else if(hour>=10&&hour<12){
            hour=10;
        }else if(hour>=12&&hour<16){
            hour=14;
        }else {
            hour=16;
        }
        String date=week+"-"+hour;
        return date;
    }

    private String getStudent(String sid) throws SQLException {
        String clas=null;
        String  sql="SELECT grade FROM students WHERE sid=?";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,sid);
        ResultSet rs=super.pstmt.executeQuery();
        if(rs.next()) {
            clas = rs.getString(1);
        }
        return clas;
    }
}
