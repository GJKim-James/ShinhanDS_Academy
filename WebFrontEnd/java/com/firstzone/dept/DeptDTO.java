package com.firstzone.dept;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DeptDTO {
	
	int dept_id;
	String dept_name;
	int manager_id;
	int location_id;

}
