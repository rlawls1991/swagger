package com.swagger.domain.member.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberOrderDto {
    private Long memberId;
    private String name;
    private String nickname;
    private String phone;
    private String email;
    private LocalDateTime createDt;
    private LocalDateTime updateDt;
    private Long orderId;
    private String orderNum;
    private String productName;
    private OrderStatusEnum orderStatus;
    private LocalDateTime paymentDt;
}
