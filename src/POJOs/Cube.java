package POJOs;

import static utils.constant.MAIN_CYLINDER_HEIGHT;

public class Cube extends Shape {

    //private double volume;
    private double edge;

    public Cube(double diamter) {
        super(diamter);
        this.edge = calculateEdge(diamter);
        setVolume(calculateVolume(edge));
    }

    double calculateVolume(double edge) {
        return Math.pow(edge, 3);
    }

    private double calculateEdge(double diameter) {
        Double height = Math.sqrt(diameter * diameter / 2);
        return Math.round(height * 100.0) / 100.0;
    }


    public double getEdge() {
        return edge;
    }

    public double cubeVolumeAsCylinder() {
        return Math.PI * Math.pow(getDiameter() / 2, 2) * (edge);
    }

    public double cubeVolumeAsTwoCones() {
        double cubeDiagonal = Math.sqrt(Math.pow(edge, 2) + Math.pow(edge, 2) + Math.pow(getDiameter(), 2));
        return 2 * ((1.0 / 3) * Math.PI * Math.pow((getDiameter() / 2), 2) * (cubeDiagonal / 2));

    }
}
