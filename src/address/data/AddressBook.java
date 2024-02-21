package address.data;
import java.util.*;

public class AddressBook {
    //Attribute
    List<AddressEntry> addressBook = new ArrayList<AddressEntry>();
    //constructor
    public AddressBook() {
        System.out.println("AddressBook instance created");
    }
    //Methods
    public void list(){
        //iterate through addressEntry List and
        //for each item call toString and print out
        for(int i =0; i < addressBook.size(); i++){
            System.out.println("Entry"+i);
            System.out.println(addressBook.get(i).getFirstName());
            System.out.println(addressBook.get(i).getLastName());
            System.out.println(addressBook.get(i).getStreet());
            System.out.println(addressBook.get(i).getCity());
            System.out.println(addressBook.get(i).getState());
            System.out.println(addressBook.get(i).getZip());
            System.out.println(addressBook.get(i).getPhone());
            System.out.println(addressBook.get(i).getEmail());
            System.out.println();
        }
    }
    public void add(AddressEntry obj){
        //add new addressEntry obj to the addressEntry List
        addressBook.add(obj);
    }

}
