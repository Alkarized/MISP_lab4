package se.mspi.lab4.commands;

import se.mspi.lab4.utils.Invoker;

public class HistoryCommand extends Command{
    public HistoryCommand() {
        super("history", "- вывести все точки");
    }

    @Override
    public void execute(String args, Invoker invoker) {
        invoker.getHistory().forEach(System.out::println);
    }
}
