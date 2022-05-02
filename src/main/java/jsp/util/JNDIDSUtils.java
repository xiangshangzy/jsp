package jsp.util;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

/*
 * Person类的JDBC 工具类，抽取公共方法
 */
public class JNDIDSUtils {	 
    private static Connection conn=null;	//与数据库的连接；
     
    //建立连接
    public static Connection getConnection()  {   	
    	try {
			//1、初始化Context(名称查找上下文)
	    	Context ctx = new InitialContext();		
						
			//2、通过JNDI名称找到DataSource,对名称进行定位java:comp/env是必须加的,后面跟的是DataSource名
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/mysql"); 
			
			//3、通过DataSource取得一个连接
			conn = ds.getConnection();
    	} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        return conn;
    }
    
    //释放资源
    public static void release(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }

        release(stmt, conn);
    }
    
    public static void release(Statement stmt, Connection conn) {
        if (stmt != null) {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }
}
