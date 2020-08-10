package citybike;

enum BikeState {
    CanBeRented, CanNotBeRented, InService, Discarded;
}
public class Bike {

    private static Integer newBikeId = 0;
    Integer bikeID;
    String color;
    Bike bike;

    BikeState state = BikeState.CanBeRented;


    @Override
    public String toString() {
        return
                " bikeID= " + bikeID +
                ", color='" + color + '\'' +
                ", state=" + state ;
    }

    public Bike (String color) {

        this.color = color;

        this.bikeID = newBikeId;

        newBikeId++;





    }}