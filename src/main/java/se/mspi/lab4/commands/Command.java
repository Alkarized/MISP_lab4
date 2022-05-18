package se.mspi.lab4.commands;

import se.mspi.lab4.utils.Invoker;

public abstract class Command {
    protected final String name;
    protected final String helpText;

    public Command(String name, String helpText) {
        this.name = name;
        this.helpText = helpText;
    }

    public abstract void execute(String args, Invoker invoker);

    public String getFullHelpLine() {
        return name + " " + helpText;
    }

    public String getName() {
        return name;
    }

}
