package com.loca.addressbook.userinterface;

import java.util.ArrayList;
import java.util.List;

public class CommandLine {
    private String command;
    private List<String> parameters = new ArrayList<>();

    public CommandLine(String command, List<String> parameters) {
        this.command = command;
        this.parameters = parameters;
    }

    public String getCommand() {
        return command;
    }

    public List<String> getParameters() {
        return parameters;
    }
}
