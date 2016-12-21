package com.loca.addressbook.userinterface.commands;

import com.loca.addressbook.exceptions.InvalidCommandParameterException;

public interface Command {

	void execute() throws InvalidCommandParameterException;

}