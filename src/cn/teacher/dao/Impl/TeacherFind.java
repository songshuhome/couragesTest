package cn.teacher.dao.Impl;

import cn.student.vo.Grade;
import cn.student.vo.student;
import cn.teacher.dao.ITStudentSlect;
import util.AbstractDAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.student.vo.absent;

public class TeacherFind extends AbstractDAOImpl implements ITStudentSlect {
    public TeacherFind(Connection conn) {
        super(conn);
    }

    @Override
    public List<Grade> findAllGrade(String stept,String lesson) throws SQLException {
        List<Grade> all = new ArrayList<Grade>();
        String sql = "SELECT sid,stept,courage,grade FROM mark WHERE stept=? AND courage=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, stept);
        super.pstmt.setString(2,lesson);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()) {
            Grade gd = new Grade();
            gd.setSid(rs.getString(1));
            gd.setStept(rs.getString(2));
            gd.setCourage(rs.getString(3));
            gd.setGrade(rs.getInt(4));
            all.add(gd);
        }
        return all;
    }


}
