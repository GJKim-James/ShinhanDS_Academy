package com.shinhan.day10.exercise;

import java.io.IOException;

// 11장 확인문제 8번
public class FileWriterExample {

	public static void main(String[] args) throws Exception {
//		FileWriter fw = null;
//		
//		try {
//			fw = new FileWriter("file.txt");
//			fw.write("Java");
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				fw.close();
//			} catch (IOException e) {
//				
//			}
//		}

		System.out.println("---------- 개선(자동으로 자원 반납) ----------");
		try (FileWriter fw = new FileWriter("file.txt")) {
			fw.write("Java");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("---------- 진짜 파일 저장 ----------");
		try (FileWriter writer = new FileWriter("myfile.txt")) {
			writer.write("파일에 문자를 저장하기1\n");
			writer.write("파일에 문자를 저장하기2\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
