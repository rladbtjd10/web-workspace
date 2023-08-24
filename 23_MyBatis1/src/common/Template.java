package common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	
	//마이바티스 설정파일을 불러오고, 'SqlSessionFactory'를 빌드하고, 새로운 'SqlSession'을 열어 'SqlSession' 인스턴스의 생성을 캡슐화한다.
	//이 디자인 패턴은 데이터베이스 연결 및 세션 생성 설정을 중앙 집중화하여 응용 프로그램 전체에서 코드 재사용성과 일관성을 높입니다.
	
	public static SqlSession getSqlSession() {
		SqlSession session = null;
		
		// 해당 리소스 경로(xml파일) 작성
		String resource = "/mybatis-config.xml";
		
		
		try {
			// 해당 리소스 경로(xml파일)로 input 스트림 생성
			InputStream stream = Resources.getResourceAsStream(resource);
			
			// SqlSessionFactory를 만들 수 있는 팩토리 빌더 생성
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			// 팩토리 빌드를 가지고 실제 사용할 SqlSessionFactory 생성
			SqlSessionFactory factory = builder.build(stream);
			
			// SqlSessionFactory를 가지고 sqlSession 생성(false값은 autoCommit을 안한다는 뜻)
			session = factory.openSession(false); //false auto커밋여부를 말하는거
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 생성된 SqlSession 리턴
		return session; 
		
	
	}

}
