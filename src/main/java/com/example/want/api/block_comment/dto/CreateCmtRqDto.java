package com.example.want.api.block_comment.dto;

import com.example.want.api.block.domain.Block;
import com.example.want.api.block_comment.domain.Cmt;
import com.example.want.api.member.domain.Member;
import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCmtRqDto {
//    private Long memberId;
    private Long blockId;
    private String contents;


    public Cmt toEntity(Member member, Block block){
        return Cmt.builder()
                .member(member)
                .contents(this.contents)
                .block(block)
                .build();
    }

}
