package servlet.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import servlet.model.dao.MemberRepository;
import servlet.model.vo.MemberDTO;

//DAO - Service - Controller : Service는 DAO와 Controller의 중간역할
public class MemberService {
	
	private MemberRepository repo = new MemberRepository();
	
	public ArrayList<MemberDTO> showAllMember() throws SQLException {
		return repo.showAllMember();
	}
	
}
