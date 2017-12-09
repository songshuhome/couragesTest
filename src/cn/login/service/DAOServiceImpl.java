package cn.login.service;

import cn.login.factory.DAOFactory;
import util.dbc.DatabaseConnection;

import java.sql.SQLException;

public class DAOServiceImpl implements IADOService {
    DatabaseConnection conn=new DatabaseConnection();
    @Override
    public boolean alogin(String aid, String password) throws SQLException {
       try{
          if( DAOFactory.getDAOImplInstance(this.conn.getConn()).aFondlogin(aid,password))
                 return DAOFactory.getDAOImplInstance(this.conn.getConn()).adoUpdateByLastDate(aid) ;
       }catch(Exception e){
           e.printStackTrace();
       }finally {
           this.conn.close();
       }
        return false;
    }

    @Override
    public boolean tlogin(String aid, String password) throws SQLException {
        try{
           if( DAOFactory.getDAOImplInstance(this.conn.getConn()).tFondlogin(aid,password))
               return DAOFactory.getDAOImplInstance(this.conn.getConn()).tdoUpdateByLastDate(aid);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            this.conn.close();
        }
        return false;
    }

    @Override
    public boolean slogin(String aid, String password) throws SQLException {
        try{
            if(DAOFactory.getDAOImplInstance(this.conn.getConn()).sFondlogin(aid,password))
            return DAOFactory.getDAOImplInstance(this.conn.getConn()).sdoUpdateByLastDate(aid);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            this.conn.close();
        }
        return false;
    }

    @Override
    public int theSuperAdmin(String aid) throws Exception {
        try {
            return DAOFactory.getDAOImplInstance(this.conn.getConn()).superAdmin(aid);
        }catch (SQLException e){
            throw e;
        }finally {
            this.conn.close();
        }
    }
}
