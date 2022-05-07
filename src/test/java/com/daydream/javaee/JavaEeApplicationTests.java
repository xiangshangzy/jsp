package com.daydream.javaee;

import jsp.util.JDBCUtils;
import jsp.util.JNDIDSUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@SpringBootTest
class JavaEeApplicationTests {
    ResultSet resultSet = null;
    Connection connection = null;
    PreparedStatement statement = null;

    @Test
    void contextLoads() {
    }

    @Test
    void test() {


        String sql = "insert into person(id,name,password,birthday) values(?,?,?,?)";
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, "100");
            statement.setString(2, "100");
            statement.setString(3, "100");
            statement.setString(4, "2000-11-11");
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void test2() {


        String sql = "select count(*) from person where id=?";
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, "1wefwe");

            resultSet = statement.executeQuery();
            resultSet.next();
            int value = resultSet.getInt(1);
            System.out.println(value);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void test3() {

        String str="2000-01-01";
//将字符串转换为Util.Date
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//parse方法转换
        java.util.Date date = null;
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);

//通过util.Date拿到指定日期的毫秒值，再转换成sql.Date
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        System.out.println(sqlDate);
    }
}
