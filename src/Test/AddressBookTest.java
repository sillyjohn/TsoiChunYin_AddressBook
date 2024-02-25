package Test;

import address.data.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {

    AddressBook addressBook;
    private final InputStream systemIn = System.in;
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @BeforeEach
    void setUp() {
        addressBook = new AddressBook();
    }

    void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }
    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
    }
    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }
    @Test
    void testAddAndFindContact() {
        AddressEntry entry = new AddressEntry("John", "Doe", "123 Main St", "Anytown", "State", 12345, "email@example.com", "123-456-7890");
        addressBook.add(entry);
        addressBook.find("Doe");
    }

    @Test
    void testRemoveContact() {
        AddressEntry entry = new AddressEntry("Jane", "Doe", "124 Main St", "Anytown", "State", 12345, "jane.doe@example.com", "123-456-7891");
        addressBook.add(entry);
        // Ensure the contact is added
        // This assumes you have a method to check the presence of an entry or the size of the address book
        assertEquals(1, addressBook.getNumberOfContact());
        String simulatedUserInput = "Yes \n 1\n";
        provideInput(simulatedUserInput);
        addressBook.remove("Doe");
        // Verify the contact has been removed
        assertEquals(0, addressBook.getNumberOfContact());
    }

    @Test
    void testReadFromFile() {
        // Setup a test file with known content
        String testFilePath = "src/Test/resources/textAddressBook.txt";
        addressBook.readFromFile(testFilePath);
        // Verify the file reading functionality by checking the address book's state
        // This might involve checking the number of entries or specific details of an added entry
        // The exact assertions will depend on the implementation details of your AddressBook class
        assertTrue(addressBook.getNumberOfContact() > 0);
    }
    @Test
    void testGetNumberOfContact(){
        String testFilePath = "src/Test/resources/textAddressBook.txt";
        addressBook.readFromFile(testFilePath);
        assertTrue(addressBook.getNumberOfContact() == 2);
    }
    @Test
    void testListing(){
        String expectedOutput ="Successfully Loaded!\n"+
                "1:\n"+ "John Doe\n"
                +"123 Main St\n"
                +"Anytown, State 12345\n"
                +"john.doe@example.com\n"
                +"123-456-7890\n"
                +"2:\n"
                +"Jane Smith\n"
                +"456 Maple Ave\n"
                +"Othertown, AnotherState 67890\n"
                +"jane.smith@example.com\n"
                +"987-654-3210\n";

        String testFilePath = "src/Test/resources/textAddressBook.txt";
        addressBook.readFromFile(testFilePath);
        addressBook.list();
        assertLinesMatch(expectedOutput.lines(), outContent.toString().lines());



    }
}
