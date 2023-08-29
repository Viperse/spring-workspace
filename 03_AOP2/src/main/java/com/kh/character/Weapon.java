package com.kh.character;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // 생성자
@AllArgsConstructor // 차 있는 생성자
public abstract class Weapon {
	protected String name;
	public abstract String attack() throws Exception;
}
