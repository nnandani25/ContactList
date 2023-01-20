/**
 * A class that stores subclasses of Person as a contact list.
 * The user is presented with a menu of options and may add, sort,
 * search, or list the contacts.
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick
 * @version: 2022-2023
 */

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactList
{
    // TODO: Create your array contacts
    private ArrayList<Person> contacts;
    // TODO: Write a Constructor
    public ContactList()
    {
        contacts = new ArrayList<Person>();
    }

    public void printMenuOptions()
    {
        System.out.println("Menu: ");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search by Phone Number");
        System.out.println("0. Exit");
    }

    /**
     * Asks user for input to create and add a new Person
     * to the contact list
     */
    public void addContact()
    {
        // TODO: Complete the addContact method
        // Asks the user to pick if they want to add a student or an athlete.
        Scanner input = new Scanner(System.in);
        System.out.println("Select the type of contact to add:\n1. Student" +
                "\n2.Athlete");
        int output = input.nextInt();
        input.nextLine();

        // If the user does not enter a 1 or a 2, it asks them again until they enter a valid number.
        while(output != 1 && output != 2)
        {
            System.out.println("Select the type of contact to add:\n1. Student" +
                    "\n2.Athlete");
            output = input.nextInt();
            input.nextLine();
        }

        // If the user enters a one, it prompts the user for more information and adds the student to the array.
        if (output == 1)
        {
            // Asks the user for the information needed to make a student.
            System.out.println("Please fill out the following information.\nFirst Name:");
            String firstName = input.nextLine();
            System.out.println("Last Name:");
            String lastName = input.nextLine();
            System.out.println("Phone Number:");
            String phoneNumber = input.nextLine();
            System.out.println("Grade:");
            int grade = input.nextInt();
            input.nextLine();

            // Creates a new student object and adds it to the arraylist contacts.
            Person student = new Student(firstName, lastName, phoneNumber, grade);
            contacts.add(student);
        }

        // if the user enters 2, they are prompted with questions specific ot an athlete.
        else
        {
            // Asks the user to enter information needed to make an athlete.
            System.out.println("Please fill out the following information.\nFirst Name:");
            String firstName = input.nextLine();
            System.out.println("Last Name:");
            String lastName = input.nextLine();
            System.out.println("Phone Number:");
            String phoneNumber = input.nextLine();
            System.out.println("Sport:");
            String sport = input.nextLine();
            System.out.println("Jersey Number:");
            int jerseyNumber = input.nextInt();
            input.nextLine();
            // Makes an athlete object with the information the user entered and adds it to the contact list.
            Person athlete = new Athlete(firstName, lastName, phoneNumber, sport, jerseyNumber);
            contacts.add(athlete);
        }
    }

    /**
     * Loops through and prints all contacts
     */
    public void printContacts()
    {
        // TODO: Complete the printContacts method
        // Loops through the arraylist contacts and prints each person.
        for(Person person: contacts)
        {
            System.out.println(person);
        }
    }

    /**
     * Bubble sorts the contacts in the list by firstName,
     * lastName, or phoneNumber
     * @param sortBy: 0=firstName, 1=lastName, 2=phoneNumber
     */
    public void sort(int sortBy) {
        // TODO: Complete the sort method
        // creates a variable which is equal to the size of the contact list
        int n = contacts.size();

        // If the user enters a 0, it sorts the contact list by first name.
        if(sortBy == 0)
        {
            // Goes through contact list, starting at 1.
            for(int i = 1; i < n; i++)
            {
                /**
                 * Goes through the contact list minus i, because on each pass, 1 more card is sorted, so you wouldn't
                 * need to keep on looping through cards that were already sorted.
                 */
                for(int j = 0; j < n - i; j++)
                {
                    /**
                     * If the first name of the person is alphabetically lower than the person next in the list than it
                     * switches them.
                     */
                    if(contacts.get(j).getFirstName().compareToIgnoreCase(contacts.get(j+1).getFirstName()) > 0 )
                    {
                        // Switches the person with the next person in the list.
                        Person person = contacts.get(j);
                        contacts.set(j, contacts.get(j+1));
                        contacts.set(j+1, person);
                    }

                }
            }

        }

        // If the user enters a 1, it will sort the contact list by last name, and goes through the same process as above.
        if(sortBy == 1)
        {
            for(int i = 1; i < n; i++)
            {
                for(int j = 0; j < n - i; j++)
                {
                    if(contacts.get(j).getLastName().compareToIgnoreCase(contacts.get(j+1).getLastName()) > 0 )
                    {
                        // Switches the person with the next person in the list.
                        Person person = contacts.get(j);
                        contacts.set(j, contacts.get(j+1));
                        contacts.set(j+1, person);
                    }

                }
            }

        }

        // If the user enter 2, it sorts the contact list by phone number and goes through the same process as above.
        if(sortBy == 2)
        {
            for(int i = 1; i < n; i++)
            {
                for(int j = 0; j < n - i; j++)
                {
                    if(contacts.get(j).getPhoneNumber().compareToIgnoreCase(contacts.get(j+1).getPhoneNumber()) > 0 )
                    {
                        // Switches the person with the next person in the list.
                        Person person = contacts.get(j);
                        contacts.set(j, contacts.get(j+1));
                        contacts.set(j+1, person);
                    }

                }
            }

        }
    }

    // TODO: Write searchByFirstName
    // Searches through the contact list based on the first name it is given.
    public String searchByFirstName(String firstName)
    {
        // Loops through the contact list.
        for(int i = 0; i < contacts.size(); i++)
        {
            // Checks if the first name of the contact the loop is currently on is equal to the first name the user entered.
            if (contacts.get(i).getFirstName().equalsIgnoreCase(firstName))
            {
                // If they are equal, it returns the contact.
                return contacts.get(i).toString();

            }
        }

        // If the name was not found, it tells the user.
        return firstName + " was not found in the list.";
    }


    // TODO: Write searchByLastName
    // Searches through the contact list based on the last name it is given.
    public String searchByLastName(String lastName)
    {
        // Loops through the contact list.
        for(int i = 0; i < contacts.size(); i++)
        {
            // Checks if the last name of the contact the loop is currently on is equal to the last name the user entered.
            if (contacts.get(i).getLastName().equalsIgnoreCase(lastName))
            {
                // If they are equal, it returns the contact.
                return contacts.get(i).toString();
            }
        }
        // If the name was not found, it tells the user.
        return lastName + " was not found in the list.";
    }

    // TODO: Write searchByPhoneNumber
    // Searches through the contact list based on the phone number it is given.
    public String searchByPhoneNumber(String phoneNumber)
    {
        // Loops through the contact list.
        for(int i = 0; i < contacts.size(); i++)
        {
            // Checks if the phone number of the contact the loop is currently on is equal to the phone number the user entered.
            if (contacts.get(i).getPhoneNumber().equals(phoneNumber))
            {
                // If they are equal, it returns the contact.
                return contacts.get(i).toString();
            }
        }
        // If the phone number was not found, it tells the user.
        return phoneNumber + " was not found in the list.";

    }

    /**
     * Lists just the Student objects in the Contact List
     */
    public void listStudents()
    {
        // TODO: Complete the listStudents method
        // Loops through the contacts arrayList.
        for(int i = 0; i < contacts.size(); i++)
        {
            // Checks if the contact it is on is a Student and prints it out if it is.
            if(contacts.get(i) instanceof Student)
            {
                // Prints out the contact is it is a Student.
                System.out.println(contacts.get(i));
            }
        }
    }

    /**
     * Loops providing menu options to the user
     * until the user exits
     */
    // TODO: Complete the run method
    public void run()
    {
        // Prompts the user.
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to your Contacts List");
        System.out.println("Please pick from the following menu options");
        printMenuOptions();
        int choice = input.nextInt();
        input.nextLine();

        // Loops through until the user presses 0 and lets the user pick the number they want to choose.
        while(choice != 0)
        {
            if(choice == 1)
            {
                // Calls addContact.
                addContact();
            }

            else if(choice == 2)
            {
                // Calls the sort and the printContacts method.
                sort(0);
                printContacts();
            }

            else if(choice == 3)
            {
                // Calls the sort and the print Contacts method.
                sort(1);
                printContacts();
            }

            else if(choice == 4)
            {
                // Calls the sort and the print Contacts method.
                sort(2);
                printContacts();

            }

            else if(choice == 5)
            {
                // Calls the listStudents method.
                listStudents();
            }

            else if(choice == 6)
            {
                // Prompts the user to enter a name and then uses that as the parameters for the searchByFirstName method.
                input = new Scanner(System.in);
                System.out.println("Enter a first name: ");
                String name = input.nextLine();
                System.out.println(searchByFirstName(name));
            }

            else if(choice == 7)
            {
                // Prompts the user to enter a name and then uses that as the parameters for the searchByLastName method.
                input = new Scanner(System.in);
                System.out.println("Enter a last name: ");
                String lastName = input.nextLine();
                System.out.println(searchByLastName(lastName));
            }

            else if(choice == 8)
            {
                /**
                 * Prompts the user to enter a phone number and then uses that as the parameters for the
                 * searchByPhoneNumber method.
                 */
                input = new Scanner(System.in);
                System.out.println("Enter a phone number: ");
                String phoneNumber = input.nextLine();
                System.out.println(searchByPhoneNumber(phoneNumber));
            }

            // If the user prints an invalid number it tells them.
            else
            {
                System.out.println("Invalid Entry. Please try again: ");
            }

            // Repeats the prompt until the user enters 0.
            System.out.println("Please pick from the following menu options");
            printMenuOptions();
            choice = input.nextInt();
            input.nextLine();
        }
    }

    public static void main(String[] args)
    {
        ContactList cl = new ContactList();
        cl.run();
    }
}
