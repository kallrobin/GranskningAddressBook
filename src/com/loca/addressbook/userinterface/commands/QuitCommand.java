package com.loca.addressbook.userinterface.commands;

import com.loca.addressbook.Application;
import com.loca.addressbook.exceptions.InvalidCommandParameterException;
import com.loca.addressbook.userinterface.ConsolePrinter;

import java.util.List;

public class QuitCommand implements Command {

    private CommandType commandType = CommandType.QUIT;
    private Application application;
    private List<String> parameters;
    private ConsolePrinter consolePrinter;

    public QuitCommand(ConsolePrinter consolePrinter, List<String> parameters, Application application) {
        this.parameters = parameters;
        this.consolePrinter = consolePrinter;
        this.application = application;
    }

    @Override
    public void execute() throws InvalidCommandParameterException {
        validate();
        consolePrinter.print(commandType.getSuccessMessage());
        application.quit();
    }

    private void validate() throws InvalidCommandParameterException {
        if (parameters.size() != 0) {
            throw new InvalidCommandParameterException(parameters.size(), 0);
        }
    }
}
