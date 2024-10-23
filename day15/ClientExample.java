package com.shinhan.day15;

import java.io.IOException;
import java.net.Socket;

public class ClientExample {

	public static void main(String[] args) {
		// Socket 생성과 동시에 localhost의 50002 Port로 연결 요청
		try {
			Socket socket = new Socket("localhost", 50002); // localhost : 192.168.0.11
			System.out.println("[클라이언트] 연결 성공");
			
			// Socket 닫기
			socket.close();
			System.out.println("[클라이언트] 연결 끊음");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
