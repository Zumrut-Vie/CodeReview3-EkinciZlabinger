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
    public Station(String location) {
        this.stationId = stationIdCounter;
        stationIdCounter ++;
        this.location = location;
        this.bikes = new HashMap<Integer, Bike>();
        this.maxNumberOfBikes = (int)(Math.random()*5)+1;

    }
    public void addRandomBike(){
        Bike bike = Bike.generateRandomBike();
        this.bikes.put(bike.bikeID,bike);
    }
    public int getBikeCount(){
        return bikes.keySet().size();
    }

    public Bike giveMeRandomBike(){
        for(Object key:bikes.keySet()){
            return ((Bike)(bikes.get(key)));

        }
        return null;
    }
    public boolean addBike(Bike bike){
        if(bikes.keySet().size()+1>maxNumberOfBikes){
            System.out.println("capacity of the station id "+ stationId +" is " + maxNumberOfBikes);
            System.out.println("*******Station is full");
            return false;
        }
        bikes.put(bike.bikeID,bike);
        return true;
    }
    public void removeBike(int bikeId){
       bikes.remove(bikeId);
    }
    public void print() {
        System.out.println("station" + this.stationId + " " + this.location);
        System.out.println("number of bikes in this station" + getBikeCount());
        for(Object key:bikes.keySet()){
            ((Bike)(bikes.get(key))).print();
        }
    }

    public static void main(String[]args) {
        generateStations(9);


    }

    public static void generateStations(int numberOfStations) {
        Station.stationIdCounter = 0;
        for (int i=0; i<numberOfStations;i++){
            int cityIndex = (int)(Math.random()* cities.length);
            String city = cities[cityIndex];
            Station station = new Station (city);
            stations.put(station.stationId, station);
            station.print();
        }
        for(int i=0;i<stations.keySet().size();i++){
            Station currenStation= ((Station)(stations.get(i)));
            int numberOfBikes=(int)(Math.random() * currenStation.maxNumberOfBikes)+1;
            for(int j= 0;j<numberOfBikes;j++)
                ((Station)(stations.get(i))).addRandomBike();
        }

        ((Station)(stations.get(0))).print();
        ((Station)(stations.get(1))).print();
    }
}

