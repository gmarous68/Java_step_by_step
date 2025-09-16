public class Kapitel_14 {
    public static void app() {
        exercise_14_4();
    }

    private static void exercise_14_4() {
        Name n1 = new Name();
        n1.setName("Annie", "Hall");
        System.out.println(n1);

        n1.setName("Hall, Annie");
        System.out.println(n1);

        n1.setName("Hall, Annie", '!');
        System.out.println(n1);
    }
}

class Name {
    private String fName;
    private String lName;
    private char end;

    public void setName(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    public void setName(String name) {
        int k = name.indexOf(',');
        if(k < 0)
            throw new IllegalArgumentException("Error in name input!");

        this.lName = name.substring(0, k).trim();
        this.fName = name.substring(k+1).trim();
    }

    public void setName(String name, char end) {
        setName(name);
        this.end = end;
    }

    @Override
    public String toString() {
        return (end == '\u0000') ? "First name: " + fName + ", Last name: " + lName :
                "First name: " + fName + ", Last name: " + lName  + end;
    }
}
