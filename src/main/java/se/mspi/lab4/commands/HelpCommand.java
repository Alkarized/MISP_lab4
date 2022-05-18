package se.mspi.lab4.commands;

import se.mspi.lab4.utils.Invoker;

import java.util.Map;

public class HelpCommand extends Command {
    public HelpCommand() {
        super("help", "- справка по командам программы");
    }

    @Override
    public void execute(String args, Invoker invoker) {
        Map<String, Command> commandMap = invoker.getCommandMap();
        System.out.println("Команды:");
        int index = 1;
        for (Map.Entry<String, Command> entry : commandMap.entrySet()) {
            System.out.println((index++) + ". " + entry.getValue().getFullHelpLine());
        }
    }
}
