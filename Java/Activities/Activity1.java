package Activities;

public class Activity1 {
    public static void main(String[] args) {
        Car carName = new Car();
        carName.make = 2014;
        carName.color = "Black";
        carName.transmission = "Manual";
        carName.displayCharacterstic();
        carName.accelerate();
        carName.brake();
    }
}

 class Car{
    String color;
    String transmission;
    int make;
    int tyres;
    int doors;

    Car(){
        tyres = 4;
        doors = 4;
    }
    public void displayCharacterstic(){
        System.out.println("Tyres:"+tyres);
        System.out.println("Doors:"+doors);
        System.out.println("Color:"+color);
        System.out.println("Make:"+make);
        System.out.println("Transmission:"+transmission);

    }

    public void accelerate(){
        System.out.println("Car moving forward");
    }

    public void brake(){
        System.out.println("Car stopped");
    }



}
