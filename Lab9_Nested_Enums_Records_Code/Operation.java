// Constant-specific behaviour: each constant supplies its own apply()
public enum Operation {
    ADD("+") {
        @Override
        public double apply(double a, double b) {
            return a + b;
        }
    },
    MULTIPLY("*") {
        @Override
        public double apply(double a, double b) {
            return a * b;
        }
    },
    POWER("^") {
        @Override
        public double apply(double a, double b) {
            return Math.pow(a, b);
        }
    };

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public abstract double apply(double a, double b);
}
