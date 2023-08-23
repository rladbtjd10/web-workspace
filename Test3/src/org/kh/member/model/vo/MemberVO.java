package org.kh.member.model.vo;

public class MemberVO {
	private int UserNo;
	private String UserId;
	private String UserPw;
	private String UserName;
	private String UserAddr;
	private String RegDate;
	
	public MemberVO() {}

	public MemberVO(int userNo, String userId, String userPw, String userName, String userAddr, String regDate) {
		UserNo = userNo;
		UserId = userId;
		UserPw = userPw;
		UserName = userName;
		UserAddr = userAddr;
		RegDate = regDate;
	}

	public int getUserNo() {
		return UserNo;
	}

	public void setUserNo(int userNo) {
		UserNo = userNo;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getUserPw() {
		return UserPw;
	}

	public void setUserPw(String userPw) {
		UserPw = userPw;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getUserAddr() {
		return UserAddr;
	}

	public void setUserAddr(String userAddr) {
		UserAddr = userAddr;
	}

	public String getRegDate() {
		return RegDate;
	}

	public void setRegDate(String regDate) {
		RegDate = regDate;
	}

	@Override
	public String toString() {
		return "MemberVO [UserNo=" + UserNo + ", UserId=" + UserId + ", UserPw=" + UserPw + ", UserName=" + UserName
				+ ", UserAddr=" + UserAddr + ", RegDate=" + RegDate + "]";
	}
	
	
	
	
	
	
	
	
}
