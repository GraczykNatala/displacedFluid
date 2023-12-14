package POJOs;

public class Sphere extends Shape {

    public Sphere(double diameter) {
        super(diameter);
    }

    @Override
    double calculateVolume(double diameter) {
        return  (4.0 / 3) * Math.PI * Math.pow(diameter / 2, 3);
    }
}
