public class ShelfDemo {
    public static void main(String[] args) {
        Book[] shelf = new Book[3];          // array of references, all null

        shelf[0] = new Book();
        shelf[0].title = "Java Basics";
        shelf[0].price = 25.50;

        shelf[2] = new Book();
        shelf[2].title = "Data Structures";
        shelf[2].price = 30;

        for (int i = 0; i < shelf.length; i++) {
            if (shelf[i] != null) {          // avoid NullPointerException
                shelf[i].display();
            } else {
                System.out.println("Slot " + i + " is empty");
            }
        }
    }
}
