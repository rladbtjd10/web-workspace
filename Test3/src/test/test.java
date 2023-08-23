package test;

public class test {


//	public class Template {
//	public static SqlSession getSqlSession() {
//	SqlSession session = null;
//	String resource="/mybatis-config.xml";
//
//	try {
//	InputStream stream = Resources.getResourceAsStream(resource);
//
//	SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder ();
//	SqlSessionFactory factory = builder.build(stream);
//
//	session = factory.openSession(false);
//	} catch(IOException e){
//	e.printStackTrace();
//	}
//
//	return session;
//	}
//	}
//	------------
//	package member.model.service;
//
//	import java.util.Arrays;
//	import java.util.List;
//
//	import org.apache.ibatis.session.SqlSession;
//
//	import common.SqlSessionTemplate;
//	import member.model.dao.MemberDAO;
//	import member.model.vo.MemberVO;
//
//	// DAO - Service - Controller
//	public class MemberService {
//
//		public int registerMember(MemberVO vo) {
//			SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
//			int result = MemberDAO.getInstance().registerMember(sqlSession, vo);
//			
//			if(result > 0) sqlSession.commit(); //insert,delete,update 데이터 변경될때만 필요함 
//			sqlSession.close();
//			
//			return result;
//		}
//		
//		// showAllMember, findByIdMember, login, updateMember
//		
//		public List<MemberVO> showAllMember() {
//			SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
//			List<MemberVO> list = MemberDAO.getInstance().showAllMember(sqlSession);
//			
//			sqlSession.close();
//			
//			return list; 
//		}
//		
//		public List<MemberVO> findByIdMember(String[] idList) {
//			SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
//			List<String> list = Arrays.asList(idList);
//			List<MemberVO> member = MemberDAO.getInstance().findByIdMember(sqlSession, list);
//			
//			sqlSession.close();
//			
//			return member;
//		}
//		
//		public MemberVO login(MemberVO vo) {
//			SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
//			MemberVO member = MemberDAO.getInstance().login(sqlSession, vo);
//			
//			sqlSession.close();
//			
//			return member;
//		}
//		
//		public int updateMember(MemberVO vo) {
//			SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
//			int result = MemberDAO.getInstance().updateMember(sqlSession, vo);
//			
//			if(result > 0) sqlSession.commit();
//			sqlSession.close();
//			
//			return result;
//		}
//		
//	}
//
//
//
//}
