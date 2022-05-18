package se.mspi.lab4.objects;

public class Shot {
    private final int x;
    private final float y;
    private final float r;
    private final boolean successful;

    public Shot(int x, float y, float r, boolean successful) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.successful = successful;
    }

    public boolean isSuccessful() {
        return successful;
    }

    @Override
    public String toString() {
        return String.format("x = %s, y = %s, r = %s, результат: %s", x, y, r, successful ? "попадание" : "промах");
    }

}
