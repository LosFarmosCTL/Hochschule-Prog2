import java.util.Arrays;

/**
 * A class representing a school administration, keeping a list of students and staff
 */
public class Administration implements AdministrationInterface {
    private final Person[] persons;

    /**
     * Constructs an {@code Administration} with the given list of persons
     * @param persons list of persons
     * @throws NullPointerException if {@code persons} is null
     */
    public Administration(Person... persons) throws NullPointerException {
        if (persons == null)
            throw new NullPointerException("List of persons cannot be null");

        this.persons = persons;
    }

    /**
     * Sorts all persons in ascending order by name, using bubble sort
     * The internal array is modified!
     * @return a copy of the sorted array
     * @throws IllegalStateException if the internal array of persons is empty
     */
    @Override
    public Person[] sortList() throws IllegalStateException {
        if (persons.length == 0)
            throw new IllegalStateException("Array of persons cannot be empty");

        for (int i = 0; i < persons.length - 1; i++) {
            for (int j = 0; j < persons.length - i - 1; j++) {
                var current = persons[j];
                var next = persons[j + 1];

                boolean shouldSwap = current.compareTo(next) > 0;
                if (shouldSwap) {
                    var temp = persons[j];
                    persons[j] = persons[j + 1];
                    persons[j + 1] = temp;
                }
            }
        }

        return persons.clone();
    }

    /**
     * Counts the number of female students
     * @return the number of female students
     * @throws IllegalStateException if the internal array of persons is empty
     */
    @Override
    public int countFemale() throws IllegalStateException {
        if (persons.length == 0)
            throw new IllegalStateException("List of persons cannot be empty");

        var count = 0;
        for (Person person : persons) {
            var isStudent = person instanceof Student;
            var isFemale = person.getGender() == Person.Gender.FEMALE;

            if (isStudent && isFemale)
                count++;
        }

        return count;
    }

    /**
     * Returns an array of docents working at the given department
     * @param department department number, must be between 1 and 6
     * @return the array of docents
     * @throws IllegalStateException if the array of persons is empty
     * @throws IllegalArgumentException if the department number is invalid
     */
    @Override
    public Docent[] getDocents(int department) throws IllegalStateException, IllegalArgumentException {
        if (persons.length == 0)
            throw new IllegalStateException("Array of persons cannot be empty");
        if (department < 1 || department > 6)
            throw new IllegalArgumentException("Department number must be between 1 and 6");

        var docents = new Docent[0];
        for (Person person : persons) {
            if (!(person instanceof Docent docent)) continue;
            if (docent.getFaculty() != department) continue;

            docents = Arrays.copyOf(docents, docents.length + 1);
            docents[docents.length - 1] = docent;
        }

        return docents;
    }

    /**
     * Prints the given array of persons on the console
     * @param list array of persons, must not be null
     * @throws NullPointerException if {@code list} is null
     */
    @Override
    public void printList(Person[] list) throws NullPointerException {
        new Administration(list).printList();
    }

    /**
     * Prints the internal array of persons on the console
     */
    public void printList() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        var builder = new StringBuilder();
        for (Person person : persons) {
            builder.append(person).append("\n");
        }

        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Administration other)) return false;

        if (this.persons.length != other.persons.length) return false;

        // compare all individual persons
        for (int i = 0; i < this.persons.length; i++)
            if (!this.persons[i].equals(other.persons[i]))
                return false;

        return true;
    }
}
