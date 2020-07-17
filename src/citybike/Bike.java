package citybike;


import java.util.HashMap;

public class Bike {
    static String colors[] = {"blue", "pink", "white", "red"};
    static State states[] = {State.CanBeRented,State.CanNotBeRented,State.InService,State.Discarded};
    int bikeID;
    String color;
    State state;
    static int bikeIdCounter;
    public Bike(String color, State state) {
        this.bikeID = bikeIdCounter;
        bikeIdCounter++;
        this.color = color;
        this.state = state;
    }
    public static Bike generateRandomBike(){
        int colorIndex = (int) (Math.random() * colors.length);
        String color = colors[colorIndex];
        int stateIndex = (int) (Math.random() * states.length);
        State state = states[stateIndex];
        Bike bike = new Bike (color, state);
        return bike;
    }
    public static void main(String[]args) {
        HashMap bikes = new HashMap<Integer, Bike>();
        Bike.bikeIdCounter= 0;
        for(int i=0;i<9; i++){
            Bike bike = generateRandomBike();
            bikes.put(bike.bikeID,bike);
            bike.print();


        }


    }
    public void print(){
        System.out.println(this.bikeID+ " "+ this.color+ " " + this.state);
    }
}

enum State{
    CanBeRented, CanNotBeRented, InService, Discarded
}