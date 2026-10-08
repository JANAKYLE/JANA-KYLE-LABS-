public class ProductDemo {
    public static void main(String[] args) {
        Product p = new Product("Notebook", 2.50, 10);
        p.sell(4);
        System.out.println(p.getName() + " stock = " + p.getStock());  // 6

        try { p.sell(20); }
        catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }

        try { p.setPrice(0); }
        catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }

        p.restock(14);
        System.out.println(p.getName() + " stock = " + p.getStock());  // 20
    }
}
