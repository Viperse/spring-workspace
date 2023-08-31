package com.kh.mvc;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.mvc.model.vo.Board;
import com.kh.mvc.model.vo.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MyBatisUnitTest {
	
	public SqlSession getSession() {
		try {
			Reader r = Resources.getResourceAsReader("mybatis-config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
			return factory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	

//	@Test
//	public void insertTest() {
//		SqlSession session = getSession();
//		
//		Board board = new Board();
//		board.setTitle("똥쟁이 예진이의 하루");
//		board.setContent("즐겁다");
//		board.setWriter("김예진");
//		
//		System.out.println("db before :: " + board.getNo());
//		
//		int result = session.insert("board.insert", board);
//		
//		if(result > 0) {
//			System.out.println(result + "개 게시글 추가");
//			session.commit();
//		}
//		
//		System.out.println("db after :: " + board.getNo());
//		
//		System.out.println("==========================================");
//	}
	
	@Test
	public void selectAllTest() {
		SqlSession session = getSession();
		
		Criteria cri = new Criteria();
		cri.setPage(10);
		List<Board> list = session.selectList("board.selectAll", cri);
		System.out.println(list);
		System.out.println(list.size());
		
		System.out.println("==========================================");
	}
	
	@Test
	public void selectTest() {
		SqlSession session = getSession();
		
		Board board = session.selectOne("board.select", 10);
		System.out.println(board);
		System.out.println("==========================================");
	}
	
	@Test
	public void updatetest() {
		SqlSession session = getSession();
		Board board = new Board();
		board.setNo(10);
		board.setTitle("딩동댕 유치원");
		board.setContent("모여라 딩동댕!");
		
		int result = session.update("board.update", board);
		if(result > 0) {
			System.out.println(result + "개 게시글 수정!");
			session.commit();
		}
	}
	
	@Test
	public void deleteTest() {
		SqlSession session = getSession();
		int result = session.delete("board.delete", 1);
		if (result > 0) {
			System.out.println(result + "개 게시글 삭제!");
			session.commit();
		}
	}

}
