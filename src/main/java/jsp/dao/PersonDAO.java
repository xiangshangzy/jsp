package jsp.dao;

import java.sql.*;

import jsp.domain.Person;
import jsp.util.JDBCUtils;

/**
 * 数据层一个程序
 * DAO层返回对象，在业务层通过操作这些对象来实现增删改查
 */
public class PersonDAO {
    public Person login(Person user) { //登录
        Person existUser = null;    //登录用户
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {//JDBC查询
            conn = JDBCUtils.getConnection();
            System.out.println("数据库连接成功");
            String sql = "select * from person where id=?"; //数据库编译时
            stmt = conn.prepareStatement(sql);    //将sql发送给数据库进行编译
            System.out.println(user.getName()+":"+user.getPassword());
            //设置sql参数
            stmt.setString(1,user.getID());    //传入数据值，不会作为关键字 --防止注入
            rs = stmt.executeQuery();            //执行sql
            //如果登陆成功，rs将只有一条记录            
            if (rs.next()) {
                existUser = new Person();    //表示已登录用户
                existUser.setName(rs.getString("name"));
                existUser.setPassword(rs.getString("password"));
                System.out.println("用户"+existUser.getName()+"登录成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(existUser);
        return existUser;
    }
}
