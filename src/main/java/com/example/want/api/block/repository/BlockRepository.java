package com.example.want.api.block.repository;
import com.example.want.api.block.domain.Block;
import com.example.want.api.block.domain.Category;
import com.example.want.api.member.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.time.LocalDateTime;


@Repository
public interface BlockRepository extends JpaRepository<Block, Long> {
    Page<Block> findByIsActivatedOrderByHeartCountDesc(String isActivated, Pageable pageable);
    // 선택한 일자의 일정만 조회
    Page<Block> findAllByStartTimeBetweenOrderByStartTimeAsc(LocalDateTime localDateTime, LocalDateTime localDateTime1, Pageable pageable);
    // 카테고리 별 블럭 조회
    Page<Block> findByCategory(Category category, Pageable pageable);

    Page<Block> findAllByIsActivatedOrderByStartTimeAsc(@Param("isActivated") String Y, Pageable pageable);
    Page<Block> findAllByIsActivatedOrderByHeartCountDesc (@Param("isActivated") String N, Pageable pageable);

    Page<Block> findAllByIsActivated(String n, Pageable pageable);
}
