import java.util.ArrayList;
import java.util.Random;

public class Company extends Thread {
    private ArrayList<Order> orders;

    public static final int czasProdukcjiCar = 10;
    public static final double kosztProdukcjiCar = 1000;

    public static final int czasProdukcjiMotorcycle = 5;
    public static final double kosztProdukcjiMotorcycle = 600;

    public static final int czasProdukcjiTruck = 15;
    public static final double kosztProdukcjiTruck = 2000;

    private CarFactory cf;
    private MotorcycleFactory mf;
    private TruckFactory tf;

    private boolean stdin = false;

    public Company() {
        this.orders = new ArrayList<>();
        this.cf = new CarFactory();
        this.cf.start();
        this.mf = new MotorcycleFactory();
        this.mf.start();
        this.tf = new TruckFactory();
        this.tf.start();
    }

    public boolean isStdin() {
        return stdin;
    }

    public void setStdin(boolean stdin) {
        this.stdin = stdin;
    }

    public void addOrder(Order o) {
        System.err.println(o.toString());
        this.orders.add(o);
        cf.incNumOfOrdered(o.getNumOfCars());
        mf.incNumOfOrdered(o.getNumOfMotorcycles());
        tf.incNumOfOrdered(o.getNumOfTrucks());
    }

    public void serveOrders() {
        if (!orders.isEmpty()) {
            for (Order i : orders) {
                if (i.getStatus() == Status.PROGRESS) {

                    int cars = Math.min(i.getNumOfCars(), Warehouse.getInstance().getCars().size());
                    i.setNumOfCars(i.getNumOfCars() - cars);
                    i.incrementTotalCost(cars * kosztProdukcjiCar);
                    Warehouse.getInstance().delCar(cars);

                    int mot = Math.min(i.getNumOfMotorcycles(), Warehouse.getInstance().getMotors().size());
                    i.setNumOfMotorcycles(i.getNumOfMotorcycles() - mot);
                    Warehouse.getInstance().delMotorcycle(mot);
                    i.incrementTotalCost(mot * kosztProdukcjiMotorcycle);

                    int tru = Math.min(i.getNumOfTrucks(), Warehouse.getInstance().getTrucks().size());
                    i.setNumOfTrucks(i.getNumOfTrucks() - tru);
                    Warehouse.getInstance().delTruck(tru);
                    i.incrementTotalCost(tru * kosztProdukcjiTruck);

                    i.calculateTotalNum();

                    if (i.getTotalNum() == 0) {
                        i.setStatus(Status.DONE);
                        Main.cars = 0;
                        Main.mot = 0;
                        Main.tru = 0;
                        System.err.println(i.toString());

                        if(stdin) {
                            try {
                                Thread.sleep(1000);
                                System.out.println("----------------- TYPE YOUR ORDER IN XML FORMAT -----------------\n");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            try {
                Thread.sleep(random.nextInt(20) * 1000);
                serveOrders();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}