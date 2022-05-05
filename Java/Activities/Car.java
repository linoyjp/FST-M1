package activities;

public class Car {
    String color;
    String transmission;
    int make;
    int tyres;
    int doors;

    //constructor
    public Car() {
        tyres=4;
        doors=4;
    }

    public void displayCharacteristics(){
        System.out.println("Color of car: " +  color);
        System.out.println("transmission of car: " +  transmission);
        System.out.println("make of car: " +  make);
        System.out.println("tyres of car: " +  tyres);
        System.out.println("No of doors: " +  doors);
    }
    public void accelerate(){
        System.out.println("Car is moving forward");
    }
    public void brake(){
        System.out.println("Car has stopped");
    }
}
