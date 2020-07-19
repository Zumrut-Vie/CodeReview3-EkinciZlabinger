package citybike;

import java.util.HashMap;

public class Station {
    static HashMap stations = new HashMap<Integer, Station>();
    int stationId;
    String location;
    HashMap bikes;
    int maxNumberOfBikes;
    static String cities[] = {"Vienna", "Paris", "Istanbul"};
    static int stationIdCounter;


    //Constructor
    public Station(String location) {
        this.stationId = stationIdCounter;
        stationIdCounter++;
        this.location = location;
        this.bikes = new HashMap<Integer, Bike>();
        this.maxNumberOfBikes = (int) (Math.random() * 5) + 1;

    }

    public static void main(String[] args) {
        Station station1 = new Station("Neubaugasse");
        Station station2 = new Station("Operngasse");
        Station station3 = new Station("Brunnenmarkt");

        stations.put(station1.getStationId(), station1);
        stations.put(station2.getStationId(), station2);
        stations.put(station3.getStationId(), station3);

    }

    public String getLocation() {
        return location;
    }

    public int getStationId() {
        return stationId;
    }

    public HashMap getBikes() {
        return bikes;
    }

    public void addBike(Bike bike, Station station) {
        if (bikes.size()<maxNumberOfBikes) {
            bikes.put(bike.bikeId, bike);
        } else {
            System.out.println("Please go to another station. Here is full");
        }
    }

    public void removeBike(Bike bike) {
        bikes.remove(bike);
    }

    public void print() {
        System.out.println(this.stationId + " " + this.location + " " + this.bikes);
        System.out.println("***************************************************");
    }
}



