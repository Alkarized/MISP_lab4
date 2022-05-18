package se.mspi.lab4.mbeans;

public class SquareCalculator implements SquareCalculatorMBean{
    private double square;

    @Override
    public void calculateSquare(float r) {
//        double triangleSquare = r * r/4;
//        double rectangleSquare = r * r;
//        double circleSquare = Math.PI * Math.pow(r, 2) / 4;

        square = r*r/4 + r*r/2 + Math.PI * r * r / 4;
    }

    @Override
    public double getSquare() {
        return square;
    }
}
