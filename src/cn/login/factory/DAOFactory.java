package cn.login.factory;

import cn.login.dao.IDAO;
import cn.login.dao.Impl.ADOImpl;

import java.sql.Connection;

public class DAOFactory {
 public static IDAO getDAOImplInstance(Connection conn){ return new ADOImpl(conn);}
}
