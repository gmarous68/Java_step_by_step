public class MyMath {
    public static double elevateTo(double x, int n) {
        double res = 1;
        int i = 1;

        if(n >= 0)
            for (; i<n; i++)
                res *= x;
        else
            for (; i<-n; i++)
                res /= x;

        return res;
    }

    public static double interestOnInterest(double amount, double interest, int year) {
        return amount * elevateTo(1 + 0.01 * interest, year);
    }

    public static double calculateWithdrawal(double amount, double interest, int year, double out) {
        if(out > amount * 0.01 * interest) {
            System.out.println("To big withdrawal!");
            return 0;
        }
        for (int i=10; i <=year ; i++) {
            amount = amount + amount * 0.01 * interest - out;
        }
        return amount;
    }
}
