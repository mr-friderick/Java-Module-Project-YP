import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Race {
    ArrayList<Car> cars;
    int distance;
    Car winner;

    Race(HashSet<Car> cars, int distance) {
        this.cars = new ArrayList<>(cars);
        this.distance = distance;
    }

    public Car run() {
        int maxMileage = 0;
        int carMileage;

        for (Car car : cars) {
            carMileage = car.speed * distance;
            if (carMileage > maxMileage) {
                maxMileage = carMileage;
                winner = car;
            }
        }
        return winner;
    }
}

