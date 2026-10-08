public class Person {
    private String name;
    private int age;  // invariant: 0 <= age <= 120

    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() { return name; }
    public int getAge()     { return age; }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be empty");
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0 || age > 120)
            throw new IllegalArgumentException("Age must be 0-120");
        this.age = age;
    }

    public void birthday() { setAge(age + 1); }
}
