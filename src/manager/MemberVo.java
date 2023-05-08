package manager;

import java.util.Date;

public class MemberVo {
	private int num;
	private String memberId;
	private String memberPw;
	private String nickname;
	private Date regdate; //java.util.Date
	
	public MemberVo() {}
	
	public MemberVo(int num, String memberId, String memberPw, String nickname) {
		super();
		this.num = num;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.nickname = nickname;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "MemberVo [num=" + num + ", memberId=" + memberId + ", memberPw=" + memberPw + ", nickname=" + nickname
				+ ", redate=" + regdate + "]";
	}
		
}
