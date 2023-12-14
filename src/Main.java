import POJOs.Cube;
import POJOs.Cylinder;
import POJOs.Sphere;

import java.util.InputMismatchException;
import java.util.Scanner;

import static utils.constant.*;

/**
 * Cylinder szklany o średnicy d=10 cm i wysokości h=100cm zalano całkowicie wodą o gęstości 1g/cm3.
 * Następnie do cylindra wrzucano ołowiane kule, sześciany o średnicy d oraz walce o średnicy d i wysokości 0,1*h.
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double displacedFluid = 0;

        String userElementInput = "";
        double elDiameter;
        while (!userElementInput.equals(FINISH)) {
            userElementInput = readElementType(scanner);
            if (userElementInput.equals(FINISH)) {
                break;
            }
            elDiameter = readDiameter(scanner);

            double elVolume;

            switch (userElementInput) {
                case SPHERE_INPUT -> elVolume = new Sphere(elDiameter).getVolume();

                case CUBE_INPUT -> elVolume = new Cube(elDiameter).getVolume();

                case CYLINDER_INPUT -> elVolume = new Cylinder(elDiameter).getVolume();
                default -> {
                    System.out.println(NO_SUCH_ELEMENT_ERROR_MSG);
                    continue;
                }
            }
            double elementMass = DENSITY * elVolume;
            displacedFluid += elementMass;
        }
        System.out.println(RESULT_INFO + displacedFluid);
        scanner.close();
    }

    private static String readElementType(Scanner scanner) {
        System.out.println(CONSOLE_INFO_1);
        System.out.println(CONSOLE_INFO_2);
        return scanner.next().toLowerCase();
    }

    private static double readDiameter(Scanner scanner) {
        double elDiameter;
        while (true) {
            try {
                System.out.println(DIAMETER_ASK);
                elDiameter = scanner.nextDouble();

                if (elDiameter <= 0) {
                    System.out.println(LESS_THAN_ZERO_ERROR_MSG);
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println(ONLY_NUMBERS_ERROR_MSG);
                scanner.nextLine();
            }
        }
        return elDiameter;
    }
}
