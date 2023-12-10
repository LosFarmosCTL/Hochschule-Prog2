/**
 * A class representing a student
 */
public final class Student extends Person {
    private final int studentNumber;

    /**
     * Constructs a {@code Student} with the given name, gender and student number
     * @param name name of the student, must not be empty
     * @param gender gender of the student, must be either 'm', 'f' or 'd'
     * @param studentNumber student number of the student, must be a positive 6-digit integer
     * @throws IllegalArgumentException if {@code studentNumber} or {@code gender} is invalid, or {@code name} is an empty string
     * @throws NullPointerException if {@code name} is null
     */
    public Student(String name, char gender, int studentNumber) throws IllegalArgumentException, NullPointerException {
        super(name, gender);

        if (studentNumber < 100000 || studentNumber > 999999)
            throw new IllegalArgumentException("Student number must be a positive integer with 6 digits");

        this.studentNumber = studentNumber;
    }

    /**
     * Constructs a {@code Student} with the given name, gender and student number
     * @param name name of the student, must not be empty
     * @param gender gender of the student
     * @param studentNumber student number of the student, must be a positive 6-digit integer
     * @throws IllegalArgumentException if {@code studentNumber} is invalid, or {@code name} is an empty string
     * @throws NullPointerException if {@code name} is null
     */
    public Student(String name, Gender gender, int studentNumber) throws IllegalArgumentException, NullPointerException {
        super(name, gender);

        if (studentNumber < 100000 || studentNumber > 999999)
            throw new IllegalArgumentException("Student number must be a positive integer with 6 digits");

        this.studentNumber = studentNumber;
    }

    /**
     * Gets the student number of the student
     * @return the student number of the student
     */
    public int getStudentNumber() {
        return this.studentNumber;
    }

    @Override
    public String toString() {
        var formattedGender = this.getGender().toString();

        return "Student: %s (%s) [%d]".formatted(this.getName(), formattedGender, this.getStudentNumber());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Student other)) return false;

        return super.equals(obj) && this.getStudentNumber() == other.getStudentNumber();
    }
}
