package Test;

import address.Menu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for Menu Class
 */
class MenuTest {

    /**
     * Use To redirect System.in for testing
     */
    private final InputStream systemIn = System.in;
    /**
     * Use To redirect system.out for testing
     */
    private final PrintStream originalOut = System.out;
    /**
     * Use to redirect system.out for comparison
     */
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    /**
     * Use To redirect input stream
     */
    private ByteArrayInputStream testIn;

    /**
     * Method to redirection system out stream
     */
    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Method to provide dummy input
     * @param data
     */
    void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    /**
     * Redirect System.In to normal
     */
    @AfterEach
    void restoreSystemInputOutput() {
        System.setIn(systemIn);
    }
    /**
     * Redirect output stream to normal
     */
    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
    /**
     * Method to test Prompt_FirstName
     */
    @Test
    void testPrompt_FirstName() {
        String firstName = "John";
        provideInput(firstName + "\n"); // Simulate user entering "John" then pressing Enter
        Assertions.assertEquals(firstName, Menu.prompt_FirstName(), "The method did not return the expected first name.");
    }
    /**
     * Method to test Prompt_LastName
     */
    @Test
    void testPrompt_LastName(){
        String lastName = "Tsoi";
        provideInput(lastName + "\n"); // Simulate user entering "John" then pressing Enter
        assertEquals(lastName, Menu.prompt_LastName(), "The method did not return the expected last name.");
    }

    /**
     * Method to test Prompt_Street
     */
    @Test
    void testPrompt_Street(){
        String streetName = "123 abc St";
        provideInput(streetName + "\n"); // Simulate user entering "John" then pressing Enter
        assertEquals(streetName, Menu.prompt_Street(), "The method did not return the expected street name.");
    }

    /**
     * Method to test Prompt_City
     */
    @Test
    void testPrompt_City(){
        String cityName = "Hong Kong";
        provideInput(cityName + "\n"); // Simulate user entering "John" then pressing Enter
        assertEquals(cityName, Menu.prompt_City(), "The method did not return the expected city name.");
    }

    /**
     * Method to test Prompt_State
     */
    @Test
    void testPrompt_State(){
        String stateName = "CA";
        provideInput(stateName + "\n"); // Simulate user entering "John" then pressing Enter
        assertEquals(stateName, Menu.prompt_State(), "The method did not return the expected state name.");
    }

    /**
     * Method to test Prompt_Zip
     */
    @Test
    void testPrompt_Zip(){
        int zip = 94542;
        provideInput(zip + "\n"); // Simulate user entering "John" then pressing Enter
        assertEquals(zip, Menu.prompt_Zip(), "The method did not return the expected zip code.");
    }

    /**
     * Method to test Prompt_Telephone
     */
    @Test
    void testPrompt_Telephone(){
        String phone = "123321123";
        provideInput(phone + "\n"); // Simulate user entering "John" then pressing Enter
        assertEquals(phone, Menu.prompt_Telephone(), "The method did not return the expected phone number.");
    }

    /**
     * Method to test Prompt_Email
     */
    @Test
    void testPrompt_Email(){
        String email = "example@gmail.com";
        provideInput(email + "\n"); // Simulate user entering "John" then pressing Enter
        assertEquals(email, Menu.prompt_Email(), "The method did not return the expected email address.");
    }

    /**
     * Method to test displayMenu
     */
    @Test
    void testDisplayMenu() {
        Menu.displayMenu();
        String expectedOutput = "************************************************************\n" +
                "Please enter your menu selection\n" +
                "a) Loading From File\n" +
                "b) Addition\n" +
                "c) Removal\n" +
                "d) Find\n" +
                "e) Listing\n" +
                "f) Quit\n" +
                "************************************************************\n";
        assertTrue(outContent.toString().contains(expectedOutput), "The output should match the expected menu display.");
    }
}
