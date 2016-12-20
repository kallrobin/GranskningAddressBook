package com.loca.addressbook.userinterface.commands;

public enum CommandType {
	
	ADD(	"add",		3,	"Add a new contact",		"Added the new contact.",	"Add contact failed!"),
	DELETE(	"delete",	1,	"Delete a contact",			"Deleted the contact.",		"Delete failed! Could not find any matching ID in local address book."),
	LIST(	"list",		0,	"List all contacts",		"Listed all contacts.",		"List failed! The contact list is empty."),
	SEARCH(	"search",	1,	"Search for contacts",		"Showed search result.",	"Search failed! Could not find any matching contact."),
	HELP(	"help",		0,	"Show help information",	"Showed help information.",	"Help request failed!"),
	QUIT(	"quit",		0,	"Quit program",				"Quitting...",				"Quit request failed");
	
	private String commandText;
	private String description;
	private int argumentCount;
	private String successMessage;
	private String failureMessage;
	
	private CommandType(String commandText, int argumentCount, String helpText, String successMessage, String failMessage) {
		this.commandText = commandText;
		this.argumentCount = argumentCount;
		this.description = helpText;
		this.successMessage = successMessage;
		this.failureMessage = failMessage;
	}
	
	public String getCommandText() {
		return commandText;
	}
	
	public int getArgumentCount() {
		return argumentCount;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getSuccessMessage() {
		return successMessage;
	}

	public String getFailureMessage() {
		return failureMessage;
	}
	
}
