/**
 * A class that represents a Person
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick
 * @version: 2022-2023
 */

public class Person
{
    // TODO: Complete the Person class
    private String firstName;
    private String lastName;
    private String phoneNumber;

    // Constructor which takes in first and last name and the phone number.
    public Person(String firstName, String lastName, String phoneNumber)
    {
        this.firstName = firstName;
        this.lastName= lastName;
        this.phoneNumber = phoneNumber;
    }

    // Getters for the instance variables.
    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    // ToString method which prints out the contact of a person.
    public String toString()
    {
        return firstName.toUpperCase() + " " +  lastName.toUpperCase() + " - #" + phoneNumber;
    }
}
