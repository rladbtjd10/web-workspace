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
		
		String resource = "/mybatis-config.xml";
		
		
		try {
			InputStream stream = Resources.getResourceAsStream(resource);
			
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = builder.build(stream);
			
			session = factory.openSession(false); //false auto커밋여부를 말하는거
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return session;
		
	
	}

}
