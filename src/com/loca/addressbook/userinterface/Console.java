package com.loca.addressbook.userinterface;

/**
 * @author Christopher Olsson on 2017-01-04.
 */
public interface Console {

    void registerInputHandler(InputHandler inputHandler);

    void print(String output);

    void readUserInput();

    void notifyInputHandler(CommandLine commandLine);
}
