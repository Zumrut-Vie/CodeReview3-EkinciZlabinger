package citybike;

import java.time.LocalDate;

public class Rent {
    LocalDate rentStart;
    LocalDate rentEnd;
    User user;
    int bikeID;

    public Rent(LocalDate rentStart, LocalDate rentEnd, User user) {
        this.rentStart = rentStart;
        this.rentEnd = rentEnd;
        this.user = user;
        bikeID = user.currentlyRentedBike.bikeID;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "rentStart=" + rentStart +
                ", rentEnd=" + rentEnd +
                ", user=" + user +
                ", bikeID=" + bikeID +
                '}';
    }
}
