package com.example.summerspr2025.service;

import com.example.summerspr2025.dto.BoardDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public interface BoardService {
    BoardDto.CreateResDto create(BoardDto.CreateReqDto param);
    BoardDto.UpdateResDto update(BoardDto.UpdateReqDto param);
    Map<String, Object> delete(BoardDto.DeleteReqDto param);
    BoardDto.DetailResDto detail(long id);
    List<BoardDto.ListResDto> list();
}
