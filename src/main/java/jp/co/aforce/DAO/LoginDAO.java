package jp.co.aforce.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.bean.LoginBean;

public class LoginDAO extends LDAO{
	
	@SuppressWarnings("null")
	public LoginBean search(String name, String pass) throws Exception{
		LoginBean lb = null;
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"select * from login where name = ? and pass = ?");
		st.setString(1, name);
		st.setString(2, pass);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			lb= new LoginBean();
			lb.setId(rs.getString("id"));
			lb.setName(rs.getString("name"));
			lb.setPass(rs.getString("pass"));
		}
						
		st.close();
		con.close();
		return lb;
	
		}
	}

	