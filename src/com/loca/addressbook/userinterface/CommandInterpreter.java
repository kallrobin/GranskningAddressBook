package com.loca.addressbook.userinterface;

import com.loca.addressbook.Application;
import com.loca.addressbook.registry.Registry;
import com.loca.addressbook.remoteregistry.RemoteRegistry;
import com.loca.addressbook.userinterface.commands.*;
import com.loca.addressbook.exceptions.InvalidCommandException;

import java.util.List;

public class CommandInterpreter {

    private Registry registry;
    private RemoteRegistry remoteRegistry;
    private ConsolePrinter consolePrinter;
    private Application application;

    public CommandInterpreter(ConsolePrinter consolePrinter, Registry registry, RemoteRegistry remoteRegistry, Application application) {
        this.registry = registry;
        this.remoteRegistry = remoteRegistry;
        this.consolePrinter = consolePrinter;
        this.application = application;
    }

    public Command interpret(CommandLine commandLine) throws InvalidCommandException {

        String command = commandLine.getCommand();
        Command returnCommand;

        switch (command) {
            case "add":
                returnCommand = new AddContactCommand(consolePrinter, registry, commandLine.getParameters());
                break;
            case "delete":
                returnCommand = new DeleteContactCommand(consolePrinter, registry, commandLine.getParameters());
                break;
            case "list":
                returnCommand = new ListCommand(consolePrinter, registry, remoteRegistry, commandLine.getParameters());
                break;
            case "search":
                returnCommand = new SearchCommand(consolePrinter, registry, remoteRegistry, commandLine.getParameters());
                break;
            case "quit":
                returnCommand = new QuitCommand(consolePrinter, commandLine.getParameters(), application);
                break;
            case "help":
                returnCommand = new HelpCommand(consolePrinter, commandLine.getParameters());
                break;
            default:
                throw new InvalidCommandException(command + " is not a valid command");
        }
        return returnCommand;
    }


}
