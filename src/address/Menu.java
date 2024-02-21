//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package address;

import address.data.AddressEntry;

import java.util.Scanner;

public class Menu {
    public Menu() {

    }

    //Main Menu Interface
    public static void displayMenu(){
        System.out.println("************************************************************");
        System.out.println("Please enter your menu selection");
        System.out.println("a) Loading From File");
        System.out.println("b) Addition");
        System.out.println("c) Removal");
        System.out.println("d) Find");
        System.out.println("e) Listing");
        System.out.println("f) Quit");
        System.out.println("************************************************************");
    }
    //
    public static String prompt_FirstName() {
        System.out.println("First Name:");
        Scanner key = new Scanner(System.in);
        String in = key.nextLine();
        return in;
    }

    public static String prompt_LastName() {
        System.out.println("Last Name:");
        Scanner key = new Scanner(System.in);
        String in = key.nextLine();
        return in;
    }

    public static String prompt_Street() {
        System.out.println("Street:");
        Scanner key = new Scanner(System.in);
        String in = key.nextLine();
        return in;
    }

    public static String prompt_City() {
        System.out.println("City:");
        Scanner key = new Scanner(System.in);
        String in = key.nextLine();
        return in;
    }

    public static String prompt_State() {
        System.out.println("State:");
        Scanner key = new Scanner(System.in);
        String in = key.nextLine();
        return in;
    }

    public static int prompt_Zip() {
        System.out.println("Zip:");
        Scanner key = new Scanner(System.in);
        int in = key.nextInt();
        return in;
    }

    public static int prompt_Telephone() {
        System.out.println("Telephone:");
        Scanner key = new Scanner(System.in);
        int in = key.nextInt();
        return in;
    }

    public static String prompt_Email() {
        System.out.println("Email:");
        Scanner key = new Scanner(System.in);
        String in = key.nextLine();
        return in;
    }
}
