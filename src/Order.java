public class Order {

    private int numOfCars;
    private int numOfMotorcycles;
    private int numOfTrucks;
    private int totalNum;
    private Status status;

    private double totalCost = 0.0;

    public Order(int numOfCars, int numOfMotorcycles, int numOfTrucks) {
        this.numOfCars = numOfCars;
        this.numOfMotorcycles = numOfMotorcycles;
        this.numOfTrucks = numOfTrucks;
        this.status = Status.PROGRESS;
        calculateTotalNum();
    }

    public int getTotalNum() {
        return totalNum;
    }

    public synchronized void calculateTotalNum() {
        this.totalNum = this.numOfCars + this.numOfTrucks + this.numOfMotorcycles;
    }

    public Status getStatus() {
        return status;
    }

    public synchronized void setStatus(Status status) {
        this.status = status;
    }

    public int getNumOfCars() {
        return numOfCars;
    }

    public synchronized void setNumOfCars(int numOfCars) {
        this.numOfCars = numOfCars;
    }

    public int getNumOfMotorcycles() {
        return numOfMotorcycles;
    }

    public synchronized void setNumOfMotorcycles(int numOfMotorcycles) {
        this.numOfMotorcycles = numOfMotorcycles;
    }

    public int getNumOfTrucks() {
        return numOfTrucks;
    }

    public synchronized void setNumOfTrucks(int numOfTrucks) {
        this.numOfTrucks = numOfTrucks;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public synchronized void setTotalCost(double cost) {
        this.totalCost = cost;
    }

    public synchronized void incrementTotalCost(double cost) {
        this.totalCost += cost;
    }

    @Override
    public String toString() {
        return "Order{" +
                "numOfCars=" + numOfCars +
                ", numOfMotorcycles=" + numOfMotorcycles +
                ", numOfTrucks=" + numOfTrucks +
                ", status=" + status +
                ", totalCost=" + totalCost +
                "}\n";
    }
}


