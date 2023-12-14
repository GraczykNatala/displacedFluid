package POJOs;

import static utils.constant.MAIN_CYLINDER_HEIGHT;

public class Cylinder extends Shape {

    public Cylinder(double diameter) {
        super(diameter);
    }

    @Override
    double calculateVolume(double diameter) {
        return Math.PI * Math.pow(diameter / 2, 2) * (0.1 * MAIN_CYLINDER_HEIGHT);
    }
}

