package com.loca.addressbook.userinterface.commands;

import java.util.List;

import com.loca.addressbook.registry.Registry;
import com.loca.addressbook.userinterface.exceptions.InvalidCommandParameterException;

public class AddContactCommand implements Command {
	
	private static final int REQUIRED_PARAMETERS_COUNT = 3;
	CommandType commandType = CommandType.ADD;
	Registry registry;
	List<String> parameters;
	
	public AddContactCommand (Registry registry, List<String> parameters) {
		this.registry = registry;
		this.parameters = parameters;
	}
	
    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void execute() throws InvalidCommandParameterException {
    	if (parameters.size() != REQUIRED_PARAMETERS_COUNT) {
    		throw new InvalidCommandParameterException();
    	}
    	addContactToRegistry();
    }

	private void addContactToRegistry() {
		String firstName = parameters.get(0);
    	String lastName = parameters.get(1);
    	String email = parameters.get(2);
    	registry.addContact(firstName, lastName, email);
	}
    
}
