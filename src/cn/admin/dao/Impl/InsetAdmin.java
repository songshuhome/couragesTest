package cn.admin.dao.Impl;

import cn.admin.dao.IDAO;
import cn.student.vo.*;
import util.AbstractDAOImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InsetAdmin extends AbstractDAOImpl implements IDAO<admin> {
    public InsetAdmin(Connection conn) {
        super(conn);
    }

    @Override
    public boolean doCreate(admin vo) throws SQLException {
        String sql="INSERT INTO admins(aid ,name,password ,lastdate,grade,statu) VALUES(?,?,?,?,?,?)";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,vo.getAid());
        super.pstmt.setString(2,vo.getName());
        super.pstmt.setString(3,vo.getPassword());
        super.pstmt.setTimestamp(4,new Timestamp(new Date().getTime()));
        super.pstmt.setString(5,vo.getGrade());
        super.pstmt.setInt(6,1);
        if (super.pstmt.executeUpdate() > 0) return true;
        else return false;
    }



}
