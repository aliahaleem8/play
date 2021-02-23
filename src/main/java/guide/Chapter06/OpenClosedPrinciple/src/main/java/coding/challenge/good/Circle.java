package guide.Chapter06.OpenClosedPrinciple.src.main.java.coding.challenge.good;

public class Circle implements Shape {

    private final int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }
}
