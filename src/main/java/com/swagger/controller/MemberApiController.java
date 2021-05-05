package com.swagger.controller;

import com.swagger.domain.member.dto.MemberDto;
import com.swagger.domain.member.dto.MemberParamDto;
import com.swagger.domain.member.service.MemberService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "테스트 용도 API")
@RestController
@RequestMapping(value = "/api/member", consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    /**
     * 회원 가입
     *
     * @param memberParamDto
     * @return
     */
    @PostMapping
    @ApiOperation(value ="회원생성", notes = "회원가입하는 API 입니다.")
    public ResponseEntity createMember(@Valid @RequestBody MemberParamDto memberParamDto) {
        MemberDto saveMember = memberService.createMember(memberParamDto);
        return new ResponseEntity<>(saveMember, HttpStatus.OK);
    }

    /**
     * 회원 조회
     *
     * @param memberId
     * @return
     */
    @GetMapping("/{memberId}")
    @ApiOperation(value ="회원조회", notes = "회원조회하는 API 입니다.")
    public ResponseEntity getMember(@PathVariable Long memberId) {
        MemberDto member = memberService.findByMember(memberId);

        if (member == null) {
            return ResponseEntity.notFound().build();
        }


        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    /**
     * 회원 정보 수정
     *
     * @param memberId
     * @param memberParamDto
     * @return
     */
    @PutMapping("/{memberId}")
    @ApiOperation(value ="회원수정", notes = "회원수정하는 API 입니다.")
    public ResponseEntity updateMember(@PathVariable Long memberId,
                                       @RequestBody @Valid MemberParamDto memberParamDto) {

        MemberDto member = memberService.findByMember(memberId);
        if (member == null) {
            return ResponseEntity.notFound().build();
        }

        MemberDto updateMember = memberService.updateMember(memberId, memberParamDto);

        return new ResponseEntity<>(updateMember, HttpStatus.OK);
    }

    /**
     * 회원 정보 삭제
     *
     * @param memberId
     * @return
     */
    @DeleteMapping("/{memberId}")
    @ApiOperation(value ="회원삭제", notes = "회원삭하는 API 입니다.")
    public ResponseEntity deleteMember(@PathVariable Long memberId) {
        MemberDto member = memberService.findByMember(memberId);
        if (member == null) {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(memberId, HttpStatus.OK);
    }

}