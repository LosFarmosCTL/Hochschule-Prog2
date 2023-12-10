/**
 * A class representing a person
 */
public class Person implements Comparable<Person> {
    private String name;
    private Gender gender;

    /**
     * Constructs a {@code Person} with the given name and gender
     * @param name name of the person, must not be empty
     * @param gender gender of the person, must be either 'm', 'f' or 'd'
     * @throws NullPointerException if {@code name} is null
     * @throws IllegalArgumentException if {@code name} is empty, or {@code gender} invalid
     */
    public Person(String name, char gender) throws NullPointerException, IllegalArgumentException {
        this.gender = Gender.fromChar(gender);
        setName(name);
    }

    /**
     * Constructs a {@code Person} with the given name and gender
     * @param name name of the person, must not be empty
     * @param gender gender of the person
     * @throws NullPointerException if {@code name} or {@code gender} is null
     * @throws IllegalArgumentException if {@code name} is empty
     */
    public Person(String name, Gender gender) throws NullPointerException, IllegalArgumentException {
        if (gender == null)
            throw new NullPointerException("Gender cannot be null");

        this.gender = gender;
        setName(name);
    }

    /**
     * Gets the name of the person
     * @return the name of the person
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the person
     * @param newName the new name of the person, must not be empty
     * @throws NullPointerException if {@code newName} is null
     * @throws IllegalArgumentException if {@code newName} is empty
     */
    public void setName(String newName) throws NullPointerException, IllegalArgumentException {
        if (newName == null) throw new NullPointerException("Name cannot be null");
        if (newName.isEmpty()) throw new IllegalArgumentException("Name cannot be empty");

        this.name = newName;
    }

    /**
     * Gets the gender of the person
     * @return the gender of the person
     */
    public Gender getGender() {
        return this.gender;
    }

    /**
     * Changes the gender of the person
     * @param newGender the new gender of the person, must be either 'm', 'f' or 'd'
     * @throws IllegalArgumentException if {@code newGender} is invalid
     */
    public void setGender(char newGender) throws IllegalArgumentException {
        gender = Gender.fromChar(newGender);
    }

    /**
     * Changes the gender of the person
     * @param newGender the new gender of the person
     * @throws NullPointerException if the new gender is {@code null}
     */
    public void setGender(Gender newGender) throws NullPointerException {
        if (newGender == null)
            throw new IllegalArgumentException("Gender cannot be null");

        gender = newGender;
    }

    @Override
    public String toString() {
        return "Person: %s (%s)".formatted(this.name, this.gender.toString());
    }

    @Override
    public int compareTo(Person other) {
        var nameComparison = this.name.compareTo(other.name);
        if (nameComparison != 0)
            return nameComparison;

        return gender.compareTo(other.gender);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj.getClass() != this.getClass()) return false;

        var other = (Person) obj;
        return this.name.equals(other.name) && this.gender == other.gender;
    }

    public enum Gender {
        MALE,
        FEMALE,
        DIVERSE;

        /**
         * Creates a {@code Gender} from a char
         * @param gender the char representation of the gender, must be either 'm', 'f' or 'd'
         * @throws IllegalArgumentException if {@code gender} is invalid
         */
        public static Gender fromChar(char gender) throws IllegalArgumentException {
            return switch (gender) {
                case 'm' -> MALE;
                case 'f' -> FEMALE;
                case 'd' -> DIVERSE;
                default -> throw new IllegalArgumentException("Gender must be one of 'm', 'f' or 'd'");
            };
        }

        public char toChar() {
            return switch (this) {
                case MALE -> 'm';
                case FEMALE -> 'f';
                case DIVERSE -> 'd';
            };
        }

        /**
         * Returns a {@code String} representing the gender, either "male", "female", or "diverse"
         * @return the {@code String} representation of the gender
         */
        @Override
        public String toString() {
            return switch (this) {
                case MALE -> "male";
                case FEMALE -> "female";
                case DIVERSE -> "diverse";
            };
        }
    }
}