package se.mspi.lab4.utils;

import se.mspi.lab4.objects.Shot;
import se.mspi.lab4.commands.*;
import se.mspi.lab4.mbeans.ShotCounterMBean;
import se.mspi.lab4.mbeans.ShotCounter;
import se.mspi.lab4.mbeans.SquareCalculator;

import javax.management.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Invoker {
    private final Map<String, Command> commandMap = new HashMap<>();
    private final HitChecker hitChecker = new HitChecker();
    private final ArrayList<Shot> history  = new ArrayList<>();

    // MBeans
    private final ShotCounterMBean shotCounterMBean = new ShotCounter();
    private final SquareCalculator squareCalculatorMBean = new SquareCalculator();

    private void initCommands(){
        addCommands(
                new ExitCommand(),
                new HelpCommand(),
                new ShotCommand(),
                new HistoryCommand()
        );
    }

    private void addCommands(Command... commands) {
        for (Command command : commands) {
            commandMap.put(command.getName(), command);
        }
    }

    private void initMBeans() {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        try {
            mbs.registerMBean(shotCounterMBean, new ObjectName("se.mspi.lab4.mbeans:type=ShotCounter"));
            mbs.registerMBean(squareCalculatorMBean, new ObjectName("se.mspi.lab4.mbeans:type=SquareCalculator"));
        } catch (JMException e) {
            e.printStackTrace();
        }
    }

    private void typeStartMessage(){
        System.out.println("Здравствуй, дорогой пользователь!");
        System.out.println("Для того что бы увидеть весь список команд введите help");
    }

    private void openImage(){
        try {
            File f = new File("src/main/java/se/mspi/lab4/resources/areas.png");
            Desktop dt = Desktop.getDesktop();
            dt.open(f);
        } catch (Exception e) {
            System.err.println("Не удалось открыть картинку, файл не найден, но ты не унывай, так потыкайся))");
        }
    }

    public void start() {
        initCommands();
        initMBeans(); //add  commands
        typeStartMessage();
        openImage();
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print("> ");
            input = scanner.nextLine();
            if (input.trim().length() == 0) continue;
            parseAndExecute(input.trim());
        }
    }

    public void parseAndExecute(String input) {
        String[] s = input.split(" ");
        String key = s[0];
        String args = input.substring(s[0].length());
        Command command = commandMap.get(key);
        if (command != null) command.execute(args, this);
        else System.out.println("Такой команды нет, список команд: help");
    }

    public Map<String, Command> getCommandMap() {
        return commandMap;
    }

    public HitChecker getHitChecker() {
        return hitChecker;
    }

    public ArrayList<Shot> getHistory() {
        return history;
    }

    public ShotCounterMBean getShotCounterMBean() {
        return shotCounterMBean;
    }

    public SquareCalculator getSquareCalculatorMBean() {
        return squareCalculatorMBean;
    }


}
