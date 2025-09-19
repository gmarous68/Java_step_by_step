public class Elevator {
    private int level;
    private final int MIN_LEVEL = -2;
    private final int MAX_LEVEL = 10;

    public Elevator(int level) {
        setLevel(level);
    }

    public void setLevel(int level) {
        try {
            checkValidLevel(level);
            this.level = level;
        } catch(IllegalArgumentException e) {
            System.out.println("Only levels between -2 & 10 allowed!");
        }
    }

    public int where() {
        return this.level;
    }

    public void goTo(int elevator, int level) {
        try {
            checkValidLevel(level);

            if (level == this.level) {
                System.out.println("Elevator " + elevator + " already att level " + level);
                return;
            }
            String s = "Elevator " + elevator + " is moving";
            s += (level < this.level) ? " down to level " : " up to level ";
            System.out.println(s + level);
            this.level = level;
        } catch(IllegalArgumentException e) {
            System.out.println("Trying to move elevator " + elevator + " to level " + level
                    + ", but only levels between -2 & 10 allowed!");
        }
    }

    public void checkValidLevel(int level) {
        if(level < MIN_LEVEL || level > MAX_LEVEL)
            throw new IllegalArgumentException();
    }
}