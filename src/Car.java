public class Car extends Vehicle {
    public Car() {
        super(Company.czasProdukcjiCar, Company.kosztProdukcjiCar);
    }

    @Override
    public String toString() {
        return "Producing...\nCar{" +
                "czasProdukcji=" + czasProdukcji +
                ", kosztProdukcji=" + kosztProdukcji +
                "}\n";
    }
}
