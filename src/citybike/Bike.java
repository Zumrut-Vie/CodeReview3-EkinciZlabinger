package citybike;

import java.util.HashMap;

public class Bike {
    int bikeId;
    static int bikeIdCounter;
    String color;
    String state;
    static String colors[] = {"blue", "pink", "white", "red"};
    static String states[] = {"CanBeRented", "CanNotBeRented", "InService", "Discarded"};

    //Constructor

    public Bike(String color, String state) {
        this.bikeId = bikeIdCounter;
        bikeIdCounter++;
        this.color = color;
        this.state = state;
    }
    //Generate new bikes
    public static Bike generateRandomBike(){
        int colorIndex = (int) (Math.random() * colors.length);
        String color = colors[colorIndex];
        int stateIndex = (int) (Math.random() * states.length);
        String state = states[stateIndex];
        Bike bike = new Bike (color, state);
        return bike;
    }
    //Hashmap for bikes
    public static void main(String[] args) {
        HashMap bikes = new HashMap<Integer, Bike>();
        Bike.bikeIdCounter = 0;

        for(int i = 0; i<9; i++){
            Bike bike = generateRandomBike();
            bikes.put(bike.bikeId, bike);
            bike.print();
        }

    }
    //Print
    public void print(){
        System.out.println(this.bikeId + " " + this.color + " " + this.state);
        System.out.println("***************************************************");
    }
}
