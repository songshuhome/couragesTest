package cn.teacher.dao.Impl;

import cn.student.dao.IStudent;
import cn.student.service.IStudentLSService;
import cn.teacher.dao.IDAO;
import cn.teacher.dao.IMark;
import util.AbstractDAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import cn.student.vo.student;

public class DAOStudent extends AbstractDAOImpl implements IDAO ,IMark, cn.teacher.dao.IStudent{
    public DAOStudent(Connection conn) {
        super(conn);
    }

    @Override
    public List<student> findstudents(String tid) throws SQLException {
        String  grade=getGrade(tid);
        List<student> all=new ArrayList<student>();
        String sql="SELECT statu,flag,name,sid,grade,phone FROM students WHERE grade=?";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,grade);
        ResultSet rs=super.pstmt.executeQuery();
        while(rs.next()){
            student st=new student();
            st.setStatu(rs.getInt(1));
            st.setFlag(rs.getInt(2));
            st.setName(rs.getString(3));
            st.setSid(rs.getString(4));
            st.setGrade(rs.getString(5));
            st.setPhone(rs.getString(6));
            all.add(st);
        }

        return all;
    }

    @Override
    public List<student> setDecution(String tid) throws SQLException {
        return null;
    }

    private String getGrade(String tid)throws SQLException {
         String name=null;
          String grade=null;
        try {
            name=getName(tid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String date=getdate();
        String sql="SELECT grade,lesson FROM courages WHERE week=? AND teacher=?";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,date);
        super.pstmt.setString(2,name);
        ResultSet rs=super.pstmt.executeQuery();
        if(rs.next()){
            grade=rs.getString(1);
        }
        return grade;
    }

    private String getLesson(String tid)throws SQLException {
        String name=null;
        String lesson=null;
        try {
            name=getName(tid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String date=getdate();
        String sql="SELECT lesson FROM courages WHERE week=? AND teacher=?";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,date);
        super.pstmt.setString(2,name);
        ResultSet rs=super.pstmt.executeQuery();
        if(rs.next()){
            lesson=rs.getString(1);
        }
        return lesson;
    }

    private String getName(String tid) throws SQLException {
        String name=null;
        String sql="SELECT name FROM teachers WHERE tid=?";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,tid);
        ResultSet rs=super.pstmt.executeQuery();
        if(rs.next()){
            name=rs.getString(1);
        }
        return name;
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

    @Override
    public boolean decreaseMark(String tid, int number) throws SQLException {
        String stept=getGrade(tid);
        String courage=getLesson(tid);
        Vector<student> a=getVector(stept);
        for(student b: a){
            int grade=0;
            String sql="UPDATE mark SET grade=? WHERE sid=? AND courage=?";
            String sq="SELECT grade FROM mark WHERE sid=? AND courage=?";
            super.pstmt=super.conn.prepareStatement(sq);
            super.pstmt.setString(1,b.getSid());
            super.pstmt.setString(2,courage);
            ResultSet rs=super.pstmt.executeQuery();
            if(rs.next()){grade=rs.getInt(1); }
            super.pstmt=super.conn.prepareStatement(sql);
            super.pstmt.setInt(1,grade-number);
            super.pstmt.setString(2,b.getSid());
            super.pstmt.setString(3,courage);
            int i=super.pstmt.executeUpdate();

        }

        return true;
    }

    private Vector<student> getVector(String stept)throws SQLException {
        Vector<student> all=new Vector<student>();
        String sql="SELECT sid FROM students WHERE flag='1' ";
        super.pstmt=super.conn.prepareStatement(sql);
        ResultSet rs=super.pstmt.executeQuery();
        while(rs.next()){
            student vo=new student();
            vo.setSid(rs.getString(1));
            all.add(vo);
        }
        return all;
    }

    @Override
    public boolean increaseGrade(String sid, int number,String tid) throws SQLException {
        int grade=0;
        String lesson=getLesson(tid);
        String sql="UPDATE mark SET grade=? WHERE sid=? AND courage=?";
        String sq="SELECT grade FROM mark WHERE sid=? AND courage=?";
        super.pstmt=super.conn.prepareStatement(sq);
        super.pstmt.setString(1,sid);
        super.pstmt.setString(2,lesson);
        ResultSet rs=super.pstmt.executeQuery();
        if(rs.next()){grade=rs.getInt(1); }
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,grade+number);
        super.pstmt.setString(2,sid);
        super.pstmt.setString(3,lesson);
        int i=super.pstmt.executeUpdate();
        return true;
    }

    @Override
    public boolean backupStudent(String tid) throws SQLException {
        Calendar cal=Calendar.getInstance();
        String date=(cal.get(Calendar.MONTH))+"-"+(cal.get(Calendar.DATE));
        int i=0;
        int j=0;
        String  grade=getGrade(tid);
        List<student> all=new ArrayList<student>();
        String sql="SELECT statu,flag,sid,name,grade FROM students WHERE grade=?AND flag=? OR statu= ?";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,grade);
        super.pstmt.setInt(2,1);
        super.pstmt.setInt(3,1);
        ResultSet rs=super.pstmt.executeQuery();
        while(rs.next()){
            student st=new student();
            st.setStatu(rs.getInt(1));
            st.setFlag(rs.getInt(2));
            st.setName(rs.getString(3));
            st.setSid(rs.getString(4));
            st.setGrade(rs.getString(5));
            all.add(st);
        }
        for(student b: all){
            String sq="INSERT INTO absent(sid,name,grade,flag,statu,lastdate) VALUES(?,?,?,?,?,?)";
            super.pstmt=super.conn.prepareStatement(sq);
            super.pstmt.setString(1,b.getSid());
            super.pstmt.setString(2,b.getName());
            super.pstmt.setString(3,b.getGrade());
            super.pstmt.setInt(4,b.getFlag());
            super.pstmt.setInt(5,b.getStatu());
            super.pstmt.setString(6, date);
            i=super.pstmt.executeUpdate();

         }
         boolean b=intiStudent(tid);

        if ((i > 0)&&b) return true;
        else return false;
    }
    public boolean intiStudent(String tid)throws SQLException{
        String  grade=getGrade(tid);
        String sql="UPDATE students SET flag='1',statu='0' WHERE grade=?";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,grade);
        int i=0;
        i=super.pstmt.executeUpdate();
        if (i > 0) return true;
        else return false;


    }

}
