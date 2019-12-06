package com.main.dao;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.main.model.Login;
import com.main.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



public class UserdaoImp  implements Userdao
{
	DataSource dataSource;
	@Autowired
	JdbcTemplate JdbcTemplate;

	public void Register(User user)
	{
	String sql="INSERT INTO users VALUES(?,?,?,?,?,?,?)";
	JdbcTemplate.update(sql,new Object[] {
			user.getUsrname(),user.getPswd(),user.getFstname(),user.getLstname(),user.getEmail(),
			user.getAdrs(),user.getPhoneno()});
	
	
	}

	public User ValidateUser(Login login) 
	{
		
		String sql="select * from users where username='"+login.getuname()+"' and password='"+login.getpswd()+"'";
		System.out.println(sql);
		List<User> users=JdbcTemplate.query(sql,new UserMapper());
			return users.size()>0?users.get(0): null;
		}	
}
class UserMapper implements RowMapper<User>
{
public User mapRow(ResultSet rs,int arg1)	throws SQLException
{
	User Reguser=new User();
	Reguser.setUsrname(rs.getString("username"));
	Reguser.setEmail(rs.getString("email"));
	Reguser.setPswd(rs.getString("password"));
	return Reguser;
	
}
}
