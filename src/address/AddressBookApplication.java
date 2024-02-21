//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package address;

import address.data.AddressBook;
import address.data.AddressEntry;

import java.util.Scanner;

class AddressBookApplication {

    static AddressBook ab = new AddressBook();

    public static void main(String[] args) {
//        Menu.prompt_FirstName();
//        Menu.prompt_LastName();
//        Menu.prompt_Street();
//        Menu.prompt_City();
//        Menu.prompt_State();
//        Menu.prompt_Zip();
//        Menu.prompt_Telephone();
//        Menu.prompt_Email();
        initAddressBook(ab);
    }

    public static void initAddressBook(AddressBook obj){
        //System.out.println("initAddressBookExcerise called");
        Scanner console = new Scanner(System.in);
        while(true){
            System.out.println("Create a new entry? (Y/N)");
            String choice = console.next();
            if(choice.equals("Y")) {
                System.out.println("Please type in your information:");
                System.out.println("Please type in your first name:");
                String firstName = console.next();
                System.out.println("Please type in your last name:");
                String lastName = console.next();
                System.out.println("Please type in your Street name:");
                String street = console.next();
                System.out.println("Please type in your city name:");
                String city = console.next();
                System.out.println("Please type in your state name:");
                String state = console.next();
                System.out.println("Please type in your zip code:");
                int zip = console.nextInt();
                System.out.println("Please type in your phone number:");
                int phone = console.nextInt();
                System.out.println("Please type in your email address:");
                String email = console.next();
                AddressEntry newEntry = new AddressEntry(firstName,lastName,street,city,state,zip,phone,email);
                obj.add(newEntry);
            }else{
                break;
            }

        }

        Scanner printChoice = new Scanner(System.in);
        System.out.println("Print all entries?(Y/N)");
        String print = printChoice.next();
        if(print.equals("Y"))
            obj.list();


    }
}
