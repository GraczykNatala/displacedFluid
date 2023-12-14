package utils;

import static utils.constant.*;

public enum ElementType {
    SPHERE(SPHERE_INPUT),
    CUBE(CUBE_INPUT),
    CYLINDER(CYLINDER_INPUT);

    private String writtenCase;

    public String getWrittenCase() {
        return writtenCase;
    }

    ElementType(String lowercase) {
        this.writtenCase = lowercase;
    }
}
