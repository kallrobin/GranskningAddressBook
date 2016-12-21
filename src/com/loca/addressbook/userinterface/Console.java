package com.loca.addressbook.userinterface;

import java.util.Scanner;

public class Console implements ConsolePrinter {
	
	private InputHandler inputHandler;
 
    public void registerInputHandler(InputHandler inputHandler) {
    	this.inputHandler = inputHandler;
    	readUserInput();
    }
 
    private void readUserInput() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			String userInput = scanner.nextLine();
			CommandLine commandLine = CommandLine.parse(userInput);
			inputHandler.handle(commandLine);
			// How do we handle quit?
		}
		scanner.close();
	}

    @Override
    public void print(String output) {
        System.out.println(output);
    }

}
