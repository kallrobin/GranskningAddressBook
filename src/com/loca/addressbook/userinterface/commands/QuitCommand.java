package com.loca.addressbook.userinterface.commands;

import com.loca.addressbook.exceptions.InvalidCommandParameterException;
import com.loca.addressbook.exceptions.QuitApplicationException;
import com.loca.addressbook.userinterface.ConsolePrinter;

import java.util.List;

public class QuitCommand implements Command {

    private CommandType commandType = CommandType.QUIT;
    private List<String> parameters;
    private ConsolePrinter consolePrinter;

    public QuitCommand(ConsolePrinter consolePrinter, List<String> parameters) {
        this.parameters = parameters;
        this.consolePrinter = consolePrinter;
    }

    @Override
    public void execute() throws InvalidCommandParameterException {
        if (parameters.size() != commandType.getArgumentCount()) {
            throw new InvalidCommandParameterException();
        }
        consolePrinter.print(commandType.getSuccessMessage());
        throw new QuitApplicationException();
    }
}
