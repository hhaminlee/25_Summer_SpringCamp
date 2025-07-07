package com.example.summerspr2025.service;

import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public interface BoardService {
    Map<String, Object> create(Map<String, Object> param);
    Map<String, Object> update(Map<String, Object> param);
    Map<String, Object> delete(int id);
    Map<String, Object> detail(int id);
    Map<String, Object> list();
}
