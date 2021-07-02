package com.example.demo;

import org.springframework.stereotype.Service;

@Service
interface CloudService {
    public int add(int i, int j) throws Exception;
}