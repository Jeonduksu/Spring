package com.mvc.upgrade.model.dto;

public class MemberDto {
	private int memberno;
	private String memberid;
	private String memberpw;
	private String memebername;
	public MemberDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberDto(int memberno, String memberid, String memberpw, String memebername) {
		super();
		this.memberno = memberno;
		this.memberid = memberid;
		this.memberpw = memberpw;
		this.memebername = memebername;
	}
	public int getMemberno() {
		return memberno;
	}
	public void setMemberno(int memberno) {
		this.memberno = memberno;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getMemberpw() {
		return memberpw;
	}
	public void setMemberpw(String memberpw) {
		this.memberpw = memberpw;
	}
	public String getMemebername() {
		return memebername;
	}
	public void setMemebername(String memebername) {
		this.memebername = memebername;
	}
	@Override
	public String toString() {
		return "MemberDto [memberno=" + memberno + ", memberid=" + memberid + ", memberpw=" + memberpw
				+ ", memebername=" + memebername + "]";
	}
	
	
}
