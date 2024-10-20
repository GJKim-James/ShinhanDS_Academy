package com.shinhan.day13.exercise;

import java.util.List;

// 15장 확인문제 7번
public class ListExample {

	public static void main(String[] args) {
		BoardDao dao = new BoardDao();
		
		List<Board> list = dao.getBoardList();
		
		for (Board board : list) {
			System.out.println(board.getTitle() + "-" + board.getContent());
		}
	}

}
