package kr.co.seoulit.member.sf;

import java.util.List;

import kr.co.seoulit.member.dao.MemberDAOImpl;
import kr.co.seoulit.member.to.MemberBean;

public interface MemberServiceFacade {
	public List<MemberBean> getMemberList();
	public MemberBean getMember(String id);
	public void addMember(MemberBean member);

	public void removeMember(String id) ;

	public void updateMember(MemberBean member);
}

