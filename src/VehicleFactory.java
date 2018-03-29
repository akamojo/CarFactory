import java.util.Random;

public abstract class VehicleFactory extends Thread {

    protected int numOfOrdered = 0;
    public abstract void produkujPojazd();

    public int getNumOfOrdered() {
        return numOfOrdered;
    }

    public synchronized void setNumOfOrdered(int numOfOrdered) {
        this.numOfOrdered = numOfOrdered;
    }

    public void incNumOfOrdered(int num) {
        this.numOfOrdered += num;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            try {
                Thread.sleep(random.nextInt(10) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
