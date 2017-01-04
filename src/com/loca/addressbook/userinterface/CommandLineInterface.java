package com.loca.addressbook.userinterface;

import com.loca.addressbook.Application;
import com.loca.addressbook.registry.Registry;
import com.loca.addressbook.remoteregistry.RemoteRegistry;
import com.loca.addressbook.userinterface.commands.Command;
import com.loca.addressbook.exceptions.InvalidCommandException;
import com.loca.addressbook.exceptions.InvalidCommandParameterException;

public class CommandLineInterface implements InputHandler {

    private static final String WELCOME_MESSAGE = "Welcome to AddressBook 2.0!";
	private Console systemConsole;
	private CommandInterpreter commandInterpreter;

	public CommandLineInterface(Registry registry, RemoteRegistry remoteRegistry, Console systemConsole, Application application) {
	    systemConsole.registerInputHandler(this);
	    this.commandInterpreter = new CommandInterpreter((ConsolePrinter)systemConsole, registry, remoteRegistry, application);
	    this.systemConsole = systemConsole;

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
