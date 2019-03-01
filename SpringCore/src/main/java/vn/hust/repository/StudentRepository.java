package vn.hust.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import vn.hust.common.SqlQuery;
import vn.hust.database.ConnectDatabase;
import vn.hust.model.Student;
@Repository("studentRepository")
public class StudentRepository {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public boolean addStudent(Student student) {
		connection = ConnectDatabase.getConnection();
		try {
			preparedStatement = connection.prepareStatement(SqlQuery.ADD_STUDENT);
			preparedStatement.setString(1, student.getId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getGender());
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}finally {
			ConnectDatabase.closeConnection(connection);
		}
		return false;
	}
	
	public ArrayList<Student> getAllStudent() {
		ArrayList<Student> list = new ArrayList<Student>();
		connection = ConnectDatabase.getConnection();
		try {
			preparedStatement = connection.prepareStatement(SqlQuery.SHOW_STUDENT);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				list.add(new Student(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}finally {
			ConnectDatabase.closeConnection(connection);
		}
		return list;
	}

}
