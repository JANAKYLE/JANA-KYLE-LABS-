public class TempConverter {
    static final double OFFSET = 32.0;
    static final double RATIO  = 9.0 / 5.0;

    private TempConverter() { }  // utility class: no objects needed

    static double celsiusToFahrenheit(double c) {
        return c * RATIO + OFFSET;
    }

    static double fahrenheitToCelsius(double f) {
        return (f - OFFSET) / RATIO;
    }

    public static void main(String[] args) {
        System.out.println("100 C = " + celsiusToFahrenheit(100) + " F");
        System.out.println("212 F = " + fahrenheitToCelsius(212) + " C");
    }
}
