// An enum is a fixed set of constants. Each constant is an object.
public enum Priority {
    LOW(1, "Low"),
    MEDIUM(2, "Medium"),
    HIGH(3, "High");

    private final int level;                 // fields
    private final String label;

    Priority(int level, String label) {      // constructor (implicitly private)
        this.level = level;
        this.label = label;
    }

    public int getLevel() {
        return level;
    }

    public String getLabel() {
        return label;
    }

    public boolean isUrgent() {              // methods
        return this == HIGH;
    }

    public static Priority fromLevel(int level) {
        for (Priority p : values()) {
            if (p.level == level) {
                return p;
            }
        }
        throw new IllegalArgumentException("No priority with level " + level);
    }
}
