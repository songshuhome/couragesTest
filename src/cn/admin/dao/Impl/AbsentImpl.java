package cn.admin.dao.Impl;

import cn.admin.dao.IAbsent;
import cn.admin.dao.IDAO;
import cn.student.vo.*;
import util.AbstractDAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 public class AbsentImpl extends AbstractDAOImpl implements IAbsent<absent> {
     public AbsentImpl(Connection conn) {
         super(conn);
     }

     @Override
    public List<absent> findAllById(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        List<absent> all=new ArrayList<absent>();
        String sql="SELECT sid,name,grade,flag,statu,lastdate FROM absent WHERE  sid=?";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,keyWord);
//        super.pstmt.setInt(2,(currentPage-1)*lineSize);
//        super.pstmt.setInt(3,lineSize);
        ResultSet rs=super.pstmt.executeQuery();
        if(rs.next()){
            absent vo=new absent();
            vo.setSid(rs.getString(1));
            vo.setName(rs.getString(2));
            vo.setGrade(rs.getString(3));
            vo.setFlag(rs.getInt(4));
            vo.setStatu(rs.getInt(5));
            vo.setLastdate(rs.getString(6));
            all.add(vo);
        }
        return all;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws SQLException {
        String sql="SELECT COUNT(*) FROM absent WHERE "+column+" LIKE ? ";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,"%"+keyWord+"%");
        ResultSet rs=super.pstmt.executeQuery();
        if(rs.next()){
            return rs.getInt(1);
        }
        return 0;
    }

     @Override
     public List<absent> getAbsentStudents(String sid) throws SQLException {
         List<absent> all=new ArrayList<absent>();
         String sql="SELECT sid,name,grade,flag,statu,lastdate FROM absent WHERE name=?";
         super.pstmt=super.conn.prepareStatement(sql);
         super.pstmt.setString(1,sid);
         ResultSet rs=super.pstmt.executeQuery();
         while(rs.next()){
             absent vo=new absent();
             vo.setSid(rs.getString(1));
             vo.setName(rs.getString(2));
             vo.setGrade(rs.getString(3));
             vo.setFlag(rs.getInt(4));
             vo.setStatu(rs.getInt(5));
             vo.setLastdate(rs.getString(6));
             all.add(vo);
         }
         return all;
     }




 }
