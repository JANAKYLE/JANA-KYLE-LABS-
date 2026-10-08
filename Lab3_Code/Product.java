public class Product {
    private final String name;
    private double price;  // invariant: price > 0
    private int stock;  // invariant: stock >= 0

    public Product(String name, double price, int stock) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name required");
        this.name = name;
        setPrice(price);
        setStock(stock);
    }

    public String getName()  { return name; }
    public double getPrice() { return price; }
    public int getStock()    { return stock; }

    public void setPrice(double price) {
        if (price <= 0)
            throw new IllegalArgumentException("Price must be greater than 0");
        this.price = price;
    }

    // private: only the class itself may set stock directly
    private void setStock(int stock) {
        if (stock < 0) throw new IllegalArgumentException("Stock cannot be negative");
        this.stock = stock;
    }

    public void sell(int quantity) {
        if (quantity <= 0)
            throw new IllegalArgumentException("Quantity must be greater than 0");
        if (quantity > stock)
            throw new IllegalArgumentException("Only " + stock + " in stock");
        stock -= quantity;
    }

    public void restock(int quantity) {
        if (quantity <= 0)
            throw new IllegalArgumentException("Quantity must be greater than 0");
        stock += quantity;
    }
}
