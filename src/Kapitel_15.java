import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Kapitel_15 {
    public static void app() {
//        exercise_15_1();
//        exercise_15_4();
    }

    private static void exercise_15_1() {
        var carArr = new Car[3];
        carArr[0] = new Car();
        carArr[1] = new Car();
        carArr[2] = new Car();

        for(Car car : carArr)
            System.out.println(car.toString());
    }

    private static void exercise_15_4() {
        Point[] p = new Point[20];
        int i = 0;
        boolean minusXAndMinusY = false;

        try(Scanner sc = new Scanner(new File("resources/files/points.txt"))) {
            while(sc.hasNextLine() && i < p.length) {
                sc.nextLine();
                while(sc.hasNextDouble())
                    p[i++] = new Point(sc.nextDouble(), sc.nextDouble());
            }
            for(int k=0; k<p.length; k++) {
                double x = p[k].getX();
                double y = p[k].getY();
                System.out.println(x + "\t\t\t" + y);
                if (x < 0 && y < 0) {
                    minusXAndMinusY = true;
                    System.out.println("x pos & y pos are both minus!");
                }
            }
            if(!minusXAndMinusY)
                System.out.println("No minus pos found in both x and y!");
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

class Car {
    String licenseNumber, model;
    int modelYear, weight, hp;

    @Override
    public String toString() {
        return "Car{" +
                "licenseNumber='" + licenseNumber + '\'' +
                ", model='" + model + '\'' +
                ", modelYear=" + modelYear +
                ", weight=" + weight +
                ", hp=" + hp +
                '}';
    }
}