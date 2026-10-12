import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Outer class that demonstrates all four kinds of nested type
public class Library {
    private static int libraryCount = 0;            // static: belongs to the class
    private final String name;
    private final List<String> books = new ArrayList<>();

    public Library(String name) {
        this.name = name;
        libraryCount++;
    }

    public void addBook(String title) {
        books.add(title);
    }

    // 1. STATIC NESTED CLASS: no outer instance needed, sees only outer statics
    public static class Settings {
        private final int loanDays;

        public Settings(int loanDays) {
            this.loanDays = loanDays;
        }

        public String describe() {
            return "Loan period " + loanDays + " days, libraries created: " + libraryCount;
        }
    }

    // 2. INNER (MEMBER) CLASS: every Member belongs to one Library object
    public class Member {
        private final String memberName;

        public Member(String memberName) {
            this.memberName = memberName;
        }

        public void borrow(String title) {
            if (books.remove(title)) {                  // reads the OUTER object's field
                System.out.println("  " + memberName + " borrowed '" + title + "' from " + name);
            } else {
                System.out.println("  '" + title + "' is not available in " + name);
            }
        }
    }

    // 3. LOCAL CLASS: declared inside a method, visible only there
    public List<String> titlesStartingWith(char letter) {
        class StartsWith {
            boolean accept(String title) {
                return !title.isEmpty()
                        && Character.toLowerCase(title.charAt(0)) == Character.toLowerCase(letter);
            }
        }
        StartsWith filter = new StartsWith();           // 'letter' is effectively final
        List<String> result = new ArrayList<>();
        for (String b : books) {
            if (filter.accept(b)) {
                result.add(b);
            }
        }
        return result;
    }

    // 4. ANONYMOUS CLASS: a one-off implementation with no name
    public List<String> sortedByLength() {
        List<String> copy = new ArrayList<>(books);
        copy.sort(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return Integer.compare(a.length(), b.length());
            }
        });
        return copy;
    }

    public int count() {
        return books.size();
    }
}
