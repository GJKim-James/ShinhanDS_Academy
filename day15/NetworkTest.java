package com.shinhan.day15;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class NetworkTest {

	public static void main(String[] args) throws UnknownHostException {
		f1();
	}

	private static void f1() throws UnknownHostException {
		// InetAddress : 자바에서 IP 주소 얻기
		InetAddress localIp = InetAddress.getLocalHost();
		System.out.println("내 컴퓨터 IP : " + localIp);
		System.out.println("----------------------------------------");
		
		// getAllByName() : DNS에서 도메인 이름으로 등록된 모든 IP 주소를 배열로 가져온다.
		InetAddress[] arr = InetAddress.getAllByName("www.naver.com");
		Arrays.stream(arr).forEach(addr -> System.out.println(addr));
	}

}
