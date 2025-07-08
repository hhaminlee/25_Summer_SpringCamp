package com.example.summerspr2025.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public interface PostService {
    Map<String, Object> create(Map<String, Object> param);
    Map<String, Object> update(Map<String, Object> param);
    Map<String, Object> delete(int id);
    Map<String, Object> detail(int id);
    List<Map<String, Object>> list();
}
