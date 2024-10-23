package com.shinhan.day15;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {

	public static void main(String[] args) throws IOException {
		// ServerSocket 생성 및 Port 바인딩
		ServerSocket serverSocket = new ServerSocket(50002);
		System.out.println("[서버] 시작됨");
		
		// 대기하다가 클라이언트가 오면 연결 수락
		Socket socket = serverSocket.accept();
		
		// 연결된 클라이언트 정보 얻기
		// InetAddress > InetSocketAddress
		InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
		System.out.println("[서버] " + isa.getHostName() + "의 연결 요청을 수락함");
	}

}
