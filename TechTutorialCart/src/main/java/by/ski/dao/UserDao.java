package by.ski.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import by.ski.model.User;

public class UserDao {

	private Connection con;
	private String query;
	private PreparedStatement prepStnt;
	private ResultSet resultSet;

	public UserDao(Connection con) {
		this.con = con;
	}

	public User userLogin(String inpEmail, String inpPassword) {
		User user = null;
		try {
			query = "select*from users where email=? and password=?";
			prepStnt = con.prepareStatement(query);
			prepStnt.setString(1, inpEmail);
			prepStnt.setString(2, inpPassword);
			
			resultSet = prepStnt.executeQuery();

			if (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return user;
	}
}
