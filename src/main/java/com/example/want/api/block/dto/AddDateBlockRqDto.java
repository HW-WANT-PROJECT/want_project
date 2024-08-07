package com.example.want.api.block.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddDateBlockRqDto {
    private Long blockId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
