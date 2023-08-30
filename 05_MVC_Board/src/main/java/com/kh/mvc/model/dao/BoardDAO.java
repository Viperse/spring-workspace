package com.kh.mvc.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.mvc.model.vo.Board;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate session;
	
	public int insertBoard(Board board) {
		return session.insert("board.insert", board);
	}
	
	public List<Board> selectAllBoard() {
		return session.selectList("board.selectAll");
	}
	
	public Board selectBoard(int no) {
		return session.selectOne("board.select", no);
	}
	
	public int updateBoard(Board board) {
		return session.update("board.update", board);
	}
	
	public int deleteBoard(int no) {
		return session.delete("board.delete", no);
	}

}
