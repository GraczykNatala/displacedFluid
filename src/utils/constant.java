package utils;

public class constant {

    //math constants
    public final static double DENSITY = 1;
    public static final double MAIN_CYLINDER_HEIGHT = 100;
    public static final double DEFAULT_DIAMETER = 10;

    //inputs
    public static final String FINISH = "koniec";

    public static final String CUBE_INPUT = "szescian";
    public static final String CYLINDER_INPUT = "walec";
    public static final String SPHERE_INPUT = "kula";

    //console info
    public static final String CONSOLE_INFO_1 = "Podaj rodzaj bryły. Opcje to: "
            + ElementType.SPHERE.getWrittenCase() + ", "
            + ElementType.CYLINDER.getWrittenCase() + ", "
            + ElementType.CUBE.getWrittenCase();
    public static final String CONSOLE_INFO_2 = "Aby zakończyć napisz " + FINISH;
    public static final String NO_SUCH_ELEMENT_ERROR_MSG = "Nie ma takiego elementu.";
    public static final String RESULT_INFO = "Masa wyparta: ";

}
