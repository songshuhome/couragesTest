package cn.admin.dao.Impl;

import cn.admin.dao.IGrade;
import cn.student.vo.student;
import util.AbstractDAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeImpl extends AbstractDAOImpl implements IGrade<student> {
    public GradeImpl(Connection conn) {
        super(conn);
    }

    @Override
    public List<student> getGradeIf(String stept) throws SQLException {
        String sql="SELECT name,sid,grade FROM students WHERE grade=?";
        List<student> all=new ArrayList<student>();
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,stept);
        ResultSet rs=super.pstmt.executeQuery();
        while(rs.next()){
            student st=new student();
            st.setName(rs.getString(1));
            st.setSid(rs.getString(2));
            st.setGrade(rs.getString(3));
            st.setNumber(getAbsentNumber(rs.getString(2)));
            all.add(st);
        }
        return all;
    }
    private int getAbsentNumber(String sid)throws SQLException{
        int number=0;
        String sql="SELECT name FROM absent WHERE name=?AND flag=?";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,sid);
        super.pstmt.setInt(2,1);
        ResultSet rs=super.pstmt.executeQuery();
        while(rs.next()){
            number++;
        }
        return number;
    }
}
