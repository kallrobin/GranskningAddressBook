package com.loca.addressbook.userinterface;

import java.util.Scanner;

public class SystemConsole implements Console, ConsolePrinter {

	private InputHandler inputHandler;


	@Override
    public void registerInputHandler(InputHandler inputHandler) {
    	this.inputHandler = inputHandler;
    }

    public void readUserInput() {
        Scanner scanner = new Scanner(System.in);
		while (true) {
			String userInput = scanner.nextLine();
			CommandLine commandLine = CommandLine.parse(userInput);
            notifyInputHandler(commandLine);
		}
	}

    @Override
    public void print(String output) {
        System.out.println(output);
    }

    @Override
    public void notifyInputHandler(CommandLine commandLine) {
        inputHandler.handle(commandLine);
    }

}
