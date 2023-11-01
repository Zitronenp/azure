package org.example.command;

import java.util.ArrayList;
import java.util.List;

public class CommandList {
    private final List<Command> commands = new ArrayList<>();

    public CommandList() {
        commands.add(new StartCommand());
        commands.add(new HelpCommand());
        commands.add(new WeatherCommand());
    }

    public List<Command> getCommands() {
        return commands;
    }
}
