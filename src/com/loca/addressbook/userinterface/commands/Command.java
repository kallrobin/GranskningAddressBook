package com.loca.addressbook.userinterface.commands;

import com.loca.addressbook.userinterface.exceptions.InvalidCommandParameterException;

public interface Command {
	
	String getName();
	String getDescription();
	void execute() throws InvalidCommandParameterException;

}