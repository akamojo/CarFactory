import java.util.Random;

public class TruckFactory extends VehicleFactory {

    @Override
    public void produkujPojazd() {
        Warehouse.getInstance().addTruck(new Truck());
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            try {
                Thread.sleep(random.nextInt(10) * 1000);
                if(numOfOrdered > 0) {
                    produkujPojazd();
                    numOfOrdered--;
                    System.out.println(Warehouse.getInstance().getTrucks().get(Warehouse.getInstance().getTrucks().size() - 1).toString());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
