package com.hanbit.member.daoImpl;

import com.hanbit.member.constants.Database;
import com.hanbit.member.dao.MemberDAO;
import com.hanbit.member.domain.MemberBean;
import java.sql.*;					//0번
import java.util.List;
public class MemberDAOImpl implements MemberDAO{
	
	
	@Override
	public void insert(MemberBean member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MemberBean> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countMembers() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberBean selectById(String id) {
		MemberBean member = new MemberBean();
		try {
			Class.forName(Database.DRIVER);
			Connection conn = DriverManager.getConnection(Database.URL,Database.USERID,Database.PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM Member WHERE id = '"+id+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setPw(rs.getString("pw"));
				member.setRegdate(rs.getString("regdate"));
				member.setSsn(rs.getString("ssn"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}

	@Override
	public List<MemberBean> selectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(MemberBean bean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	
	
}
