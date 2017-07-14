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
	public String addMember(MemberBean member) {
		MemberDAO dao = new MemberDAOImpl();
		/*int rs = dao.insert(member);
		if(rs==1){
			msg = "등록 성공!!";
		}else{
			msg = "등록 실패!!";
		*/
		return (dao.insert(member)==1)? "등록 성공!!": "등록 실패!!";
	}
	
	@Override
	public List<MemberBean> list() {
		return new MemberDAOImpl().selectAll();
	}
	
	@Override
	public int countMembers() {
		return new MemberDAOImpl().countMembers();
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
		return new MemberDAOImpl().selectByName(name);
	}

	@Override
	public String modify(MemberBean bean) {
	//	findById(bean.getId()).setPw(bean.getPw());
		String msg = null;
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
		return msg;
	}

	@Override
	public String remove(String id) {
		String msg = null;
		for(MemberBean m: list){
			if(id.equals(m.getId())){
			list.remove(m);
			}
		}
		return msg;
	}
}
