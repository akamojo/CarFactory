public class Truck extends Vehicle {
    public Truck() {
        super(Company.czasProdukcjiTruck, Company.kosztProdukcjiTruck);
    }

    @Override
    public String toString() {
        return "Producing...\nTruck{" +
                "czasProdukcji=" + czasProdukcji +
                ", kosztProdukcji=" + kosztProdukcji +
                "}\n";
    }
}
