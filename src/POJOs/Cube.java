package POJOs;

public class Cube extends Shape {

    public Cube(double diameter) {
        super(diameter);
    }

    @Override
    double calculateVolume(double diameter) {
        return Math.pow(diameter, 3);
    }
}
