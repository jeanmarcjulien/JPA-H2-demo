package com.example.demo;

import java.util.concurrent.TimeUnit;


class CloudServiceImpl implements CloudService {
    @Override
    public int add(int i, int j) throws InterruptedException {
        TimeUnit.SECONDS.sleep(20);
        return i + j;
    }
}