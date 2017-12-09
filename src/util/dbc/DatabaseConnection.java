package util.dbc;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
        private static final String DBDRIVER="com.mysql.jdbc.Driver";
        private static final String DBURL="jdbc:mysql://localhost:3306/classtest";
        private static final String DBUSER="root";
        private static final String DBPASSWORD="ylcto";
        private Connection conn;
        public DatabaseConnection(){
            try {
                //注册驱动
                Class.forName(DBDRIVER);
                //建立连接
                this.conn= DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }

        public Connection getConn() {
            return this.conn;
        }
        public void close(){
            if(this.conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
