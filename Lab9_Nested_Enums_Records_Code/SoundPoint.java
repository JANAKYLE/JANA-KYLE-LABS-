import java.util.Objects;

// Correct: equals, hashCode and toString use the same fields
public class SoundPoint {
    private final int x, y;

    public SoundPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                       // reflexive shortcut
        if (o == null || getClass() != o.getClass()) return false;
        SoundPoint other = (SoundPoint) o;
        return x == other.x && y == other.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);                        // same fields as equals
    }

    @Override
    public String toString() {
        return "SoundPoint(x=" + x + ", y=" + y + ")";
    }
}
