package Service;

import org.apache.ibatis.session.SqlSession;
import org.kh.member.model.vo.MemberVO;

import Template.SqlSessionTemplate;

public class MemberServiceImpl {
	
	MemberDAO dao = new MemberDAO();
	
	public int insertMember(MemberVO mOne) {
		
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = dao.insetMember(session, mOne);
		
	}
}



