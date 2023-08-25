package Service;

import java.lang.reflect.Member;

import org.apache.ibatis.session.SqlSession;
import org.kh.member.model.vo.MemberVO;

import Template.SqlSessionTemplate;
import dao.MemberDAO;

public class MemberServiceImpl{
	
	MemberDAO dao = new MemberDAO();
	
public int insertMember(MemberVO mOne) {
	
	SqlSession session = SqlSessionTemplate.getSqlSession();
	
	
	int result = dao.insertMember(session, mOne);
	if(result>0) {
		session.commit();
	} else {
		session.rollback();
	}
	
	session.close();
	return result;
	
}
}



