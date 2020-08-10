package citybike;

import java.util.HashMap;

public class Station {

    private static Integer newStationId = 0;
    Integer stationID;
    String location;
    HashMap<Integer,Bike> bikes = new HashMap<>();
    private int maxNumberOfBikes = 5;

    public Station (String location) {
        this.location = location;
        this.stationID = newStationId;
        newStationId++;
    }

    public void addBike(Bike bike) {
        bikes.put(bike.bikeID, bike);
    }

    public void rentBikeFromStation(User user4) {

        Bike firstBike = bikes.entrySet().stream().findFirst().get().getValue();
        if (firstBike != null && firstBike.state == BikeState.CanBeRented) {
            firstBike.state = BikeState.InService;
            user4.currentlyRentedBike = firstBike;
            bikes.remove(bikes.entrySet().stream().findFirst().get().getKey());
        }

        else
            System.out.println("No available bike in station to rent!");
    }

    public void dropBikeToStation(User user4) {

        if (bikes.size() < maxNumberOfBikes) {
            user4.currentlyRentedBike.state = BikeState.CanBeRented;
            this.addBike(user4.currentlyRentedBike);
            user4.currentlyRentedBike = null;
        }
        else
            System.out.println("This station is full, cannot accept return of any other bike at the moment!");
    }

    @Override
    public String toString() {
        return
                "stationID=" + stationID +
                ", location='" + location + '\'' +
                ", bikes=" + bikes +
                ", maxNumberOfBikes=" + maxNumberOfBikes;
    }
}