package address.data;
import java.util.*;
import java.io.*;

public class AddressBook {
    //Attribute
    private int numberOfContact = 0;
    private final TreeMap<String, AddressEntry> addressEntryList = new TreeMap<>();
    List<AddressEntry> addressBook = new ArrayList<AddressEntry>();
    //constructor
    public AddressBook() {
        System.out.println("AddressBook instance created");
    }
    //Methods
    public void list(){
        //iterate through addressEntry List and
        //for each item call toString and print out
        int i=1;
        for (AddressEntry entry : addressEntryList.values()) {
            System.out.println(i+":");
            System.out.print(entry); // Implicitly calls entry.toString()
            i++;
        }
    }

    //Add new contact into the address book tree map
    public void add(AddressEntry obj){
        //add new addressEntry obj to the addressEntry List
        addressBook.add(obj);
        addressEntryList.put(obj.getLastName(),obj);
        numberOfContact++;
    }

    public void remove(String target){

    }

    //Read input from files
    public void readFromFile(String fileName){
        File file = new File(fileName);
            //File Reading Loop
            try {
                Scanner content = new Scanner(file);
                while (content.hasNextLine()) {
                    String line = content.nextLine().trim();
                    //New Entry
                    if(line.contains(":")){
                        AddressEntry newEntry = new AddressEntry();
                        //parse name
                        if(content.hasNextLine()){
                            String[] name = content.nextLine().trim().split(" ");
                            newEntry.setFirstName(name[0]);
                            if (name.length > 1) newEntry.setLastName(name[1]);
                        }
                        //Parse street name
                        if(content.hasNextLine()){
                            String streetName = content.nextLine().trim();
                            newEntry.setStreet(streetName);
                        }
                        //Parse city, state, and zip
                        //since they are in same line, it has to be parsed into different word
                        if(content.hasNextLine()){
                            String[] cityStateZip = content.nextLine().trim().split(", ");
                            newEntry.setCity(cityStateZip[0]);
                            String[] stateZip = cityStateZip[1].split(" ");
                            newEntry.setState(stateZip[0]);
                            newEntry.setZip(Integer.parseInt(stateZip[1]));
                        }
                        //Parse email
                        if (content.hasNextLine()){
                            newEntry.setEmail(content.nextLine().trim());

                        }
                        //Parse Phone
                        if (content.hasNextLine()) {
                            String phone = content.nextLine().trim();
                            newEntry.setPhone(phone); // Assuming setPhone now accepts a String
                        }
                        //put into addressbook
                        addressEntryList.put(newEntry.getLastName(),newEntry);
                        //book keeping
                        numberOfContact++;
                    }
                }
                content.close();
                System.out.println("Successfully Loaded!");
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }


    }


    public void find(){
        Scanner input = new Scanner(System.in);
        String searchInput = input.nextLine().trim();
    }
    public int getNumberOfContact(){
        return numberOfContact;
    }


}
