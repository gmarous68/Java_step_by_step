import javax.swing.JOptionPane;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.UnknownFormatConversionException;


public class Inlämningsuppgift_1 {
    public static void main(String[] args) {
        del_1();
        del_2();
    }

    private static void del_1() {
        boolean tryAgain = true;
        while (tryAgain) {
            try {
                double width = Double.parseDouble(JOptionPane.showInputDialog("Tast in bredd i (meter) på fönstret: "));
                double height = Double.parseDouble(JOptionPane.showInputDialog("Tast in höjd (meter) på fönstret: "));
                double priceSqrMeters = Double.parseDouble(JOptionPane.showInputDialog("Tast in priset per kvadratmeterglas (kr/m²): "));

                // if parse above ok and end up here, then exit while loop after print result.
                // Otherwise program triggers catch statement and tryAgain is still true.
                tryAgain = false;

                double CostWithoutDiscount = width * height * priceSqrMeters;
                int discount = (CostWithoutDiscount > 5000) ? 25 : (CostWithoutDiscount > 2500) ? 10 : 5;
                double CostWithDiscount = CostWithoutDiscount - (CostWithoutDiscount * discount / 100);

                String result = "Bredd: " + String.format("%.2f", width) + " meter\n" +
                        "Höjd: " + String.format("%.2f", height) + " meter\n" +
                        "Pris per kvadratmeter: " + String.format("%.2f", priceSqrMeters) + " kr\n" +
                        "Ursprunglig kostnad:  " + String.format("%.2f", CostWithoutDiscount) + " kr\n" +
                        "Rabatt: " + discount + "%\n" +
                        "Slutkostnad: " + String.format("%.2f", CostWithDiscount) + " kr";
                JOptionPane.showMessageDialog(null, result);

            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Cancelled operation!");
                System.exit(0);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Empty string!");
            } catch (UnknownFormatConversionException | InputMismatchException e) {
                JOptionPane.showMessageDialog(null, "Wrong format!");
            } catch (NoSuchElementException e) {
                System.exit(0);
            }
        }
    }

    private static void del_2() {
        /**
         * Skapa en enkel miniräknare som beräknar de fyra räknesätten
         */
        int option = -1;
        String op1, op2;
        char operator;

        do {
            operator = ' ';
            op1 = "";
            op2 = "";

            try {
                String output = "Tast in två operander med en operator i mellan som beskrevet nedanför\n"
                        + "\"Giltiga uttryck: 1+2 , -200-100 , 2*5.5 , 10/2\"";
                String input = JOptionPane.showInputDialog(output);

                if (!checkIsValid(input)) {
                    option = JOptionPane.YES_OPTION;
                    continue;
                }

                // Replace comma with dot, and remove all whitespaces
                input = input.replace(",", ".");
                input = input.replace(" ", "");

                for (int i = 0; i < input.length(); i++) {
                    // string starts with minus - allowed and not counted in total NoOfOperators
                    if (i == 0 && input.charAt(i) == '-') {
                        op1 += input.charAt(0);
                        continue;
                    }
                    // read digits until it reaches operator and assign operand 1
                    if (Character.isDigit(input.charAt(i)) || input.charAt(i) == '.') {
                        op1 += input.charAt(i);
                        continue;
                    }
                    // after digit(s) - operator is considered present in index i
                    operator = input.charAt(i);
                    // extract and assume the rest are digits - operand 2
                    op2 = input.substring(i + 1);
                    break;
                }

                double sum = calculate(op1, op2, operator);
                if(sum == -1) {
                    option = JOptionPane.YES_OPTION;
                    continue;
                }

                // Result
                String message = "Sum of " + op1 + " " + operator + " " + op2 + " = "
                        + String.format("%.2f", sum);
                JOptionPane.showMessageDialog(null, message);

                // if yes - start over again
                option = JOptionPane.showConfirmDialog(null, "Nytt forsök? ");
                if(option != 0) {
                    JOptionPane.showMessageDialog(null, "Cancelled operation!");
                    System.exit(0);
                }
            } catch (NullPointerException e) {
                // if pressed cancel or x
                JOptionPane.showMessageDialog(null, "Cancelled operation!");
                System.exit(0);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Not able to parse to number!!");
            } catch (ArithmeticException e) {
                // if divided by 0
                JOptionPane.showMessageDialog(null, "Division by 0 not allowed!");
            }
        } while (option == JOptionPane.YES_OPTION);
    }


    private static boolean checkIsValid(String input) {
        int NoOfOperators = 0;

        if (input.isEmpty()) {
            JOptionPane.showMessageDialog(null, "String is empty!");
            return false;
        }

        // Modulus not allowed
        if (input.contains("%")) {
            JOptionPane.showMessageDialog(null, "Modulus not allowed!");
            return false;
        }

        for (int i = 0; i < input.length(); i++) {
            // first character might be '-' = is allowed. Not counted in total
            if (i == 0 && input.charAt(i) == '-')
                continue;

            if(Character.isDigit(input.charAt(i)) || input.charAt(i) == '.')
                continue;

            if(Character.isLetter(input.charAt(i))) {
                JOptionPane.showMessageDialog(null, "Characters not allowed!");
                return false;
            }

            switch (input.charAt(i)) {
                case '*':
                case '/':
                case '-':
                case '+':
                    NoOfOperators++;
            }
        }
        if (NoOfOperators != 1) {
            JOptionPane.showMessageDialog(null, "No of operator is 0 or exceeds 1!");
            return false;
        }
        return true;
    }


    private static double calculate(String op1, String op2, char operator) {
        double sum = -1;

        if(op1.isEmpty() || op2.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Operand 1 or operand 2 is not set!");
            return sum;
        }

        double operand1 = Double.parseDouble(op1);
        double operand2 = Double.parseDouble(op2);

        switch (operator) {
            case '+' -> sum = operand1 + operand2;
            case '-' -> sum = operand1 - operand2;
            case '*' -> sum = operand1 * operand2;
            case '/' -> {
                if (operand2 == 0) throw new ArithmeticException();
                // if ArithmeticException not triggered in line above - normal sum operation with double
                sum = operand1 / operand2;
            }
            default ->
                JOptionPane.showMessageDialog(null, "Not able to compute!");
        }
        return sum;
    }
}
