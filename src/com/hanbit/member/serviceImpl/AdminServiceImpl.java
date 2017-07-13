package com.hanbit.member.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.hanbit.member.dao.MemberDAO;
import com.hanbit.member.daoImpl.MemberDAOImpl;
import com.hanbit.member.domain.MemberBean;
import com.hanbit.member.service.AdminService;

public class AdminServiceImpl implements AdminService{
	MemberBean member;
	List<MemberBean> list;
	
	public AdminServiceImpl(){
		member = new MemberBean();
		list = new ArrayList<>();
	}
	@Override
	public void addMember(MemberBean member) {
		list.add(member);
	}
	
	@Override
	public List<MemberBean> list() {
		return list;
	}
	
	@Override
	public int countMembers() {
		return list.size();
	}

	@Override
	public MemberBean findById(String id) {
		MemberBean member = new MemberBean();
		MemberDAO dao = new MemberDAOImpl();
		member = dao.selectById(id);
		return member;
	}

	@Override
	public List<MemberBean> findByName(String name) {
		List<MemberBean> members = new ArrayList<>();
		int count=0;
		for(MemberBean m: list){
			if(name.equals(m.getName())){
				count++;
			}
		}
		
		for(MemberBean m:list){
			if(name.equals(m.getName())){
				members.add(m);
				if(count==members.size()){
					break;
				}
			}
		}
		return members;
	}

	@Override
	public void modify(MemberBean bean) {
	//	findById(bean.getId()).setPw(bean.getPw());
		
		for(MemberBean m: list){
			if(bean.getId().equals(m.getId())){
				
				if(!bean.getPw().equals("")){
						m.setPw(bean.getPw());
					}
				if(!bean.getName().equals("")){
						m.setName(bean.getName());
					}
				if(!bean.getSsn().equals("")){
						m.setSsn(bean.getSsn());
					}
			}
		}
	}

	@Override
	public void remove(String id) {
		for(MemberBean m: list){
			if(id.equals(m.getId())){
			list.remove(m);
			}
		}
	}
}
