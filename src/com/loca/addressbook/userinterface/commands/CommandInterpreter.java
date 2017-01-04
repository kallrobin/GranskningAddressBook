package com.loca.addressbook.userinterface.commands;

import com.loca.addressbook.exceptions.InvalidCommandException;
import com.loca.addressbook.userinterface.CommandLine;

/**
 * @author Christopher Olsson on 2017-01-04.
 */
public interface CommandInterpreter {

    Command interpret(CommandLine commandLine) throws InvalidCommandException;
}
