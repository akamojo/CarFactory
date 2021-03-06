import java.util.Random;

public class MotorcycleFactory extends VehicleFactory {

    @Override
    public void produkujPojazd() {
        Warehouse.getInstance().addMotorcycle(new Motorcycle());
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
                    System.out.println(Warehouse.getInstance().getMotors().get(Warehouse.getInstance().getMotors().size() - 1).toString());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
