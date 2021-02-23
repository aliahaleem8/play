package guide.Chapter06.MethodHiding.src.main.java.coding.challenge;

public class Car extends Vehicle {
    
    // this method hides Vehicle#move()
    public static void move() {
        System.out.println("Moving a car");
    }
}
