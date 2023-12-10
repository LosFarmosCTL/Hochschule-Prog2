import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var admin = new Administration(new Student("John Doe", 'm', 123456),
                new Student("Jane Doe", 'f', 654321),
                new Docent("John Doe", 'm', 1),
                new Docent("Jane Doe", 'f', 2),
                new Person("John Doe", 'm'),
                new Person("Jane Doe", 'f'));

        admin.sortList();
        admin.printList();

        Arrays.stream(admin.getDocents(1)).toList().forEach(System.out::println);
    }
}
