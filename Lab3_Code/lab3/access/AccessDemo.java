package lab3.access;

public class AccessDemo {
    public    String publicField    = "public";  // everywhere
    // same package + subclasses anywhere
    protected String protectedField = "protected";
              String defaultField   = "default";  // same package only (no keyword)
    private   String privateField   = "private";  // this class only

    public void showAll() {  // inside the class: all four are visible
        System.out.println(publicField + " " + protectedField + " "
                         + defaultField + " " + privateField);
    }
}
