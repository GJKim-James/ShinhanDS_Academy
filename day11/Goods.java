package com.shinhan.day11;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class Goods<K, M> {
	
	K kind;
	M model;

}
