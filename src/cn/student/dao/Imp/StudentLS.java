package cn.student.dao.Imp;

import cn.student.dao.ILeave;
import cn.student.vo.student;
import util.AbstractDAOImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class StudentLS extends AbstractDAOImpl implements ILeave {
    public StudentLS(Connection conn) {
        super(conn);
    }

    @Override
    public boolean updateLeave(student vo) throws SQLException {
        String sql="UPDATE students SET flag=? WHERE sid=?";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,0);
        super.pstmt.setString(2,vo.getSid());
        if (super.pstmt.executeUpdate() > 0) return true;
        else return false;
    }

    @Override
    public boolean updateSign(student vo) throws SQLException {
        String sql="UPDATE students SET statu=? WHERE sid=?";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,1);
        super.pstmt.setString(2,vo.getSid());
        if (super.pstmt.executeUpdate() > 0) return true;
        else return false;
    }
}
