package com.loca.addressbook.userinterface;

public interface Command {
	
	String getName();
	String getDescription();
	void execute() throws InvalidCommandParameterException;

}