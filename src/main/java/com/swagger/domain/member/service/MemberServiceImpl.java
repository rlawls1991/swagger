package com.swagger.domain.member.service;


import com.swagger.domain.member.Member;
import com.swagger.domain.member.dto.MemberDto;
import com.swagger.domain.member.dto.MemberParamDto;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    @Override
    public MemberDto createMember(final MemberParamDto dto) {
        Member member = Member.createMember(dto);

        return MemberDto.createMemberDto(member);
    }

    @Override
    public MemberDto findByMember(final Long memberId) {
        Member member = Member.builder()
                .memberId(memberId)
                .mockMvcBuilder();

        return MemberDto.createMemberDto(member);
    }

    @Override
    public MemberDto updateMember(Long memberId, MemberParamDto dto) {
        Member member = Member.builder()
                .memberId(memberId)
                .mockMvcBuilder();
        member.updateMember(dto);

        return MemberDto.createMemberDto(member);
    }
}
