// A record is ideal for simple data like one CSV row
public record Product(String name, String category, double price, int quantity) {

    public double value() {
        return price * quantity;
    }

    public String toCsv() {
        return name + "," + category + "," + price + "," + quantity;
    }

    // Throws IllegalArgumentException (NumberFormatException is a subclass) on bad input
    public static Product fromCsv(String line) {
        String[] f = line.split(",");
        if (f.length != 4) {
            throw new IllegalArgumentException("expected 4 fields but found " + f.length);
        }
        return new Product(f[0].trim(), f[1].trim(),
                Double.parseDouble(f[2].trim()), Integer.parseInt(f[3].trim()));
    }
}
