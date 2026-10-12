// BUG ON PURPOSE: overrides equals() but NOT hashCode()
public class BrokenPoint {
    private final int x, y;

    public BrokenPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BrokenPoint other)) return false;
        return x == other.x && y == other.y;
    }
    // hashCode() is missing: equal objects get different hash codes
}
