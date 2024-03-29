//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package address;

import address.data.AddressBook;
import address.data.AddressEntry;

import java.util.Scanner;

/**
 * Main Method to initialize an AddressBook instance and call initAddressBook() method
 */
class AddressBookApplication {
    //Create an AddressBook instance
    static AddressBook ab = new AddressBook();

    public static void main(String[] args) {
        //call initialize AddressBook AB
        initAddressBook();
    }

    /**
     * Method accept input and call different Class's method
     */
    public static void initAddressBook(){
        //Input Obj
        Scanner console = new Scanner(System.in);
        //Loop control
        boolean quit = false;
        //Menu Loop
        while(!quit){
            Menu.displayMenu();
            String choice = console.next();
            console.nextLine(); // This line clears the buffer
            switch(choice){
                case "A":
                case "a":
                    System.out.println("**load**");
                    Scanner input = new Scanner(System.in);
                    String searchInput = input.nextLine().trim();
                    ab.readFromFile(searchInput);
                    break;
                case "B":
                case "b":
                    //
                    System.out.println("**Addition**");
                    //New contact instance
                    AddressEntry newContact = new AddressEntry();
                    //Addition prompts
                    newContact.setFirstName(Menu.prompt_FirstName());
                    newContact.setLastName(Menu.prompt_LastName());
                    newContact.setStreet(Menu.prompt_Street());
                    newContact.setCity(Menu.prompt_City());
                    newContact.setState(Menu.prompt_State());
                    newContact.setZip(Menu.prompt_Zip());
                    newContact.setPhone(Menu.prompt_Telephone());
                    newContact.setEmail(Menu.prompt_Email());
                    //Add new contact into the AddressBook instance
                    ab.add(newContact);
                    break;
                case "C":
                case "c":
                    System.out.println("**Remove**");
                    System.out.println("Please type contact's last name:");
                    input = new Scanner(System.in);
                    searchInput = input.nextLine().trim();
                    ab.remove(searchInput);
                    break;
                case "D":
                case "d":
                    System.out.println("**Finding**");
                    System.out.println("Please type contact's last name:");
                    input = new Scanner(System.in);
                    searchInput = input.nextLine().trim();
                    ab.find(searchInput);
                    break;
                case "E":
                case "e":
                    System.out.println("**Listing**");
                    System.out.println("There are total "+ ab.getNumberOfContact()+ " of contacts.");
                    ab.list();
                    break;
                case "F":
                    case "f":
                        quit = true;
                    System.out.println("**Good Bye**");
                    break;
                default:  System.out.println("Unexpected value: " + choice+ ". Please try again...");

            }
        }
    }
}
