package jp.co.aforce.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.bean.MemberBean;
public class MemberDAO extends LDAO{
	
    
	public int register(MemberBean register) throws Exception{
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"insert into member values(?, ? , ? , ? , ? , ? , ? , ? , ? , ?)");
		st.setString(1, register.getMember_id());
		st.setString(2, register.getLast_name());
		st.setString(3, register.getFirst_name());
		st.setString(4, register.getSex());
		st.setInt(5, register.getBirth_year());
		st.setInt(6, register.getBirth_month());
		st.setInt(7, register.getBirth_day());
		st.setString(8, register.getJob());
		st.setString(9, register.getPhone_number());
		st.setString(10, register.getMail_address());
		int line = st.executeUpdate();
		
		st.close();
		con.close();
		return line;
	}
	
	@SuppressWarnings("null")
	public MemberBean search(String member_id) throws Exception{
		MemberBean member = null;
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"select * from member where member_id = ? ");
		st.setString(1, member_id);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			member =  new MemberBean();
			member.setMember_id(rs.getString("member_id"));
			member.setLast_name(rs.getString("last_name"));
			member.setFirst_name(rs.getString("first_name"));
			member.setSex(rs.getString("sex"));
			member.setBirth_year(rs.getInt("birth_year"));
			member.setBirth_month(rs.getInt("birth_month"));
			member.setBirth_day(rs.getInt("birth_day"));
			member.setJob(rs.getString("job"));
			member.setPhone_number(rs.getString("phone_number"));
			member.setMail_address(rs.getString("mail_address"));
			
		}
						
		st.close();
		con.close();
		return member;
	
		}
	
	public int update(MemberBean update) throws Exception{
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"update member set "
				+ "last_name = ? "
				+ ", first_name = ? "
				+ ", sex = ? "
				+ ", birth_year = ? "
				+ ", birth_month = ? "
				+ ", birth_day = ? "
				+ ", job = ? "
				+ ", phone_number = ? "
				+ ", mail_address = ? "
				+ " where member_id = ? ");
		
		
		st.setString(1, update.getLast_name());
		st.setString(2, update.getFirst_name());
		st.setString(3, update.getSex());
		st.setInt(4, update.getBirth_year());
		st.setInt(5, update.getBirth_month());
		st.setInt(6, update.getBirth_day());
		st.setString(7, update.getJob());
		st.setString(8, update.getPhone_number());
		st.setString(9, update.getMail_address());
		st.setString(10, update.getMember_id());
		int line = st.executeUpdate();
		
		st.close();
		con.close();
		return line;
	}
	
	public int delete(MemberBean delete) throws Exception{
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"delete from member where member_id = ? ");
		st.setString(1, delete.getMember_id());
		
		int line = st.executeUpdate();
		
		st.close();
		con.close();
		return line;
	}
	
	public MemberBean registerSearch(MemberBean regs) throws Exception{
		Connection con = getConnection();
		MemberBean r = null;
		PreparedStatement st = con.prepareStatement(
				"select * from member where "
				+ "last_name = ? "
				+ "and first_name = ? "
				+ "and sex = ? "
				+ "and birth_year = ? "
				+ "and birth_month = ? "
				+ "and birth_day = ? "
				+ "and job = ? "
				+ "and phone_number = ? "
				+ "and mail_address = ? " );
	
		st.setString(1, regs.getLast_name());
		st.setString(2, regs.getFirst_name());
		st.setString(3, regs.getSex());
		st.setInt(4, regs.getBirth_year());
		st.setInt(5, regs.getBirth_month());
		st.setInt(6, regs.getBirth_day());
		st.setString(7, regs.getJob());
		st.setString(8, regs.getPhone_number());
		st.setString(9, regs.getMail_address());
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			r= new MemberBean();
		}
		
		st.close();
		con.close();
		return r;
	}

}
