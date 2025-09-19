public class Inlämningsuppgift_3_del1 {
    public static void main(String[] args) {
        Elevator elev1 = new Elevator(3);
        Elevator elev2 = new Elevator(10);

        // Testa om level är satt i constructor för båda elevator 1 och 2
        if (elev1.where() != 0)
            System.out.println("Current location of elevator 1 is: " + elev1.where());
        if (elev2.where() != 0)
            System.out.println("Current location of elevator 2 is: " + elev2.where());
        System.out.println("*************************************\n");

        // Om level är satt i constructor (levels INTE 0), testa flytta levels upp och ner.
        // settLevel metod testar också om level är innanför -2 och 10
        if (elev1.where() != 0) {
            elev1.goTo(1,-3);
            elev1.goTo(1,3);
            System.out.println("Current location of elevator 1 is: " + elev1.where());
            System.out.println("*************************************\n");
        }

        if (elev2.where() != 0) {
            elev2.goTo(2,4);
            elev2.goTo(2,11);
            elev2.goTo(2,1);
            elev2.goTo(2,8);
            System.out.println("Current location of elevator 2 is: " + elev2.where());
            System.out.println("*************************************");
        }
    }
}