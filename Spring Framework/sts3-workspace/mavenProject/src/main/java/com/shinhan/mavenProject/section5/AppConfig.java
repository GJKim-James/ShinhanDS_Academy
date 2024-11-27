package com.shinhan.mavenProject.section5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.shinhan.mavenProject.section4.CarVO;

// section4까지는 XML 설정을 통해서 Bean 생성
// section5에서는 자바 소스를 이용해서 Bean 생성

@Configuration // 설정 파일이다.
@ComponentScan // 이 파일을 scan 할 수 있다.
public class AppConfig {
	
	@Bean // <bean id="getCar"></bean>
	public CarVO getCar() {
		return new CarVO("ABC", 1000, "black");
	}

}
