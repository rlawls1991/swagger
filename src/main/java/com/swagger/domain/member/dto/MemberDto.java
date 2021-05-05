package com.swagger.domain.member.dto;


import com.swagger.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto {
    private Long memberId;
    private String name;
    private String nickname;
    private String phone;
    private String email;
    private LocalDateTime createDt;
    private LocalDateTime updateDt;

    public static MemberDto createMemberDto(final Member member) {
        return new MemberDto(member.getMemberId(), member.getName(), member.getNickname(), member.getPhone(), member.getEmail(), member.getCreateDt(), member.getUpdateDt());
    }
}
