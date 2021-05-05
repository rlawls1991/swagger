package com.swagger.domain.member.service;


import com.swagger.domain.member.dto.MemberDto;
import com.swagger.domain.member.dto.MemberParamDto;

public interface MemberService {

    /**
     * 회원 가입
     *
     * @param memberParamDto
     * @return
     */
    MemberDto createMember(final MemberParamDto memberParamDto);

    /**
     * 회원 찾기
     *
     * @return
     */
    MemberDto findByMember(final Long id);

    /**
     * 회원 정보 수정
     *
     * @param id
     * @param memberParamDto
     * @return
     */
    MemberDto updateMember(final Long id, MemberParamDto memberParamDto);
}
