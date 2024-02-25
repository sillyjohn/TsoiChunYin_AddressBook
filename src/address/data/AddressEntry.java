package address.data;

/**
 * AddressEntry Class contains information of each contact
 */
public class AddressEntry implements Comparable<AddressEntry> {
    /**
     * First name of the entry
     */
    private String firstName = "";
    /**
     * Last name of the entry
     */
    private String lastName = "";
    /**
     * Street name of the entry
     */
    private String street = "";
    /**
     * City name of the entry
     */
    private String city = "";
    /**
     * State name of the entry
     */
    private String state = "";
    /**
     * Zip Code of the entry
     */
    private int zip = 0;
    /**
     * Phone number of the entry
     */
    private String phone = "";
    /**
     * Email Address of the entry
     */
    private String email = "";

    /**
     * Default constructor of the AddressEntry
     */
    public AddressEntry(){

    }

    /**
     * Constructor for the AddressEntry Class, with 8 parameters.
     *
     * @param firstName     Input to initialize firstName attribute in AddressEntry Class
     * @param lastName      Input to initialize lastName attribute in AddressEntry Class
     * @param street        Input to initialize street attribute in AddressEntry Class
     * @param city          Input to initialize city attribute in AddressEntry Class
     * @param state         Input to initialize state attribute in AddressEntry Class
     * @param zip           Input to initialize zip attribute in AddressEntry Class
     * @param phone         Input to initialize phone attribute in AddressEntry Class
     * @param email         Input to initialize email attribute in AddressEntry Class
     */
    public AddressEntry(String firstName, String lastName, String street, String city, String state, int zip, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    public int compareTo(AddressEntry other) {
        // Compare by lastName, then by firstName for tie-breaking
        int lastNameComp = this.lastName.compareTo(other.lastName);
        return (lastNameComp != 0) ? lastNameComp : this.firstName.compareTo(other.firstName);
    }

    /**
     * toString method to beautify and format output
     * @return FirstName LastName
     *         Street
     *         City, State Zip
     *         Email
     *         Phone
     */
    public String toString(){
        return  firstName + " " +lastName+"\n"+
                street + "\n" +
                city + ", " + state + " "+ zip +"\n"+
                email+"\n"+
                phone+"\n";
    }

    /**
     * Getter method for firstName attribute
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Getter method for lastName attribute
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Getter method for street attribute
     * @return street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Getter method for city attribute
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Getter method for state attribute
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * Getter method for zip attribute
     * @return zip
     */
    public int getZip() {
        return zip;
    }

    /**
     * Getter method for phone attribute
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Getter method for email attribute
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for firstName attributes
     * @param firstName A String input to set firstName attribute
     */
    //Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Setter method for lastName attributes
     * @param lastName A String input to set lastName attribute
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Setter method for street attributes
     * @param street A String input to set street attribute
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Setter method for city attributes
     * @param city A String input to set city attribute
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Setter method for state attributes
     * @param state A String input to set state attribute
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Setter method for zip attributes
     * @param zip An Int input to set zip attribute
     */
    public void setZip(int zip) {
        this.zip = zip;
    }

    /**
     * Setter method for phone attributes
     * @param phone A String input to set phone attribute
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Setter method for email attributes
     * @param email A String input to set email attribute
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
