package com.example.want.api.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AcceptInvitationDto {
    private Long projectId;
    private String action;  // "Y" or "N"
//    private String invitationCode;
}
