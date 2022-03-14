package com.golovanova.exceptions;

public class WorkerNotFoundException extends Exception {
    public WorkerNotFoundException() {
    }

    public WorkerNotFoundException(String message) {
        super(message);
    }

    public WorkerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public WorkerNotFoundException(Throwable cause) {
        super(cause);
    }
}
