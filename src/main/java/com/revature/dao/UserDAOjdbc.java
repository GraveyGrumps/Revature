package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class UserDAOjdbc implements UserDAO {
	private ConnectionUtil connU = ConnectionUtil.getConnectionUtil();
	private Logger log = Logger.getRootLogger();
	@Override
	public User findByUsernameAndPassword(String username, String password) {
		User u = null;
		try(Connection conn = connU.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM USERS WHERE username = ? AND password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				log.debug("got user");
				u = new User();
				u.setUsername(username);
				u.setPassword(password);
				u.setUserId(rs.getInt("user_id"));
			}
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

}
