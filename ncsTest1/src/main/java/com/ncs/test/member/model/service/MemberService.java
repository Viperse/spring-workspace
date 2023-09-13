package com.ncs.test.member.model.service;

import org.springframework.stereotype.Service;

import com.ncs.test.member.model.vo.Member;

public interface MemberService {
	
	public Member loginMember(Member vo);

}
