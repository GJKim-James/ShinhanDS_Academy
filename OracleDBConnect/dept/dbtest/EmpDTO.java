package com.firstzone.dbtest;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// DTO : Data Transfer Object
// VO : Value Object
@Getter
@Setter
@ToString
@Builder // 추가 시 @NoArgsConstructor, @AllArgsConstructor 이것도 필요
@NoArgsConstructor
@AllArgsConstructor
public class EmpDTO {
	
	int employee_id;
	String first_name;
	String last_name;
	String email;
	String phone_number;
	Date hire_date;
	String job_id;
	double salary;
	double commission_pct;
	int manager_id;
	int department_id;

}
