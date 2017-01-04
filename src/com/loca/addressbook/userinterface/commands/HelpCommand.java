package com.loca.addressbook.userinterface.commands;

import com.loca.addressbook.exceptions.InvalidCommandParameterException;
import com.loca.addressbook.userinterface.ConsolePrinter;

import java.util.List;

public class HelpCommand implements Command {
    private static final String NEW_LINE = "\n";
    private static final String TAB = "\t";
    private List<String> parameters;
    private ConsolePrinter consolePrinter;

    public HelpCommand (ConsolePrinter consolePrinter, List<String> parameters) {
        this.parameters = parameters;
        this.consolePrinter = consolePrinter;
    }

    @Override
    public void execute() throws InvalidCommandParameterException {
        validate();
        String helpText = makeHelpText();
        showHelpText(helpText);

    }

    private String makeHelpText() {
        StringBuilder helpText = new StringBuilder(100);
        for (CommandType commandType: CommandType.values()) {
            helpText.append(commandType.getCommandName());
            helpText.append(TAB);
            helpText.append(commandType.getDescription());
            helpText.append(NEW_LINE);
        }
        return helpText.toString();
    }


    private void showHelpText(String helpText) {
        consolePrinter.print(helpText);
    }

    private void validate() throws InvalidCommandParameterException {
        if (parameters.size() != 0) {
            throw new InvalidCommandParameterException(parameters.size(), 0);
        }
    }

}
