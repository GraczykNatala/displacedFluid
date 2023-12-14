package POJOs;

public abstract class Shape {
    private double diameter;
    private double volume;


    public double getDiameter() {
        return diameter;
    }
    public double getVolume(){
        return volume;
    }


    protected Shape(double diameter) {
        this.diameter = diameter;
        this.volume = calculateVolume(diameter);
    }

    abstract double calculateVolume(double diameter);
}

