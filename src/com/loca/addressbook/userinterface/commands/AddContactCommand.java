package com.loca.addressbook.userinterface.commands;

import java.util.List;

import com.loca.addressbook.registry.Registry;
import com.loca.addressbook.userinterface.ConsolePrinter;
import com.loca.addressbook.exceptions.InvalidCommandParameterException;

public class AddContactCommand implements Command {


	private Registry registry;
	private List<String> parameters;
	private ConsolePrinter consolePrinter;
	
	public AddContactCommand (ConsolePrinter consolePrinter, Registry registry, List<String> parameters) {
	    this.consolePrinter = consolePrinter;
		this.registry = registry;
		this.parameters = parameters;
	}

    @Override
    public void execute() throws InvalidCommandParameterException {
    	validate();
    	addContactToRegistry();
    }

	private void addContactToRegistry() {
		String firstName = parameters.get(0);
    	String lastName = parameters.get(1);
    	String email = parameters.get(2);
    	registry.addContact(firstName, lastName, email);
    	consolePrinter.print("Added the new contact.");
	}

	private void validate() throws InvalidCommandParameterException {
		if (parameters.size() != 3) {
			throw new InvalidCommandParameterException(parameters.size(), 3);
		}
	}
    
}
