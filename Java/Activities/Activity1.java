package activities;

public class Activity1 {
    public static void main(String[] args) {
        Car Honda = new Car();

        //Add values to variables
        Honda.make=2014;
        Honda.color = "black";
        Honda.transmission = "Manual";

        Honda.displayCharacteristics();
        Honda.accelerate();
        Honda.brake();
    }
}
