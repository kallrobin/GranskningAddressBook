package com.loca.addressbook.exceptions;

public class InvalidCommandException extends Exception {
    private static final String QUOTATION_MARK = "\"";

    public InvalidCommandException (String command) {
        super("Command Line failed! Input command " + QUOTATION_MARK + command + QUOTATION_MARK + " is not a valid command type.");
    }

}
