package se.mspi.lab4.utils;

import se.mspi.lab4.objects.Shot;

import java.util.Arrays;

import static java.lang.Math.pow;

public class HitChecker {
    public Shot shoot(int x, float y, float r) throws IllegalArgumentException {
        checkCorrect(x, y, r);
        boolean result = (x <= 0 && y <= 0 && y >= (float) (-x / 2) - r / 2) ||
                (x >= 0 && y >= 0 && pow(x, 2) + pow(y, 2) <= pow(r, 2)) ||
                (x <= 0 && y >= 0 && y <= r / 2 && x <= -r);
        return new Shot(x, y, r, result);
    }

    private void checkCorrect(int x, float y, float r) throws IllegalArgumentException {
        int[] x_arr = {-5, -4, -3, -2, -1, 0, 1, 2, 3};
        if (Arrays.stream(x_arr).noneMatch(e -> e == x)) {
            throw new IllegalArgumentException("Неправильное значение x");
        }
        if (-3 >= y || y >= 5) {
            throw new IllegalArgumentException("Неправильное значение y");
        }
        if (1 >= r || r >= 4) {
            throw new IllegalArgumentException("Неправильное значение r");
        }
    }
}
