package com.hanbit.member.domain;


// 	MemberBean은 콩알이 들어가는 콩깍지와 같다!
//	property를 정의하는 Bean
public class MemberBean {

		private String id, pw, ssn, name, regdate;
		
	
		public String getRegdate() {
			return regdate;
		}


		public void setRegdate(String regdate) {
			this.regdate = regdate;
		}


		public String getId() {
			return id;
		}


		public void setId(String id) {
			this.id = id;
		}


		public String getPw() {
			return pw;
		}


		public void setPw(String pw) {
			this.pw = pw;
		}


		public String getSsn() {
			return ssn;
		}


		public void setSsn(String ssn) {
			this.ssn = ssn;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return String.format("MemberBean [id= %s / pw= %s / ssn= %s / name= %s / regdate= %s ] \n",id, pw, ssn, name, regdate );
		}


	
}