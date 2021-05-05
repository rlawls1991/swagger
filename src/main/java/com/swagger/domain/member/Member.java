package com.swagger.domain.member;


import com.swagger.domain.member.dto.MemberParamDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    private Long memberId;
    private String name;
    private String nickname;
    private String password;
    private String phone;
    private String email;
    private LocalDateTime createDt; // 생성일시
    private LocalDateTime updateDt; // 수정일시

    @Builder(buildMethodName = "mockMvcBuilder")
    private Member(Long memberId, String name, String nickname, String password, String phone, String email) {
        this.memberId = memberId;
        this.name = name;
        this.nickname = nickname;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.createDt = LocalDateTime.now();
    }

    public Member(String name, String nickname, String password, String phone, String email) {
        this.name = name;
        this.nickname = nickname;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }

    public void updateMember(final MemberParamDto paramDto) {
        this.name = paramDto.getName();
        this.nickname = paramDto.getNickname();
        this.password = paramDto.getPassword();
        this.phone = paramDto.getPhone();
        this.email = paramDto.getEmail();
        this.updateDt = LocalDateTime.now();
    }

    public static Member createMember(final MemberParamDto paramDto) {
        return new Member(paramDto.getName(), paramDto.getNickname(), paramDto.getPassword(), paramDto.getPhone(), paramDto.getEmail());
    }
}
