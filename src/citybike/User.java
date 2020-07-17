package citybike;

public class User {
    int userId;
    String name, surname;
    Bike currentlyRentedBike;
    static int userIdCounter;

    public User(String name, String surname) {
        this.userId = userIdCounter;
        userIdCounter ++;
        this.name = name;
        this.surname = surname;
        this.currentlyRentedBike = null;
    }
    public static void main(String[]args){
        User user1= new User("Sara", "Müller");
        User user2= new User("Lara", "Müller");
        User user3= new User("Mara", "Müller");
        User user4= new User("Yara", "Müller");
        Station.generateStations(10);
        int stationIndexTobeRented = ((int)(Math.random()* 10));
        user1.rentBike(stationIndexTobeRented);
        int stationIndexTobeReturned = ((int)(Math.random()* 10));
        user1.returnRentedBike(stationIndexTobeReturned);
    }
    public void rentBike(int stationId){
        Station currentStation = ((Station)(Station.stations.get(stationId)));
        if (currentStation.getBikeCount()==0) {
            System.out.println("no bike is available in this station");
            return;
        }
        Bike bikeToBeRented = currentStation.giveMeRandomBike();
        this.currentlyRentedBike = bikeToBeRented;
        currentStation.removeBike(bikeToBeRented.bikeID);
        System.out.println("Bike is successfully rented from " + currentStation.location);
        currentlyRentedBike.print();
        System.out.println("-----------------------------------------");
    }
   public void returnRentedBike(int stationId){
        if(currentlyRentedBike==null)
            return;
        Station currentStation = ((Station)(Station.stations.get(stationId)));
        boolean result = currentStation.addBike(currentlyRentedBike);
        if(result==false){
            System.out.println("return was not successful");
            return;
        }
       currentlyRentedBike.print();
        currentlyRentedBike = null;
       System.out.println("Bike is successfully returned to " + currentStation.location);
       currentStation.print();
       System.out.println("-----------------------------------------");

    }
}
