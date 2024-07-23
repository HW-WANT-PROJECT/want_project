package com.example.want.api.block.controller;

import com.example.want.api.block.domain.Block;
import com.example.want.api.block.dto.BlockActiveListRsDto;
import com.example.want.api.block.dto.BlockDetailRsDto;
import com.example.want.api.block.dto.CreatBlockRqDto;
import com.example.want.api.block.service.BlockService;
import com.example.want.common.CommonResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/block")
public class BlockController {
    private final BlockService blockService;

    @PostMapping("/create")
    public ResponseEntity<Object> createBlock(@RequestBody CreatBlockRqDto request) {
        Block block = blockService.createBlock(request);
        return new ResponseEntity<>(new CommonResDto(HttpStatus.OK, "Success", block), HttpStatus.OK);
    }

    @GetMapping("/dis/active/list")
    public ResponseEntity<Object> getNotActiveBlockList(@PageableDefault(size = 10) Pageable pageable) {
        Page<BlockActiveListRsDto> blockList = blockService.getNotActiveBlockList(pageable);
        return new ResponseEntity<>(new CommonResDto(HttpStatus.OK, "Success", blockList), HttpStatus.OK);
    }

    @GetMapping("/active/list")
    public ResponseEntity<Object> getBlockList(@PageableDefault(size = 10) Pageable pageable) {
        Page<BlockActiveListRsDto> blockList = blockService.getActiveBlockList(pageable);
        return new ResponseEntity<>(new CommonResDto(HttpStatus.OK, "Success", blockList), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Object> getBlock(@PathVariable Long id) {
        BlockDetailRsDto block = blockService.getBlockDetail(id);
        return new ResponseEntity<>(new CommonResDto(HttpStatus.OK, "Success", block), HttpStatus.OK);
    }
}