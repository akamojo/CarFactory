public class Motorcycle extends Vehicle {
    public Motorcycle() {
        super(Company.czasProdukcjiMotorcycle, Company.kosztProdukcjiMotorcycle);
    }

    @Override
    public String toString() {
        return "Producing...\nMotorcycle{" +
                "czasProdukcji=" + czasProdukcji +
                ", kosztProdukcji=" + kosztProdukcji +
                "}\n";
    }
}
