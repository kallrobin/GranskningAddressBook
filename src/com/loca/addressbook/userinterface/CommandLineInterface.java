package com.loca.addressbook.userinterface;

import com.loca.addressbook.exceptions.InvalidCommandException;
import com.loca.addressbook.exceptions.InvalidCommandParameterException;
import com.loca.addressbook.userinterface.commands.Command;
import com.loca.addressbook.userinterface.commands.CommandInterpreter;

public class CommandLineInterface implements InputHandler {

    private static final String WELCOME_MESSAGE = "Welcome to AddressBook 2.0!";
    private Console systemConsole;
    private CommandInterpreter commandInterpreter;

    public CommandLineInterface(CommandInterpreter commandInterpreter, SystemConsole systemConsole) {
        this.commandInterpreter = commandInterpreter;
        this.systemConsole = systemConsole;
        this.systemConsole.registerInputHandler(this);

    }

    public void start() {
        systemConsole.print(WELCOME_MESSAGE);
        systemConsole.readUserInput();
    }

    @Override
    public void handle(CommandLine commandLine) {
        try {
            Command command = commandInterpreter.interpret(commandLine);
            command.execute();
        } catch (InvalidCommandException | InvalidCommandParameterException e) {
            systemConsole.print(e.getMessage());
        }

    }

}
