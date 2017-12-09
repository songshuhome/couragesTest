package cn.login.dao.Impl;

import cn.login.dao.IDAO;
import util.AbstractDAOImpl;
import cn.student.vo.admin;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class ADOImpl extends AbstractDAOImpl implements IDAO {
    public ADOImpl(Connection  conn){
        super(conn);

    }


    @Override
    public boolean aFondlogin(String aid, String password) throws SQLException {
        boolean flag=false;
        String sql="SELECT flag FROM admins  WHERE aid=? AND password=?  ";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,aid);
        super.pstmt.setString(2,password);
        ResultSet rs=super.pstmt.executeQuery();
        if(rs.next()){

            flag=true;
        }
        return flag;
    }



    @Override
    public boolean sFondlogin(String aid, String password) throws SQLException {
        boolean flag=false;
        String sql="SELECT name FROM students WHERE sid=? AND password=?  ";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,aid);
        super.pstmt.setString(2,password);
        ResultSet rs=super.pstmt.executeQuery();
        if(rs.next()){

            flag=true;

        }
        return flag;
    }

    @Override
    public boolean tFondlogin(String aid, String password) throws SQLException {
        boolean flag=false;
        String sql="SELECT name FROM teachers WHERE tid=? AND password=?  ";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,aid);
        super.pstmt.setString(2,password);
        ResultSet rs=super.pstmt.executeQuery();
        if(rs.next()){

            flag=true;

        }
        return flag;
    }

    @Override
    public boolean adoUpdateByLastDate(String aid) throws SQLException {
        String sql="UPDATE admins SET lastdate=? WHERE aid=?";
        super.pstmt=super.conn.prepareStatement(sql);
        //登录后直接用当前日期作为最后一次登录日期
        super.pstmt.setTimestamp(1,new Timestamp(new Date().getTime()));
        super.pstmt.setString(2,aid);
        if (super.pstmt.executeUpdate() > 0) return true;
        else return false;
    }

    @Override
    public boolean sdoUpdateByLastDate(String aid) throws SQLException {
        String sql="UPDATE students SET lastdate=? WHERE sid=?";
        super.pstmt=super.conn.prepareStatement(sql);
        //登录后直接用当前日期作为最后一次登录日期
        super.pstmt.setTimestamp(1,new Timestamp(new Date().getTime()));
        super.pstmt.setString(2,aid);
        if (super.pstmt.executeUpdate() > 0) return true;
        else return false;
    }

    @Override
    public boolean tdoUpdateByLastDate(String aid) throws SQLException {
        String sql="UPDATE teachers SET lastdate=? WHERE tid=?";
        super.pstmt=super.conn.prepareStatement(sql);
        //登录后直接用当前日期作为最后一次登录日期
        super.pstmt.setTimestamp(1,new Timestamp(new Date().getTime()));
        super.pstmt.setString(2,aid);
        if (super.pstmt.executeUpdate() > 0) return true;
        else return false;
    }

    @Override
    public int superAdmin(String aid) throws SQLException {
        int flag=0;
        String sql="SELECT flag FROM admins  WHERE aid=?   ";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,aid);
        ResultSet rs=super.pstmt.executeQuery();
        if(rs.next()){
            flag=rs.getInt(1);
        }
        return flag;
    }
}
