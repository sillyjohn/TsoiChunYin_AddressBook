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

/**
 * This class test AddressBook Class
 */
class AddressBookTest {


    /**
     * Object declaration
     */
    AddressBook addressBook;
    /**
     * Object declaration
     */
    private final InputStream systemIn = System.in;
    /**
     * Object declaration for redirecting system in
     */
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    /**
     * Initialize a AddressBook Instance
     */
    @BeforeEach
    void setUp() {
        addressBook = new AddressBook();
    }

    /**
     * Provide a dummy input to tested method
     * @param data
     */
    void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    /**
     * Redirect System.In to normal
     */
    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
    }

    /**
     * Redirect Output Stream
     */
    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Method test the add() and find()
     */
    @Test
    void testAddAndFindContact() {
        AddressEntry entry = new AddressEntry("John", "Doe", "123 Main St", "Anytown", "State", 12345, "email@example.com", "123-456-7890");
        addressBook.add(entry);
        addressBook.find("Doe");
    }

    /**
     * Method to test remove()
     */
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

    /**
     * Method to test readFromFile()
     */
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

    /**
     * Method to test getterFunction of numberOfContact
     */
    @Test
    void testGetNumberOfContact(){
        String testFilePath = "src/Test/resources/textAddressBook.txt";
        addressBook.readFromFile(testFilePath);
        assertTrue(addressBook.getNumberOfContact() == 2);
    }

    /**
     * Method to list()
     */
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
