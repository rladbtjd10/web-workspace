package Service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.kh.notice.model.vo.NoticeVO;

import Template.SqlSessionTemplate;
import dao.NoticeDAO;

public class NoticeServiceImpl{
	
	NoticeDAO dao = new NoticeDAO();

	public ArrayList<NoticeVO> noticeAllList() {
		
		SqlSession session = SqlSessionTemplate.getSqlSession();

		ArrayList<NoticeVO> nList = dao.noticeAllList(session);
		
		if(nList!=null) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return nList;

	}

}
