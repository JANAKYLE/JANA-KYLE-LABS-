import java.util.ArrayList;
import java.util.List;

public class Library {  // Library HAS Books; a Library is NOT a kind of Book
    private final List<String> books = new ArrayList<>();

    public void add(String title) { books.add(title); }
    public int size()             { return books.size(); }
    public List<String> titles()  { return new ArrayList<>(books); }  // defensive copy
}
