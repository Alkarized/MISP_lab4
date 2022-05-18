package se.mspi.lab4.commands;

import se.mspi.lab4.utils.Invoker;

public class ExitCommand extends Command{
    public ExitCommand() {
        super("exit", "- выйти из программы");
    }

    @Override
    public void execute(String args, Invoker invoker) {
        System.exit(0);
    }
}
