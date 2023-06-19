public class Person {
    private final String name;
    private final String id;
    private final int age;

    public Person(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    @Override
    public String toString() {
        return "\nName: " +
                name + "\nID: " +
                id + "\nAge: " +
                age ;
    }
    
}
