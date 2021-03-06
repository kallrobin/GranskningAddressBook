package com.loca.addressbook;

import java.util.ArrayList;
import java.util.List;

import com.loca.addressbook.registry.AutoSave;
import com.loca.addressbook.registry.Registry;
import com.loca.addressbook.registry.RegistryPersister;
import com.loca.addressbook.remoteregistry.CatalogueLoader;
import com.loca.addressbook.remoteregistry.RemoteRegistry;
import com.loca.addressbook.userinterface.*;

public class Application {

    public static void main(String[] args) {
        Application application = new Application();
        application.start();
    }
	
	private static final String HOSTNAME_1 = "172.20.200.247";
	private static final String HOSTNAME_2 = "172.20.200.173";
	private static final String HOSTNAME_3 = "172.20.201.62";
    private SystemConsole systemConsole = new SystemConsole();
    private Registry registry = new Registry();
    private RegistryPersister registryPersister = new RegistryPersister(registry);
    private AutoSave autoSave = new AutoSave(registryPersister);
    private RemoteRegistry remoteRegistry = new RemoteRegistry();
    private CatalogueLoader catalogueLoader = new CatalogueLoader(remoteRegistry, makeHostNames());
    private CommandInterpreterImplementation commandInterpreter = new CommandInterpreterImplementation((ConsolePrinter)systemConsole, registry, remoteRegistry, this);
	private CommandLineInterface commandLineInterface = new CommandLineInterface(commandInterpreter, systemConsole);

    public void start() {
    	initiateLocalContacts();
		catalogueLoader.start();
		autoSave.start();
		commandLineInterface.start();
    }

	private void initiateLocalContacts() {
        registryPersister.load();
	}

	
	private List<String> makeHostNames() {
		List<String> hostNames = new ArrayList<>();
		hostNames.add(HOSTNAME_1);
		hostNames.add(HOSTNAME_2);
		hostNames.add(HOSTNAME_3);
		return hostNames;
	}
	 
	public void quit() {
		registryPersister.save();
		System.exit(0);
	}
		
}
