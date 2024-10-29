package com.firstzone.dept;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DeptDTO {
	
	int dept_id;
	String dept_name;
	int manager_id;
	int location_id;

}
