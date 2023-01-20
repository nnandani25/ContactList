public class Athlete extends Person
{
    private String sport;
    private int jerseyNumber;

    // Constructor which has the same variables as the person class, but with sport and jerseyNumber added.
    public Athlete(String firstName, String lastName, String phoneNumber, String sport, int jerseyNumber)
    {
        // Calls superclass constructor.
        super(firstName, lastName, phoneNumber);
        this.sport = sport;
        this.jerseyNumber = jerseyNumber;
    }

    // Returns the sport.
    public String getSport()
    {
        return sport;
    }

    // Returns the jerseyNumber.
    public int getJerseyNumber()
    {
        return jerseyNumber;
    }

    // Overrides the person class and calls its toString, but adds on the Sport and Jersey Number.
    @Override
    public String toString()
    {
        return super.toString() + " Sport: " + sport + " Jersey:" + jerseyNumber;
    }
}
