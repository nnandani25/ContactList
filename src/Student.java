/**
 * A subclass of Person that represents a Student
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick
 * @version: 2022-2023
 */

public class Student extends Person
{
    // TODO: Modify and complete this class
    private int grade;

    // Constructor which takes in the same parameters as person, but with a grade.
    public Student(String firstName, String lastName, String phoneNumber, int grade)
    {
        // Calls the superclass constructor for the common variables.
        super(firstName, lastName, phoneNumber);
        this.grade = grade;
    }

    // Returns the grade.
    public int getGrade()
    {
        return grade;
    }

    // Overrides the old method, so when a Student object is made and printed out, it will print this.
    @Override
    public String toString()
    {
        // Calls the superclass constructor, and it also prints out the grade.
        return super.toString() + " Grade: " + grade;
    }
}
