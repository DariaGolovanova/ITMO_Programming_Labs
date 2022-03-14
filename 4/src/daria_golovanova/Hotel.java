package daria_golovanova;

import java.util.Objects;

public class Hotel {
    private int stars;

    public Hotel(int stars) {
        this.stars = stars;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "Hotel c количеством звёзд " + stars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hotel)) return false;
        Hotel hotel = (Hotel) o;
        return stars == hotel.stars;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stars);
    }
}
