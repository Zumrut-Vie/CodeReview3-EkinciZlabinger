package citybike;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        // Create 8 or more Bike objects

        Bike bike1 = new Bike("yellow");
        //System.out.println("bike1: " + bike1.bikeID + " " + bike1.color);
        Bike bike2 = new Bike("black");
        //System.out.println("bike2: " + bike2.bikeID + " " + bike2.color);
        Bike bike3 = new Bike("blue");
        Bike bike4 = new Bike("brown");
        Bike bike5 = new Bike("green");
        Bike bike6 = new Bike("purple");
        Bike bike7 = new Bike("white");
        Bike bike8 = new Bike("gray");
        Bike bike9 = new Bike("cyan");
        //System.out.println("bike9: " + bike9.bikeID + " " + bike9.color);

        // Put existing bikes into HashMap

        HashMap<Integer,Bike> bikeMap = new HashMap<>();
        bikeMap.put(bike1.bikeID, bike1);
        bikeMap.put(bike2.bikeID, bike2);
        bikeMap.put(bike3.bikeID, bike3);
        bikeMap.put(bike4.bikeID, bike4);
        bikeMap.put(bike5.bikeID, bike5);
        bikeMap.put(bike6.bikeID, bike6);
        bikeMap.put(bike7.bikeID, bike7);
        bikeMap.put(bike8.bikeID, bike8);
        bikeMap.put(bike9.bikeID, bike9);


        System.out.println();

        System.out.println("BikeMap: "+ " \n" + bikeMap);

        System.out.println();

        // Create 3 stations and put them in a HashMap

        Station station1 = new Station("Berlin");
        Station station2 = new Station("Munich");
        Station station3 = new Station("Hamburg");
        HashMap<Integer,Station> stations = new HashMap<>();

        stations.put(station1.stationID, station1);
        stations.put(station2.stationID, station2);
        stations.put(station3.stationID, station3);
        System.out.println("Stations map: " + " \n" + stations);
        System.out.println();
        // Demonstration of addBike method usage

        station1.addBike(bike1);
        station1.addBike(bike2);
        station1.addBike(bike3);
        System.out.println("Station1 bikes: " + " \n" + station1.bikes);
        System.out.println();
        station2.addBike(bike4);
        station2.addBike(bike5);
        station2.addBike(bike6);
        station2.addBike(bike7);

        System.out.println("Station2 bikes: " + " \n" +  station2.bikes);
        System.out.println();

        // Create 4 users

        User user1 = new User("Jamie", "Oliver");
        User user2 = new User("Gordon", "Ramsey");
        User user3 = new User("Refika", "Birgul");
        User user4 = new User("Anthony", "Bourdain");

        //System.out.println("user4: " + user4.userID + " " + user4.name);

        // Demonstrate rental procedure

        System.out.println("RENTAL PROCEDURE DEMO\nRENT A BIKE:");
        System.out.println();
        System.out.println("station1 bikes before rent: " + station1.bikes);

        station1.rentBikeFromStation(user4);


        System.out.println("station1 bikes after rent: " + station1.bikes);
        System.out.println("Current bike of user4: "+ user4.currentlyRentedBike);
        System.out.println();
        System.out.println("RETURN THE BIKE:");
        System.out.println("station2 bikes before return: " + station2.bikes);

        station2.dropBikeToStation(user4);

        System.out.println("station2 bikes after return: " + station2.bikes);
        System.out.println("Current bike of user4: "+ user4.currentlyRentedBike);

    }

}