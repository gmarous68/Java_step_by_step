import javax.swing.JOptionPane;
import java.util.UnknownFormatConversionException;


public class Inlämningsuppgift_1 {

    public static void del_1() {
        /**
         * Beräkna kostnaden för fönstren beroende på deras storlek.
         * Kostnaden beräknas med formeln: Kostnad = Bredd(m) * Höjd(m) * Pris per kvadratmeter(kr/m2)
         * Beräknar kostnaden för ett fönster baserat på användarens inmatningar om fönstrets bredd,
         * höjd och pris per kvadratmeter, och rabatt beroende på den totala kostnaden.
         */

        try {
            double bredd = Double.parseDouble(JOptionPane.showInputDialog("Tast in bredd i meter på fönstret: "));
            double höjd = Double.parseDouble(JOptionPane.showInputDialog("Tast in höjd i meter på fönstret: "));
            double prisPerKvadrat =
                    Double.parseDouble(JOptionPane.showInputDialog("Tast in priset per kvadratmeterglas (i kr/m²: "));

            double KostUtanRabatt = bredd * höjd * prisPerKvadrat;
            int rabatt = (KostUtanRabatt > 5000) ? 25 : (KostUtanRabatt > 2500) ? 10 : 5;
            double KostMedRabatt = KostUtanRabatt - (KostUtanRabatt * rabatt / 100);

            String result = "Bredd: " + String.format("%.2f", bredd) + " meter\n" +
                    "Höjd: " + String.format("%.2f", höjd) + " meter\n" +
                    "Pris per kvadratmeter: " + String.format("%.2f", prisPerKvadrat) + " kr\n" +
                    "Ursprunglig kostnad:  " + String.format("%.2f", KostUtanRabatt) + " kr\n" +
                    "Rabatt: " + rabatt + "%\n" +
                    "Slutkostnad: " + String.format("%.2f", KostMedRabatt) + " kr";
            JOptionPane.showMessageDialog(null, result);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Cancelled operation!");
        } catch (NumberFormatException | UnknownFormatConversionException e) {
            JOptionPane.showMessageDialog(null, "Wrong format!");
        }
    }


    public static void del_2() {
        /**
         * Skapa en enkel miniräknare som beräknar de fyra räknesätten
         */
        String op1 = "", op2 = "", message = "";
        boolean isTrue = true;
        int idx = 0;
        char operator = ' ';

        //try/catch - if cancel or x pressed
        try {
            while (true) {
                String output = "Tast in två operander med en operator i mellan som beskrevet nedanför\n"
                        + "\"Giltiga uttryck: 1+2 , -200-100 , 2*5.5 , 10/2\"";
                String input = JOptionPane.showInputDialog(output);

                if (!checkForIllegallity(input)) {
                    message = "Illegal input! Tast y for att fortsätta?";
                    isTrue = JOptionPane.showInputDialog(message).equalsIgnoreCase("y");

                    // decide to continue or not
                    if (isTrue) continue;
                    else break;
                }

                // if everything ok - start here to subtract characters
                // first character might be '-': is allowed and start while loop below at idx 1
                if (input.charAt(0) == '-') {
                    op1 += input.charAt(0);
                    idx = 1;
                }

                while (idx < input.length()) {
                    // read digits until it reaches operator and assign operand 1
                    if (Character.isDigit(input.charAt(idx)) || input.charAt(idx) == '.') {
                        op1 += input.charAt(idx);
                        idx++;
                    } else {
                        // after digit - an operator is considered present in idx
                        operator = input.charAt(idx);
                        break;
                    }
                }
                // extract and assume the rest are digits - operand 2
                op2 = input.substring(idx + 1);

                // convert string values to double in order to compute
                int operand1 = Integer.parseInt(op1);
                int operand2 = Integer.parseInt(op2);
                double sum = 0;

                // figure out the operator to compute with and calculate sum
                switch(operator) {
                    case '+' -> sum = operand1 + operand2;
                    case '-' -> sum = operand1 - operand2;
                    case '*' -> sum = operand1 * operand2;
                    case '/' -> sum = operand1 / operand2;
                    default -> {
                        JOptionPane.showMessageDialog(null, "Not able to compute!");
                        return;
                    }
                }
                message = "Sum of " + operand1 + " " + operator + " " + operand2 + " = " + sum;
                JOptionPane.showMessageDialog(null, message);
                break;
            }
        } catch (NullPointerException e) {
            // if pressed cancel or x
            JOptionPane.showMessageDialog(null, "Cancelled operation!");

        } catch (ArithmeticException e) {
            // if divided by 0
            JOptionPane.showMessageDialog(null, "Division by 0 not allowed!");
        }
    }

    public static boolean checkForIllegallity(String s) {
        // check för tom string
        if (s.isEmpty()) {
            JOptionPane.showMessageDialog(null, "String is empty!");
            return false;
        }

        // check if exist > 1 operator (not in charAt(0) pos)
        int NoOfOperators = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // string starts with minus - allowed and not counted in total NoOfOperators
            if (i == 0 && (c == '-'))
                continue;

            // Modulus not allowed
            if (c == '%') {
                JOptionPane.showMessageDialog(null, "Modulus not allowed!");
                return false;
            }

            if (c == '+' || c == '-' || c == '*' || c == '/') {
                NoOfOperators++;
            }
        }
        // If no operator or more than one operator
        if (NoOfOperators != 1) {
            JOptionPane.showMessageDialog(null, "No of operator is 0 or exceeds 1!");
            return false;
        }
        return true;
    }
}
