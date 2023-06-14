package com.powernode.bank.exceptions;

public class FailureException extends Exception {
    public FailureException() {
    }

    public FailureException(String msg) {
        super(msg);
    }
}
