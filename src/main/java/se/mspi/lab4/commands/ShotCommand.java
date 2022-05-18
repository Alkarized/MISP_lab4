package se.mspi.lab4.commands;

import se.mspi.lab4.utils.Invoker;
import se.mspi.lab4.objects.Shot;

public class ShotCommand extends Command {
    public ShotCommand() {
        super("shot", "X Y R - выстрелить в область радиуса R по координатам X,Y");
    }

    @Override
    public void execute(String args, Invoker invoker) {
        String[] s = args.trim().split(" ");
        if (s.length < 3) {
            System.out.println("Недостаточно аргументов (должно быть 3, получено " + s.length + ")");
            return;
        }
        try {
            int x = Integer.parseInt(s[0]);
            float y = Float.parseFloat(s[1]);
            float r = Float.parseFloat(s[2]);

            Shot shot = invoker.getHitChecker().shoot(x, y, r);

            invoker.getShotCounterMBean().addShot(shot.isSuccessful());
            invoker.getSquareCalculatorMBean().calculateSquare(r);

            invoker.getHistory().add(shot);

            System.out.println(shot);

        } catch (NumberFormatException e) {
            System.out.println("Аргументы должны быть числами");
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
