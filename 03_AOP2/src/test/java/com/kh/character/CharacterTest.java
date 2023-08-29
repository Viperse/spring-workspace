package com.kh.character;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CharacterTest {
	
	@Autowired(required=false) // 빈 등록 후 끌어 쓸 수 있는 애노테이션 코드
	private Character character;
	
	@Test
	void test() {}
	
	@Test
	void create() {
		// assertThat은 자바용 단언문 라이브러리 isNotNull이나 contains 같은 리턴이 true false로 나오는 검증을 사용하기 위해 사용하는 검증 메소드
		assertThat(character).isNotNull();
		assertThat(character.getWeapon()).isNotNull();
	}
	
	@Test
	void questTest() throws Exception {
		assertThat(character.quest("비 오는데 나가서 텐동 먹기")).contains("텐동");
	}
	
	@Test
	void attackTest() throws Exception {
		assertThat(character.getWeapon().attack()).isNotNull();
	}
	
}
