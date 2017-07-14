package com.hanbit.member.dao;

import java.util.List;

import com.hanbit.member.domain.MemberBean;


public interface MemberDAO {
		public int insert(MemberBean member);			
		public List<MemberBean> selectAll();					
		public int countMembers();							
		public MemberBean selectById(String id);	
		public List<MemberBean> selectByName(String name); 
		public int update(MemberBean bean);
		public int delete(String id);	
}