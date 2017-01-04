package com.loca.addressbook.userinterface.commands;

import com.loca.addressbook.exceptions.InvalidCommandParameterException;

import java.util.List;

public class CommandValidator {

    public static void validate(List<String> parameters, CommandType commandType) throws InvalidCommandParameterException {
        if (parameters.size() != commandType.getParametersCount()) {
            throw new InvalidCommandParameterException(commandType, parameters);
        }
    }
}
