package address.data;

public class AddressEntry implements Comparable<AddressEntry> {
    //Attributes
    private String firstName = "";
    private String lastName = "";
    private String street = "";
    private String city = "";
    private String state = "";
    private int zip = 0;
    private String phone = "";
    private String email = "";

    public AddressEntry(){

    }

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
    //ToString
    public String toString(){
        return  firstName + " " +lastName+"\n"+
                street + "\n" +
                city + ", " + state + " "+ zip +"\n"+
                email+"\n"+
                phone+"\n";
    }
    //Getter
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZip() {
        return zip;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
    //Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
