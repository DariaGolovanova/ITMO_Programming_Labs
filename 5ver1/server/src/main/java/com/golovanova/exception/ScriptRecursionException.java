package com.golovanova.exception;

public class ScriptRecursionException extends Exception {
    public ScriptRecursionException(String message) {
        super(message);
    }

    public ScriptRecursionException(String message, Throwable cause) {
        super(message, cause);
    }
}
