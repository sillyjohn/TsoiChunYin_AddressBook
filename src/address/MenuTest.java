package address;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    private final InputStream systemIn = System.in;
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private ByteArrayInputStream testIn;

    @BeforeEach
    void setUpOutput() {
        // This method runs before each test, setting up the test environment
    }
    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @AfterEach
    void restoreSystemInputOutput() {
        System.setIn(systemIn);
    }
    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
    @Test
    void testPrompt_FirstName() {
        String firstName = "John";
        provideInput(firstName + "\n"); // Simulate user entering "John" then pressing Enter
        assertEquals(firstName, Menu.prompt_FirstName(), "The method did not return the expected first name.");
    }

    @Test
    void testPrompt_LastName(){
        String lastName = "Tsoi";
        provideInput(lastName + "\n"); // Simulate user entering "John" then pressing Enter
        assertEquals(lastName, Menu.prompt_LastName(), "The method did not return the expected last name.");
    }
    @Test
    void testPrompt_Street(){
        String streetName = "123 abc St";
        provideInput(streetName + "\n"); // Simulate user entering "John" then pressing Enter
        assertEquals(streetName, Menu.prompt_Street(), "The method did not return the expected street name.");
    }
    @Test
    void testPrompt_City(){
        String cityName = "Hong Kong";
        provideInput(cityName + "\n"); // Simulate user entering "John" then pressing Enter
        assertEquals(cityName, Menu.prompt_City(), "The method did not return the expected city name.");
    }
    @Test
    void testPrompt_State(){
        String stateName = "CA";
        provideInput(stateName + "\n"); // Simulate user entering "John" then pressing Enter
        assertEquals(stateName, Menu.prompt_State(), "The method did not return the expected state name.");
    }
    @Test
    void testPrompt_Zip(){
        int zip = 94542;
        provideInput(zip + "\n"); // Simulate user entering "John" then pressing Enter
        assertEquals(zip, Menu.prompt_Zip(), "The method did not return the expected zip code.");
    }
    @Test
    void testPrompt_Telephone(){
        String phone = "123321123";
        provideInput(phone + "\n"); // Simulate user entering "John" then pressing Enter
        assertEquals(phone, Menu.prompt_Telephone(), "The method did not return the expected phone number.");
    }
    @Test
    void testPrompt_Email(){
        String email = "example@gmail.com";
        provideInput(email + "\n"); // Simulate user entering "John" then pressing Enter
        assertEquals(email, Menu.prompt_Email(), "The method did not return the expected email address.");
    }

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
