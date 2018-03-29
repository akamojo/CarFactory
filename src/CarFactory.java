import java.util.Random;

public class CarFactory extends VehicleFactory {

    @Override
    public void produkujPojazd() {
        Warehouse.getInstance().addCar(new Car());
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
                    System.out.println(Warehouse.getInstance().getCars().get(Warehouse.getInstance().getCars().size() - 1).toString());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
