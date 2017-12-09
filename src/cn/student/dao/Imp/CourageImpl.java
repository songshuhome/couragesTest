package cn.student.dao.Imp;

import cn.student.dao.Icourages;
import cn.student.vo.courage;
import util.AbstractDAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public  class CourageImpl extends AbstractDAOImpl implements Icourages {
    public CourageImpl(Connection conn) {
        super(conn);
    }

    @Override
    public List<courage> Icourages(String sid) throws SQLException {
        List<courage> all = new ArrayList<courage>();

        String sql = "SELECT lesson,week,site,teacher FROM courages WHERE grade=(SELECT grade FROM students WHERE sid='"+sid+"')";
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()) {
            courage courage = new courage();
            courage.setLesson(rs.getString(1));
            courage.setDate(rs.getString(2));
            courage.setSite(rs.getString(3));
            courage.setTeacher(rs.getString(4));
            all.add(courage);
        }
        return all;
    }


}
