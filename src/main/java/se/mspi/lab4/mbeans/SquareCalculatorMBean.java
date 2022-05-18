package se.mspi.lab4.mbeans;

/*
MBean, определяющий площадь получившейся фигуры.
 */
public interface SquareCalculatorMBean {
    void calculateSquare(float r);
    double getSquare();
}
