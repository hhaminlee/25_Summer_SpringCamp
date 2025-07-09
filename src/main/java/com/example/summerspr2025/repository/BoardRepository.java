package com.example.summerspr2025.repository;

import com.example.summerspr2025.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// jpa repository의 첫번째 제네릭은 사용하는 엔티티, 두번째는 id의 타입
public interface BoardRepository extends JpaRepository<Board, Long> {
}
