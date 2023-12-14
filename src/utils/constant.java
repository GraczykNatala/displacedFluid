package utils;

public class constant {

    public final static double DENSITY = 1;
    public static final String FINISH = "koniec";

    public static final String CONSOLE_INFO_1 = "Podaj rodzaj bryły. Opcje to: "
            + ElementType.SPHERE.getWrittenCase() + ", "
            + ElementType.CYLINDER.getWrittenCase() + ", "
            + ElementType.CUBE.getWrittenCase();
    public static final String CONSOLE_INFO_2 = "Aby zakończyć napisz " + FINISH;

    public static final String DIAMETER_ASK = "Podaj średnicę:";
    public static final String ONLY_NUMBERS_ERROR_MSG = "Podaj wartość liczbową";
    public static final String LESS_THAN_ZERO_ERROR_MSG = "Średnica nie może być mniejsza niż zero.";
    public static final String NO_SUCH_ELEMENT_ERROR_MSG = "Nie ma takiego elementu.";

    public static final String RESULT_INFO = "Masa wyparta: ";

    public static final String CUBE_INPUT = "szescian";
    public static final String CYLINDER_INPUT = "walec";
    public static final String SPHERE_INPUT = "kula";

    public static final double MAIN_CYLINDER_HEIGHT = 100;
}
