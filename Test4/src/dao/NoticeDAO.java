package dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.kh.notice.model.vo.NoticeVO;

public class NoticeDAO {

	public ArrayList<NoticeVO> noticeAllList(SqlSession session) {
		
		int result = session.insert("mybatis.insertMember", mOne);

		ArrayList<NoticeVO> nlist = session.selectList("mybatis.selectAllNotice");

		return nlist;

	}

}
