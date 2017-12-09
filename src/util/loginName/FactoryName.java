package util.loginName;

import java.sql.Connection;

public class FactoryName {

    public static INameSelect getNameGetInstance(Connection conn){
               return new NameSelect(conn);
    }
}
