import java.util.ArrayList;

public class Warehouse {
    private static Warehouse instance = null;

    private ArrayList<Car> cars;
    private ArrayList<Motorcycle> motors;
    private ArrayList<Truck> trucks;

    private Warehouse() {
        this.cars = new ArrayList<>();
        this.motors = new ArrayList<>();
        this.trucks = new ArrayList<>();
    }

    public synchronized static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public synchronized void addCar(Car c) {
        this.cars.add(c);
    }

    public synchronized void addMotorcycle(Motorcycle m) {
        this.motors.add(m);
    }

    public synchronized void addTruck(Truck t) {
        this.trucks.add(t);
    }

    public synchronized void delCar(int n) {
        for (int i = n - 1; i >= 0; i--) {
            this.cars.remove(i);
        }
    }

    public synchronized void delMotorcycle(int n) {
        for (int i = n - 1; i >= 0; i--) {
            this.motors.remove(i);
        }
    }

    public synchronized void delTruck(int n) {
        for (int i = n - 1; i >= 0; i--) {
            this.trucks.remove(i);
        }
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public synchronized void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public ArrayList<Motorcycle> getMotors() {
        return motors;
    }

    public synchronized void setMotors(ArrayList<Motorcycle> motors) {
        this.motors = motors;
    }

    public ArrayList<Truck> getTrucks() {
        return trucks;
    }

    public synchronized void setTrucks(ArrayList<Truck> trucks) {
        this.trucks = trucks;
    }

}
