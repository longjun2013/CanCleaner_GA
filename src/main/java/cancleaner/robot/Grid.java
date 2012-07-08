package cancleaner.robot;

public class Grid {
    private boolean hasCan;

    public boolean hasCan() {
        return hasCan;
    }

    public void setHasCan(boolean hasCan) {
        this.hasCan = hasCan;
    }

    public void cleanCan() {
        this.hasCan = false;
    }
}
