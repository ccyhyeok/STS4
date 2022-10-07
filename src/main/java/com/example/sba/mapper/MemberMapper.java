package com.example.sba.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.sba.domain.Member;

public interface MemberMapper {

	@Select("select * from MEMBER where EMAIL=#{email}")
	public Member getLoginInfo(@Param("email")String email)throws Exception;
	
	@Select("select * from MEMBER limit 100")
	public List<Member> getMemberList() throws Exception;
	
	@Select("select * from MEMBER where EMAIL=#{email} AND PWD=#{pwd}")
	public Member getLoginMember(@Param("email")String email, @Param("pwd")String pwd) throws Exception;
}
