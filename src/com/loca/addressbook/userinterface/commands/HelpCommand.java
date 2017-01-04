package com.loca.addressbook.userinterface.commands;

import com.loca.addressbook.exceptions.InvalidCommandParameterException;
import com.loca.addressbook.userinterface.ConsolePrinter;
import com.sun.org.apache.bcel.internal.generic.NEW;

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
        String helpText;
        helpText = "Add" + TAB + TAB + "Adds a contact to the local addressbook" + NEW_LINE +
                "Delete" + TAB + "Deletes a contact with the given UUID" + NEW_LINE +
                "Search" + TAB + "Search for contacts by \"Starts With\"" + NEW_LINE +
                "List" + TAB + "Lists all the contacts" + NEW_LINE +
                "Help" + TAB + "Lists the help menu" + NEW_LINE +
                "Quit" + TAB + "Quits the application.";
        return helpText;
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
