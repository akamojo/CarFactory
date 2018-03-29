public abstract class Vehicle {

    protected int czasProdukcji;
    protected double kosztProdukcji;

    public Vehicle(int czasProdukcji, double kosztProdukcji) {
        this.czasProdukcji = czasProdukcji;
        this.kosztProdukcji = kosztProdukcji;
    }

    public int getCzasProdukcji() {
        return czasProdukcji;
    }

    public void setCzasProdukcji(int czasProdukcji) {
        this.czasProdukcji = czasProdukcji;
    }

    public double getKosztProdukcji() {
        return kosztProdukcji;
    }

    public void setKosztProdukcji(double kosztProdukcji) {
        this.kosztProdukcji = kosztProdukcji;
    }

    @Override
    public abstract String toString();

    public void describe() {
        System.out.println(this.getClass());
        System.out.println(czasProdukcji);
        System.out.println(kosztProdukcji);
        System.out.println("");
    }
}
