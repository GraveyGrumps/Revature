package com.revature.dao;

import com.revature.beans.User;

public interface UserDAO {
	User findByUsernameAndPassword(String username, String password);
}
