package citybike;

public class User {

    private static Integer newUserId = 0;

    Integer userID;
    String name;
    String surname;
    Bike currentlyRentedBike;

    public User (String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.userID = newUserId;
        newUserId++;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", currentlyRentedBike=" + currentlyRentedBike +
                '}';
    }
}