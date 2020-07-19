package citybike;

import java.util.HashMap;

public class User {
    int userId;
    String name, surname;
    int currentlyRentedBike;
    static int userIdCounter;
//Constructor
    public User(String name, String surname) {
        this.userId = userIdCounter;
        userIdCounter ++;
        this.name = name;
        this.surname = surname;

    }
    public static void main(String[]args){
        User user1= new User("Sara", "Müller");
        User user2= new User("Lara", "Müller");
        User user3= new User("Mara", "Müller");
        User user4= new User("Yara", "Müller");
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

     public String toString(){
        return "User{userId + name + surname + currentlyRentedBike}";
    }
}
