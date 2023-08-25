
public class test {
	
	ojdbc.jar, mybatis-3.x.x.jar, WEB-INF/lib 폴더 아래 복사
	<?xml version="1.0" encoding="UTF-8"?>
	<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://mybatis.org/dtd/mybat<<is-3-config.dtd" >
	<configuration>
	<!-- 별칭 등록 -->
	<typeAliases>
	<typeAlias type="org.kh.member.model.vo.MemberVO" alias="member"/>
	</typeAliases>
	<environments default="development">
	<environment id="development">
	<transactionManager type="JDBC"/>
	<dataSource type="POOLED">
	<property name="driver" value="oracle.jdbc.driver.OracleDriver"/>
	<property name="url" value="jdbc:oracle:thin:@127.0.0.1:1521:xe"/>
	<property name="username" value="MYBATIS"/>
	<property name="password" value="MYBATIS"/>
	</dataSource>
	</environment>
	</environments>
	<!-- 회원정보(member)에서 사용될 Mapper 파일 등록 -->
	<mappers>
	<mapper resource="mapper/member/member-mapper.xml"/>
	</mappers>
	</configuration>
	public class SqlSessionTemplate {
	public static SqlSession getSqlSession() {
	SqlSession session = null;
	String resource = "mybatis-config.xml";
	try {
	// 해당 리소스 경로(xml파일)로 input 스트림 생성
	InputStream is = Resources.getResourceAsStream(resource);
	// SqlSessionFactory를 만들 수 있는 팩토리 빌더 생성
	SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
	// 팩토리 빌드를 가지고 실제 사용할 SqlSessionFactory 생성
	SqlSessionFactory factory = builder.build(is);
	// SqlSessionFactory를 가지고 sqlSession 생성(false값은 autoCommit을 안한다는 뜻)
	session = factory.openSession(false);
	} catch (IOException e) {
	e.printStackTrace();
	}
	return session; // 생성된 SqlSession 리턴
	}
	}
	<?xml version="1.0" encoding="UTF-8"?>
	<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
	<mapper namespace="mybatis">
	<insert id="insertMember" parameterType="member">
	INSERT INTO MEMBER VALUES (SEQ_MEMBER.NEXTVAL, #{userId}, #{userPw}, #{userName}, #{userAddr}, DEFAULT)
	</insert>
	</mapper>
	public class MemberServiceImpl{
	MemberDAOLogic memberDAO = new MemberDAOLogic();
	public int insertMember(MemberVO mOne) {
	SqlSession session = SqlSessionTemplate.getSqlSession();
	int result = memberDAO.insertMember(session, mOne);
	if(result>0) {
	session.commit();
	}else {
	session.rollback();
	}
	session.close();
	return result;
	}
	}
	public class MemberDAO {
	public int insertMember(SqlSession session, MemberVO mOne) {
	int result = session.insert("mybatis.insertMember", mOne);
	System.out.println("member@MemberDAO="+result);
	return result;
	}
	}

}
