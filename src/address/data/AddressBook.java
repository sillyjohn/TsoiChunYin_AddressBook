package address.data;
import java.util.*;
import java.util.TreeSet;
import java.io.*;

/**
 * AddressBook Class Contains two fields: a TreeMap dataStructure to store data and an Int variable to store number of contact
 */
public class AddressBook {
    private final TreeMap<String, TreeSet<AddressEntry>> addressEntryList = new TreeMap<>();
    private int numberOfContact = 0;

    /**
     * Default Constructor
     */
    public AddressBook() {
    }

    /**
     * Print out all entries inside the TreeMap
     */
    public void list(){
        //iterate through addressEntry List and
        //for each item call toString and print out
        int i=1;
        for (TreeSet<AddressEntry> entry : addressEntryList.values()) {
            for(AddressEntry singleContact : entry) {
                System.out.println(i + ":");
                System.out.print(singleContact); // Implicitly calls entry.toString()
                i++;
            }
        }
    }

    /**
     * Method to append new AddressEntry into the TreeMap
     * @param newEntry  AddressEntry Object
     */
    public void add(AddressEntry newEntry) {
        // Get the last name of the new entry to use as the key
        String lastName = newEntry.getLastName();

        // Check if there's already a TreeSet for this last name
        TreeSet<AddressEntry> entries = addressEntryList.get(lastName);
        if (entries == null) {
            // If not, create a new TreeSet and add the entry
            entries = new TreeSet<>();
            entries.add(newEntry);
            // Put the new TreeSet in the TreeMap with the last name as the key
            addressEntryList.put(lastName, entries);
        } else {
            // If there's already a TreeSet, just add the new entry to it
            entries.add(newEntry);
        }
        numberOfContact++;
    }


    /**
     * Method to remove one AddressEntry from TreeMap
     * @param searchInput String Input
     */
    public void remove(String searchInput){
        //uncap all key and input
        //use .startsWith for the compare
        String unCapInput = searchInput.toLowerCase();
        boolean printed = false;
        ArrayList<AddressEntry>choiceArray = new ArrayList<>();
        int i =0;
        //Get all entries
        Set<Map.Entry<String, TreeSet<AddressEntry>> > entries = addressEntryList.entrySet();
        System.out.println("--This is the contact with last name: "+ searchInput+"--");
        //Iterate all Entries
        for (Map.Entry<String, TreeSet<AddressEntry>> entry : entries) {
            //Compare last name with input
            if(entry.getKey().toLowerCase().startsWith(unCapInput)){
                //Print all related contact
                printed = true;
                for(AddressEntry singleContact : entry.getValue()){
                    System.out.println(i+1+":");
                    System.out.println(singleContact);
                    //push related into the choiceArray
                    choiceArray.add(singleContact);
                    i++;
                }
            }
        }
        if(!printed) {
            System.out.println("No Found Contact.");
            return;
        }
        System.out.println("DO YOU WANT TO REMOVE THE CONTACT ABOVE? (YES/NO):");
        Scanner input = new Scanner(System.in);
        String choice = input.next().trim();
        input.nextLine();// This line clears the buffer
        switch (choice){
            case "yes":
            case "Yes":
            case "YES":
                    //Remove From
                    System.out.println("Type the number of the contact to remove:");
                    int removeNumber = input.nextInt() -1;
                    input.nextLine();//clears the buffer
                    TreeSet<AddressEntry> ptr = addressEntryList.get(choiceArray.get(removeNumber).getLastName());
                    ptr.remove(choiceArray.get(removeNumber));
                    if(ptr.isEmpty()){
                        addressEntryList.remove(choiceArray.get(removeNumber).getLastName());
                    }
                    System.out.println("--Contact Removed--");
                    break;
                case "NO":
                    break;
                default:
                    System.out.println("Input Must use all UPPER CASE OR START WITH UPPER CASE. Please Try Again.");
            }

            numberOfContact --;
    }

    /**
     * Method to load content from a .txt file into the TreeMap
     * @param fileName String input
     */
    //TreeSet Empty Check
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
                        add(newEntry);
                    }
                }
                content.close();
                System.out.println("Successfully Loaded!");
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }


    }


    /**
     * Method to find from TreeMap
     * @param searchInput String input
     */
    public void find(String searchInput){
        //uncap all key and input
        //use .startsWith for the compare
        String unCapInput = searchInput.toLowerCase();
        boolean printed = false;
        //Get all entries
        Set<Map.Entry<String, TreeSet<AddressEntry>> > entries = addressEntryList.entrySet();
        System.out.println("--This is the contact with last name: "+ searchInput+"--");
        //Iterate all Entries
        for (Map.Entry<String, TreeSet<AddressEntry>> entry : entries) {
            //Compare last name with input
            if(entry.getKey().toLowerCase().startsWith(unCapInput)){
                //Print all related contact
                printed = true;
                for(AddressEntry singleContact : entry.getValue()){
                    System.out.println(singleContact);
                }
            }
        }
        if(!printed) System.out.println("Contact Not Found.");
    }

    /**
     * Getter Method to get the number of contact inside the treeMap in total
     * @return numberOfContact: Int
     */
    public int getNumberOfContact(){
        return numberOfContact;
    }


}
