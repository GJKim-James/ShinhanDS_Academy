# 신한DS 금융 SW 아카데미
- 교육 기간 : 2024. 09. 25. 수 ~ 2025. 03. 25. 화
  #### Java
- 교재 : '이것이 자바다', 한빛미디어, 신용권·임경균 지음 (2024. 09. 25. 수 ~ 2024. 10. 31. 목)
- day*/LAB* : 배운 것들 관련한 문제 풀이한 것
- day*/exercise : '이것이 자바다' 각 장마다의 확인문제 풀이
- jdbcproject : JDBC 개인 프로젝트(축구 경기 신청 프로그램)
  #### Web Front-End
- 교재 : 'Do it! HTML+CSS+자바스크립트 웹 표준의 정석 (한 권으로 끝내는 웹 기본 교과서)', 이지스퍼블리싱, 고경희 지음 (2024. 10. 31. 목 ~ 2024. 11. 14. 목)
- WebFrontEnd/webapp/example : 교재 각 장마다의 되새김 문제 풀이
  #### JSP/Servlet
- 교재 : '자바 웹을 다루는 기술', 길벗, 이병승 지음 (2024. 11. 14. 목 ~ 2024. 11. 25. 월)
- matchservletproject : Servlet Web 개인 프로젝트(축구 경기 신청 프로그램)
- webShop : JSP/Servlet 수업
  #### Spring Framework
- 교재 : '자바 웹을 다루는 기술', 길벗, 이병승 지음 (2024. 11. 26. 화 ~ 2024. 12. 05. 목)
- 개발 환경
  - Java 11(JDK 11); 이전까지 17 버전 사용
  - IDE : STS3(Spring Tool Suite 3)
  - Server : Apache Tomcat 9.0
- STS3 기본 환경 설정
1. JDK 설치 (install/openjdk)
2. 환경변수 JAVA_HOME 수정
3. 롬복(lombok.jar) 설치 (STS.exe 있는 경로)
4. sts.ini에 추가
    - -vm
    - C:\shinhan4\install\openjdk\openjdk-11.0.25\bin\javaw.exe
7. STS 실행
8. Spring Legacy Project를 생성...실패...STS 닫기
9. C:\shinhan4\work\sts3-workspace\.metadata\.plugins\org.springsource.ide.eclipse.commons.content.core 경로에 https-content.xml 파일 넣기
10. Project > Properties > Project Facets 자바 버전 11로 설정
11. Tomcat 설정
12. STS 실행 Spring Legacy Project를 생성
