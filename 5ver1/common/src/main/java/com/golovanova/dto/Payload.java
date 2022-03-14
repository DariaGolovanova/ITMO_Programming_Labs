package com.golovanova.dto;

import com.golovanova.model.Worker;

import java.util.List;

public class Payload {
    private Worker worker;

    public Payload(Worker worker) {
        this.worker = worker;
    }

    public Worker getWorker() {
        return worker;
    }
}
