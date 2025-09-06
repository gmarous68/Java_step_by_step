import javax.swing.JOptionPane;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.UnknownFormatConversionException;


public class Inlämningsuppgift_1 {
    public static void main(String[] args) {
//        del_1();
        del_2();
    }

    private static void del_1() {
        /**
         * Beräkna kostnaden för fönstren beroende på deras storlek.
         * Kostnaden beräknas med formeln: Kostnad = Bredd(m) * Höjd(m) * Pris per kvadratmeter(kr/m2)
         * Beräknar kostnaden för ett fönster baserat på användarens inmatningar om fönstrets bredd,
         * höjd och pris per kvadratmeter, och rabatt beroende på den totala kostnaden.
         */

        boolean tryAgain = true;
        while (tryAgain) {
            try {
                double width = Double.parseDouble(JOptionPane.showInputDialog("Tast in bredd i meter på fönstret: "));
                double hight = Double.parseDouble(JOptionPane.showInputDialog("Tast in höjd i meter på fönstret: "));
                double priceSqrMeters =
                        Double.parseDouble(JOptionPane.showInputDialog("Tast in priset per kvadratmeterglas (i kr/m²: "));
                tryAgain = false;

                double KostUtanRabatt = width * hight * priceSqrMeters;
                int rabatt = (KostUtanRabatt > 5000) ? 25 : (KostUtanRabatt > 2500) ? 10 : 5;
                double CostWithDiscount = KostUtanRabatt - (KostUtanRabatt * rabatt / 100);

                String result = "Bredd: " + String.format("%.2f", width) + " meter\n" +
                        "Höjd: " + String.format("%.2f", hight) + " meter\n" +
                        "Pris per kvadratmeter: " + String.format("%.2f", priceSqrMeters) + " kr\n" +
                        "Ursprunglig kostnad:  " + String.format("%.2f", KostUtanRabatt) + " kr\n" +
                        "Rabatt: " + rabatt + "%\n" +
                        "Slutkostnad: " + String.format("%.2f", CostWithDiscount) + " kr";
                JOptionPane.showMessageDialog(null, result);

            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Cancelled operation!");
            } catch (NumberFormatException | UnknownFormatConversionException | InputMismatchException e) {
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
        String op1 = "", op2 = "";
        char operator = ' ';
        int option = -1;

        //try/catch - if cancel or x pressed, or zero division/parse errors
        try {
            do {
                String output = "Tast in två operander med en operator i mellan som beskrevet nedanför\n"
                        + "\"Giltiga uttryck: 1+2 , -200-100 , 2*5.5 , 10/2\"";
                String input = JOptionPane.showInputDialog(output);

                // check for empty string
                if (input.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "String is empty!");
                    return;
                }

                // Replace comma with dot, and remove all whitespaces
                input = input.replace(",", ".");
                input = input.replace(" ", "");

                // Check for illegal operator and/or no of operators
                if (!checkIsValidOperators(input))
                    return;

                // if checkIsValidString = true, Build operators & operand
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

                // convert string values to double in order to compute
                double operand1 = Double.parseDouble(op1);
                double operand2 = Double.parseDouble(op2);
                double sum = 0;

                // figure out the operator to compute with and calculate sum
                switch (operator) {
                    case '+' -> sum = operand1 + operand2;
                    case '-' -> sum = operand1 - operand2;
                    case '*' -> sum = operand1 * operand2;
                    case '/' -> sum = operand1 / operand2;
                    default -> {
                        JOptionPane.showMessageDialog(null, "Not able to compute!");
                        return;
                    }
                }
                String message = "Sum of " + operand1 + " " + operator + " " + operand2 + " = " + sum;
                JOptionPane.showMessageDialog(null, message);

                // if yes - start over again
                option = JOptionPane.showConfirmDialog(null, "Nytt forsök? ");
            } while (option == JOptionPane.YES_OPTION);
        } catch (NullPointerException e) {
            // if pressed cancel or x
            JOptionPane.showMessageDialog(null, "Cancelled operation!");
        } catch (NumberFormatException e) {
            // if alpha characters in string to number parse
            JOptionPane.showMessageDialog(null, "Not able to parse to number!!");
        } catch (ArithmeticException e) {
            // if divided by 0
            JOptionPane.showMessageDialog(null, "Division by 0 not allowed!");
        }
    }

    private static boolean checkIsValidOperators(String input) {
        int NoOfOperators = 0;

        // Modulus not allowed
        if (input.contains("%")) {
            JOptionPane.showMessageDialog(null, "Modulus not allowed!");
            return false;
        }

        // count the number of operators - only 1 allowed
        for (int i = 0; i < input.length(); i++) {
            // first character might be '-' = is allowed. Not counted in total
            if (i == 0 && input.charAt(i) == '-')
                continue;

            switch (input.charAt(i)) {
                case '*':
                case '/':
                case '-':
                case '+':
                    NoOfOperators++;
            }
        }

        // No of operator found in string is 0 or > 1
        if (NoOfOperators != 1) {
            JOptionPane.showMessageDialog(null, "No of operator is 0 or exceeds 1!");
            return false;
        }
        return true;
    }
}
