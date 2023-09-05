package com.kh.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kh.api.model.Phone;
import com.kh.api.service.PhoneServiceImpl;

@RestController
public class PhoneController {
	
	@Autowired
	private PhoneServiceImpl service;
	
	@GetMapping("/phone")
	public ResponseEntity select() {
		// phone 전체 리스트
		List<Phone> list = service.select();
		return new ResponseEntity(list, HttpStatus.OK); // 상태 코드를 보낼 수 있음 ex. 성공했을 때 200
	}
	
	@GetMapping("/phone/{num}")
	public ResponseEntity select(@PathVariable String num) {
		Phone phone = service.select(num);
		if(phone != null) {
			return new ResponseEntity("컨텐츠가 없습니다.", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity(phone, HttpStatus.OK); // 컨텐츠가 없을 때
	}
	
	@PostMapping("/phone")
	public ResponseEntity insert(@RequestBody Phone phone) {
		service.insert(phone);
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/phone")
	public ResponseEntity update(@RequestBody Phone phone) {
		service.update(phone);
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/phone/{num}")
	public ResponseEntity delete(@PathVariable String num) {
		service.delete(num);
		return new ResponseEntity(HttpStatus.OK);
	}
}
