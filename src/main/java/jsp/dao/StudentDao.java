package jsp.dao;

import jsp.domain.Student;
import jsp.util.JNDIDSUtils;

import java.sql.*;

public class StudentDao {
    ResultSet resultSet = null;
    Connection connection = null;
    PreparedStatement statement = null;

    public int idCount(String id) {
        String sql = "select count(*) from person where id=?";
        int count = 0;
        connection = JNDIDSUtils.getConnection();
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            resultSet = statement.executeQuery();
            resultSet.next();
            count = resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JNDIDSUtils.release(resultSet, statement, connection);
        }
        return count;
    }

    public void insertStudent(Student student) {
        String sql = "insert into person(id,name,password,birthday) values(?,?,?,?)";
        connection = JNDIDSUtils.getConnection();
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, student.getId());
            statement.setString(2, student.getName());
            statement.setString(3, student.getPassword());
            statement.setDate(4, new java.sql.Date(student.getBirthDate().getTime()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JNDIDSUtils.release(statement, connection);
        }
    }


    public Student queryStudent(String id, String password) {
        String sql = "select * from person where  id=? and password=?";
        Student student = null;
        connection = JNDIDSUtils.getConnection();
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                student = new Student();
                student.setName(resultSet.getString("id"));
                student.setName(resultSet.getString("name"));
                student.setPassword(resultSet.getString("password"));
                student.setBirthDate(resultSet.getDate("birthday"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JNDIDSUtils.release(resultSet, statement, connection);
        }
        return student;
    }
}
