import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Kapitel_12 {
    public static void app() {
//        exercise_12_1();
//        exercise_12_2();
//        exercise_12_3();
//        exercise_12_4();
//        exercise_12_5();
//        exercise_12_6();
//        exercise_12_7();
//        programmeringuppgift_12_1();
//        programmeringuppgift_12_2();
//        programmeringuppgift_12_3();
    }

    private static void exercise_12_1() {
        var int2Arr = new int[10][10];

        for (int i = 0; i < int2Arr.length; i++) {
            for (int j = 0; j < int2Arr[i].length; j++) {
                int2Arr[i][j] = (i + 1) * (j + 1);
            }
        }

        for (int i = 0; i < int2Arr.length; i++) {
            for (int j = 0; j < int2Arr[i].length; j++) {
                System.out.print(int2Arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("*********************************");
    }

    private static void exercise_12_2() {
        int[][] int2Arr = {{3, 0}, {4, 0}, {2, 0}, {7, 0}, {8, 0}, {9, 0}, {5, 0}, {3, 0}, {3, 0}};

        for (int i = 0; i < int2Arr.length; i++) {
            int num = int2Arr[i][0];
            for (int j = 0; j < int2Arr[i].length; j++) {
                int2Arr[i][1] = 10 - num;
            }
        }

        for (int i = 0; i < int2Arr.length; i++) {
            for (int j = 0; j < int2Arr[i].length; j++) {
                System.out.print(int2Arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("*********************************");
    }

    private static void exercise_12_3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many rows?: ");
        int intA = sc.nextInt();
        System.out.println("How many columns?: ");
        int intB = sc.nextInt();

        var int2Arr = new int[intA][intB];

        for (int i = 0; i < int2Arr.length; i++) {
            for (int j = 0; j < int2Arr[i].length; j++) {
                int2Arr[i][j] = (i + 1) * (j + 1);
            }
        }

        for (var row : int2Arr) {
            for (var col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
        sc.close();
        System.out.println("*********************************");
    }

    private static void exercise_12_4() {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many rows?: ");
        int rows = sc.nextInt();

        int[][] int2Arr = new int[rows][];

        for (int i = 0; i < int2Arr.length; i++) {
            int2Arr[i] = new int[i + 1];
            for (int j = 0; j < int2Arr[i].length; j++) {
                int2Arr[i][j] = (i + 1) * (j + 1);
            }
        }

        for (var row : int2Arr) {
            for (var col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
        sc.close();
        System.out.println("*********************************");
    }

    private static void exercise_12_5() {
        var double2Arr = new double[5][4];
        double k = 10;

        for (int i = 0; i < double2Arr.length - 1; i++) {
            k /= 10.0;
            double2Arr[i][2] = k;
        }
        System.out.println("*********************************");
        System.out.println("Total sum of col 3: " + colSum(double2Arr, 2));
        System.out.println("*********************************");
    }

    private static void exercise_12_6() {
        int[][] int2Arr = new int[10][7];

        for (int i = 0; i < int2Arr.length; i++) {
            for (int j = 0; j < int2Arr[i].length; j++) {
                int2Arr[i][j] = (i + 1) * (j + 1);
            }
        }
        printArray(int2Arr);
        System.out.println("*********************************");
        changeArray(int2Arr);
        printArray(int2Arr);
        System.out.println("*********************************");
    }

    private static void exercise_12_7() {
        int[][] int2Arr = new int[5][5];

        for (int i = 0; i < int2Arr.length; i++) {
            for (int j = 0; j < int2Arr[i].length; j++) {
                int2Arr[i][j] = i * (j + 1);
            }
        }
        System.out.println(Arrays.toString(choseCol(int2Arr, 1)));
    }

    private static void programmeringuppgift_12_1() {
        String[] names = new String[6];
        int[][] grade = new int[6][5];

        try (Scanner sc = new Scanner(new File("resources/files/exam.txt"))) {
            String name;
            int row = 0, col = 0;
            double avgStudent = 0;
            double totalAvgAllStudents = 0;

            while (row < names.length) {
                while (sc.hasNextLine()) {
                    name = sc.nextLine();
                    names[row] = name;
                    while (sc.hasNextInt())
                        grade[row][col++] = sc.nextInt();
                    sc.nextLine();
                    row++;
                    col = 0;
                }
            }


            for (int i = 0; i < names.length; i++) {
                avgStudent = avgStudent(grade, i);
                System.out.println("Student " + names[i] + " received avg grade of: " + avgStudent);
                totalAvgAllStudents += avgStudent;
            }
            System.out.println("*********************************");
            System.out.println("Total avg. all students: " + String.format("%.2f", totalAvgAllStudents / names.length));
            System.out.println("*********************************");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void programmeringuppgift_12_2() {
        int[][] int2Arr = new int[4][4];

        for (int i = 0; i < int2Arr.length; i++) {
            for (int j = 0; j < int2Arr[i].length; j++) {
                int2Arr[i][j] = (i + 1) * (j + 1);
            }
        }
        if (symmetrisk(int2Arr))
            System.out.println("Symmetric!");
        else
            System.out.println("NOT Symmetric!");
    }

    private static void programmeringuppgift_12_3() {
        int[][] int2Arr = {{16, 9, 2, 7}, {6, 3, 12, 13}, {11, 14, 5, 4}, {1, 8, 15, 10}};
        if (magical(int2Arr))
            System.out.println("Magical!");
        else
            System.out.println("NOT Magical!");
    }

    private static boolean magical(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }

        int totSumRow = -1;
        for (int i = 0; i < a.length; i++) {
            int sumRow = 0;
            for (int j = 0; j < a[i].length; j++) {
                if (a.length != a[i].length)
                    return false;
                sumRow += a[i][j];
            }
            if(totSumRow == -1) {
                totSumRow = sumRow;
                continue;
            }
            if(sumRow != totSumRow)
                return false;
        }
        return true;
    }

    private static boolean symmetrisk(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++)
                if((a.length != a[i].length) || (a[i][j] != a[j][i]))
                    return false;
        }
        return true;
    }

    private static double avgStudent(int[][] grade, int i) {
        double studentTot = 0;
        int counter = 0;

        for (int col : grade[i]) {
            studentTot += col;
            ++counter;
        }
        return studentTot / counter;
    }

    private static int[] choseCol(int[][] a, int col) {
        int[] b = new int[a[col].length];
        for (int i = 0; i < a[col].length; i++)
            b[i] = a[i][col];
        return b;
    }

    private static void printArray(int[][] a) {
        for (var row : a) {
            for (int col : row)
                System.out.print(col + "\t");
            System.out.println();
        }
    }

    private static void changeArray(int[][] a) {
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[i].length; j++)
                a[i][j] = i + j;
    }

    private static double colSum(double[][] a, int k) {
        double totSum = 0;

        for (int i = 0; i < a.length; i++) {
            totSum += a[i][k];
        }
        return totSum;
    }
}
