package util.loginName;

import util.AbstractDAOImpl;
import util.dbc.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NameSelect extends AbstractDAOImpl implements INameSelect {
    DatabaseConnection jdbc=new DatabaseConnection();
    public NameSelect(Connection conn) {
        super(conn);
    }
    public  String forName(String aid)throws SQLException{
         String name=null;
        String namea=selectAdmin(aid);
         String namet=selectteacher(aid);
         String names=selectstudent(aid);
         if(namea!=null){name=namea;}
         else if(namet!=null){name=namet;}
         else if(names!=null){name=names;}
         return name;
    }
    public String selectAdmin(String aid)throws SQLException{
        String name=null;
        String sql="SELECT name From admins WHERE aid=?";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,aid);
        ResultSet rs=super.pstmt.executeQuery();
        if(rs.next()){
            name=rs.getString(1);
        }
        return name;
    }
    public String selectteacher(String aid)throws SQLException{
        String name=null;
        String sql="SELECT name From teachers WHERE tid=?";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,aid);
        ResultSet rs=super.pstmt.executeQuery();
        if(rs.next()){
            name=rs.getString(1);
        }
        return name;
    }
    public String selectstudent(String aid)throws SQLException{
        String name=null;
        String sql="SELECT name From students WHERE sid=?";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,aid);
        ResultSet rs=super.pstmt.executeQuery();
        if(rs.next()){
            name=rs.getString(1);
        }
        return name;
    }

}
