package com.loca.addressbook.exceptions;

public class InvalidCommandParameterException extends Exception {
    private static final String QUOTATION_MARK = "\"";

    public InvalidCommandParameterException(int actual, int expected) {
        super("Command Line failed! Received " + actual + " parameters while expecting " + expected + " parameters.");
    }
}