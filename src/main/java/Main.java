import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        final int distance    = 24;
        final int countCar    = 3;
        final int minSpeed    = 0;
        final int maxSpeed    = 250;
        // Использую Set, т.к. считаю, что в гонке не может учавствовать две машины с одинаковым названием и скоростью
        HashSet<Car> cars = new HashSet<>();

        System.out.println("Добро пожаловать на гонку «24 часа Ле-Мана»! Давайте определим победителя!");
        for (int i = 1; i <= countCar; i++) {
            String carName;
            int carSpeed;

            System.out.printf(
                "Укажите название машины под номером %d...\n",
                i
            );
            carName = scanner.next();

            System.out.println("Укажите ее скорость...");
            while(true) {
                if (scanner.hasNextInt())  {
                    carSpeed = scanner.nextInt();
                    if (carSpeed <= minSpeed || carSpeed > maxSpeed) {
                        printFailSpeedMassage();
                    } else {
                        break;
                    }
                } else {
                    printFailSpeedMassage();
                    scanner.next();
                }
            }

            cars.add(new Car(carName, carSpeed));
        }
        scanner.close();

        System.out.println("\nГонка началась, скоро мы узнаем победителя!\n");
        // Имитация продолжительности заезда
        TimeUnit.SECONDS.sleep(3);

        Race race = new Race(cars, distance);
        Car winner = race.run();

        System.out.printf(
            "Победила машина с именем «%s»!\n",
            winner.name
        );
    }

    public static void printFailSpeedMassage() {
        System.out.println("Введено неверное значение, попробуйте еще раз!");
    }
}