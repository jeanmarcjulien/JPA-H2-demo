package com.example.demo;

class Calculator {
    CloudService service;

    public Calculator(CloudService service) {
        this.service = service;
    }

    public int perform(int i, int j) throws Exception {
        return service.add(i, j) * i;
    }
}