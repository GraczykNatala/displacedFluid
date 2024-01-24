import POJOs.Cube;
import POJOs.Cylinder;
import POJOs.Sphere;

import java.util.Scanner;

import static utils.constant.*;

/**
 * Cylinder szklany o średnicy d=10 cm i wysokości h=100cm zalano całkowicie wodą o gęstości 1g/cm3.
 * Następnie do cylindra wrzucano ołowiane kule, sześciany o średnicy d oraz walce o średnicy d i wysokości 0,1*h.
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double displacedFluidStaticVersion = 0;
        double displacedFluidRotatingVersion = 0;
        double freeSpace = MAIN_CYLINDER_HEIGHT;
        boolean isSpace = true;



        String userElementInput = "";
        while (isSpace) {
            userElementInput = readElementType(scanner);
            if (userElementInput.equals(FINISH)) {
                break;
            }
            switch (userElementInput) {
                case SPHERE_INPUT -> {
                    Sphere sphere = new Sphere(DEFAULT_DIAMETER);
                    System.out.println(sphere.getVolume());
                    if (blockWontFit(freeSpace, sphere.getDiameter())) {
                        isSpace = false;
                    } else {
                        freeSpace -= sphere.getDiameter();
                        displacedFluidStaticVersion += sphere.getVolume() * DENSITY;
                        displacedFluidRotatingVersion += sphere.getVolume() * DENSITY;
                        System.out.println(freeSpace);
                    }
                }
                case CYLINDER_INPUT -> {
                    Cylinder cylinder = new Cylinder(DEFAULT_DIAMETER);
                    System.out.println(cylinder.getVolume());
                    if (blockWontFit(freeSpace, cylinder.getDiameter())) {
                        isSpace = false;
                    } else {
                        freeSpace -= cylinder.getDiameter();
                        displacedFluidStaticVersion += cylinder.getVolume() * DENSITY;
                        displacedFluidRotatingVersion += cylinder.getVolume() * DENSITY;
                        System.out.println(freeSpace);
                    }
                }
                case CUBE_INPUT -> {
                    Cube cube = new Cube(DEFAULT_DIAMETER);
                    System.out.println(cube.getVolume());
                    String userElementPositionInput = readElementPosition(scanner);
                    switch (userElementPositionInput) {
                        case "krawędzią" -> {
                            if (blockWontFit(freeSpace, cube.getEdge())) {
                                isSpace = false;
                            } else {
                                freeSpace -= cube.getEdge();
                                displacedFluidRotatingVersion += cube.cubeVolumeAsCylinder() * DENSITY;
                                System.out.println(cube.cubeVolumeAsCylinder());
                                displacedFluidStaticVersion += cube.getVolume() * DENSITY;
                                System.out.println(freeSpace);
                            }
                        }
                        case "wierzchołkiem" -> {
                            if (blockWontFit(freeSpace, cube.getDiameter())) {
                                isSpace = false;
                            } else {
                                freeSpace -= cube.getDiameter();
                                displacedFluidRotatingVersion += cube.cubeVolumeAsTwoCones() * DENSITY;
                                System.out.println(cube.cubeVolumeAsTwoCones());
                                displacedFluidStaticVersion += cube.getVolume() * DENSITY;
                                System.out.println(freeSpace);
                            }
                        }
                    }
                }
                default -> {
                    System.out.println(NO_SUCH_ELEMENT_ERROR_MSG);
                    continue;
                }
            }
        }
        System.out.println(RESULT_INFO + displacedFluidStaticVersion);
        System.out.println(RESULT_INFO + " wlaczona platforma " +displacedFluidRotatingVersion);
        scanner.close();
    }
    private static boolean blockWontFit(double freeSpace, double height) {
        if (freeSpace - height < 0) {
            System.out.println("Osiągnięto limit figur, powyzsza figura nie zmieści się do kontenera.");
            System.out.println("Kończę działanie programu");
            return true;
        }
        return false;
    }

    private static String readElementPosition(Scanner scanner) {
        System.out.println("Sześcian umieszczasz krawędzią czy wierzchołkiem?");
        String position = scanner.next().toLowerCase();

        if (!position.equals("krawędzią") && !position.equals("wierzchołkiem")) {
            System.out.println("Źle podana pozycja.");
            scanner.nextLine();
            position = scanner.next().toLowerCase();
        }
        return position;
    }

    private static String readElementType(Scanner scanner) {
        System.out.println(CONSOLE_INFO_1);
        System.out.println(CONSOLE_INFO_2);
        return scanner.next().toLowerCase();
    }

}
