/**
 * A class representing a docent
 */
public final class Docent extends Person {
    private int faculty;

    /**
     * Constructs a {@code Docent} with the given name, gender and faculty number
     * @param name name of the docent, must not be empty
     * @param gender gender of the docent, must be either 'm', 'f' or 'd'
     * @param faculty faculty number of the docent, must be between 1 and 6
     * @throws IllegalArgumentException if {@code faculty} or {@code gender} is invalid, or {@code name} is an empty string
     * @throws NullPointerException if {@code name} is null
     */
    public Docent(String name, char gender, int faculty) throws IllegalArgumentException, NullPointerException {
        super(name, gender);

        setFaculty(faculty);
    }

    /**
     * Constructs a {@code Docent} with the given name, gender and faculty number
     * @param name name of the docent, must not be empty
     * @param gender gender of the docent
     * @param faculty faculty number of the docent, must be between 1 and 6
     * @throws IllegalArgumentException if {@code faculty} is invalid, or {@code name} is an empty string
     * @throws NullPointerException if {@code name} is null
     */
    public Docent(String name, Gender gender, int faculty) throws IllegalArgumentException, NullPointerException {
        super(name, gender);

        setFaculty(faculty);
    }

    /**
     * Gets the faculty number of the docent
     * @return the faculty number of the docent
     */
    public int getFaculty() {
        return this.faculty;
    }

    /**
     * Sets the faculty number of the docent
     * @param faculty the new faculty number of the docent, must be between 1 and 6
     */
    public void setFaculty(int faculty) {
        if (faculty < 1 || faculty > 6)
            throw new IllegalArgumentException("Student number must be a positive integer with 6 digits");

        this.faculty = faculty;
    }

    @Override
    public String toString() {
        var formattedGender = this.getGender().toString();

        return "Docent: %s (%s) [Faculty: %d]".formatted(this.getName(), formattedGender, this.getFaculty());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Docent other)) return false;

        return super.equals(obj) && this.getFaculty() == other.getFaculty();
    }
}
