/*
 * Task: Inheritance and Polymorphism. Variant 9.
 * Hierarchy of passenger cars, taxi fleet, cost calculation, sorting by fuel consumption,
 * finding a car by speed range. Exception handling and documentation included.
 */
package lab_5.task;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Abstract base class for all cars.
 */
abstract class Car {
    protected String brand;
    protected double price;
    protected double fuelConsumption; // liters per 100km
    protected int maxSpeed;

    public Car(String brand, double price, double fuelConsumption, int maxSpeed) {
        this.brand = brand;
        this.price = price;
        this.fuelConsumption = fuelConsumption;
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() { return brand; }
    public double getPrice() { return price; }
    public double getFuelConsumption() { return fuelConsumption; }
    public int getMaxSpeed() { return maxSpeed; }

    @Override
    public String toString() {
        return String.format("%s: price=%.2f, fuel=%.1f, speed=%d", brand, price, fuelConsumption, maxSpeed);
    }
}

/**
 * Sedan car class.
 */
class Sedan extends Car {
    public Sedan(String brand, double price, double fuelConsumption, int maxSpeed) {
        super(brand, price, fuelConsumption, maxSpeed);
    }
}

/**
 * SUV car class.
 */
class SUV extends Car {
    public SUV(String brand, double price, double fuelConsumption, int maxSpeed) {
        super(brand, price, fuelConsumption, maxSpeed);
    }
}

/**
 * Hatchback car class.
 */
class Hatchback extends Car {
    public Hatchback(String brand, double price, double fuelConsumption, int maxSpeed) {
        super(brand, price, fuelConsumption, maxSpeed);
    }
}

/**
 * TaxiPark class manages an array of cars.
 */
class TaxiPark {
    private Car[] cars;

    public TaxiPark(Car[] cars) {
        if (cars == null || cars.length == 0) {
            throw new IllegalArgumentException("TaxiPark must have at least one car.");
        }
        this.cars = cars;
    }

    /**
     * Calculates total cost of all cars in the park.
     * @return total price
     */
    public double getTotalCost() {
        double sum = 0;
        for (Car car : cars) {
            sum += car.getPrice();
        }
        return sum;
    }

    /**
     * Sorts cars by fuel consumption (ascending).
     */
    public void sortByFuelConsumption() {
        Arrays.sort(cars, Comparator.comparingDouble(Car::getFuelConsumption));
    }

    /**
     * Finds cars with maxSpeed in [minSpeed, maxSpeed].
     * @param minSpeed minimum speed
     * @param maxSpeed maximum speed
     * @return array of matching cars
     */
    public Car[] findCarsBySpeedRange(int minSpeed, int maxSpeed) {
        return Arrays.stream(cars)
            .filter(car -> car.getMaxSpeed() >= minSpeed && car.getMaxSpeed() <= maxSpeed)
            .toArray(Car[]::new);
    }

    public Car[] getCars() {
        return cars;
    }
}

/**
 * Main application class.
 */
public class App {
    /**
     * Main executable method.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            // Create taxi park with sample cars
            Car[] cars = new Car[] {
                new Sedan("Toyota Camry", 25000, 7.5, 210),
                new SUV("Honda CR-V", 32000, 8.2, 200),
                new Hatchback("Ford Fiesta", 18000, 5.9, 190),
                new Sedan("BMW 3 Series", 35000, 6.8, 240),
                new SUV("Kia Sportage", 27000, 7.9, 195)
            };

            TaxiPark park = new TaxiPark(cars);

            // Calculate total cost
            double totalCost = park.getTotalCost();
            System.out.printf("Total taxi park cost: %.2f\n", totalCost);

            // Sort cars by fuel consumption
            park.sortByFuelConsumption();
            System.out.println("Cars sorted by fuel consumption:");
            for (Car car : park.getCars()) {
                System.out.println(car);
            }

            // Find cars by speed range
            int minSpeed = 195;
            int maxSpeed = 220;
            Car[] found = park.findCarsBySpeedRange(minSpeed, maxSpeed);
            System.out.printf("Cars with speed in range [%d, %d]:\n", minSpeed, maxSpeed);
            for (Car car : found) {
                System.out.println(car);
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}
