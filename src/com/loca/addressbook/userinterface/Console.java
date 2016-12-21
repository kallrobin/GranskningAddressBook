package com.loca.addressbook.userinterface;

import com.loca.addressbook.exceptions.QuitApplicationException;

import java.util.Scanner;

public class Console implements ConsolePrinter {

	private InputHandler inputHandler;
	private boolean isQuit = false;
 
    public void registerInputHandler(InputHandler inputHandler) {
    	this.inputHandler = inputHandler;
    	readUserInput();
    }
 
    private void readUserInput() {
        Scanner scanner = new Scanner(System.in);
		while (!isQuit) {
			String userInput = scanner.nextLine();
			CommandLine commandLine = CommandLine.parse(userInput);
            inputHandler.handle(commandLine);
		}
		scanner.close();
	}

    @Override
    public void print(String output) {
        System.out.println(output);
    }

    public void close() {
        isQuit = true;
    }

}
