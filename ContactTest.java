
import org.junit.Test;
import static org.junit.Assert.*;

public class ContactTest {

    //Testing for standard Contact instance initialization and getter function operation
    @Test
    public void testContactClass(){
        Contact newContact = new Contact("contact01", "Robert", "Dole", "5054490267",
                "70 Alpine Dr, Boltin, ME");
        assertTrue(newContact.getContactID().equals("contact01"));
        assertTrue(newContact.getFirstName().equals("Robert"));
        assertTrue(newContact.getLastName().equals("Dole"));
        assertTrue(newContact.getPhoneNumber().equals("5054490267"));
        assertTrue(newContact.getAddress().equals("70 Alpine Dr, Boltin, ME"));
    }

    //Testing class variables against length constraints
    //  Testing for ID is too long, > 10 characters
    @Test
    public void testContactIDTooLong(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("contact0123", "Robert", "Dole", "5054490267",
                    "70 Alpine Dr, Boltin, ME");
        });    }

    //  Testing for first name is too long, > 10 characters
    @Test
    public void testContactFirstNameTooLong(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("contact01", "Roberto IIV", "Dole", "5054490267",
                    "70 Alpine Dr, Boltin, ME");
        });
    }

    //  Testing for last name is too long, > 10 characters
    @Test
    public void testContactLastNameTooLong(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("contact01", "Robert", "Von Hamburg", "5054490267",
                    "70 Alpine Dr, Boltin, ME");
        });
    }

    //  Testing for phone number is too short, < 10 character
    @Test
    public void testContactPhoneNumTooShort(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("contact01", "Robert", "Dole", "505449026",
                    "70 Alpine Dr, Boltin, ME");
        });
    }

    //  Testing for phone number is too long, > 10 character
    @Test
    public void testContactPhoneNumTooLong(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("contact01", "Robert", "Dole", "15054490267",
                    "70 Alpine Dr, Boltin, ME");
        });
    }

    //  Testing for address is too long, > 30 character
    @Test
    public void testContactAddressTooLong(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("contact01", "Robert", "Dole", "5054490267",
                    "7066 Alpinen Dr, Boltin, ME, RU");
        });
    }

    //Testing for null value of initializers
    //  Testing for ID cannot be null
    @Test
    public void testContactIDNull(){
        assertThrows(NullPointerException.class, () -> {
            new Contact(null, "Robert", "Dole", "5054490267",
                    "70 Alpine Dr, Boltin, ME");
        });    }

    //  Testing for firstname cannot be null
    @Test
    public void testContactFirstNameNull(){
        assertThrows(NullPointerException.class, () -> {
            new Contact("contact01", null, "Dole", "5054490267",
                    "70 Alpine Dr, Boltin, ME");
        });
    }

    //  Testing for lastname cannot be null
    @Test
    public void testContactLastNameNull(){
        assertThrows(NullPointerException.class, () -> {
            new Contact("contact01", "Robert", null, "5054490267",
                    "70 Alpine Dr, Boltin, ME");
        });
    }

    //  Testing for phone number cannot be null
    @Test
    public void testContactPhoneNumNull(){
        assertThrows(NullPointerException.class, () -> {
            new Contact("contact01", "Robert", "Dole", null,
                    "70 Alpine Dr, Boltin, ME");
        });
    }

    //  Testing for address cannot be null
    @Test
    public void testContactAddressNull(){
        assertThrows(NullPointerException.class, () -> {
            new Contact("contact01", "Robert", "Dole", "5054490267",
                    null);
        });
    }

    //Testing for variable first name setter exceptions
    //  Testing for new first name set in standard operation
    @Test
    public void testSetGivenName(){
        Contact newContact = new Contact("contact01", "Richard", "Finley", "6175559872",
                "3 Hunli Rd, Tokyo, JP");

        newContact.setFirstName("Bilbo");
        assertTrue(newContact.getFirstName().equals("Bilbo"));
    }

    //  Testing for new first name is too long
    @Test
    public void testSetGivenNameTooLong(){
        Contact newContact = new Contact("contact01", "Richard", "Finley", "6175559872",
                "3 Hunli Rd, Tokyo, JP");

        assertThrows(IllegalArgumentException.class, () -> {
            newContact.setFirstName("Yurkinovsho");
        } ); }

    //  Testing for new first name cannot be null
    @Test
    public void testSetGivenNameNotNull(){
        Contact newContact = new Contact("contact01", "Richard", "Finley", "6175559872",
                "3 Hunli Rd, Tokyo, JP");

        assertThrows(NullPointerException.class, () -> {
            newContact.setFirstName(null);
        } ); }

    //Testing variable last name setter exceptions
    //  Testing for new last name standard operation
    @Test
    public void testSetSurname(){
        Contact newContact = new Contact("contact01", "Richard", "Finley", "6175559872",
                "3 Hunli Rd, Tokyo, JP");

        newContact.setLastName("McKree");
        assertTrue(newContact.getLastName().equals("McKree"));
    }

    //  Testing for new last name is too long
    @Test
    public void testSetSurnameTooLong(){
        Contact newContact = new Contact("contact01", "Richard", "Finley", "6175559872",
                "3 Hunli Rd, Tokyo, JP");

        assertThrows(IllegalArgumentException.class, () -> {
            newContact.setLastName("XibuPholing");
        } ); }

    //  Testing for new last name cannot be null
    @Test
    public void testSetSurnameNotNull(){
        Contact newContact = new Contact("contact01", "Richard", "Finley", "6175559872",
                "3 Hunli Rd, Tokyo, JP");

        assertThrows(NullPointerException.class, () -> {
            newContact.setLastName(null);
        } ); }

    //Testing variable phone number for length exceptions
    //  Testing for new phone number standard operation
    @Test
    public void testPhoneNum(){
        Contact newContact = new Contact("contact01", "Richard", "Finley", "6175559872",
                "3 Hunli Rd, Tokyo, JP");

        newContact.setPhoneNumber("7819550321");
        assertTrue(newContact.getPhoneNumber().equals("7819550321"));
    }

    //  Testing for new phone number is too long
    @Test
    public void testPhoneNumTooLong(){
        Contact newContact = new Contact("contact01", "Richard", "Finley", "6175559872",
                "3 Hunli Rd, Tokyo, JP");

        assertThrows(IllegalArgumentException.class, () -> {
            newContact.setPhoneNumber("12345678901");
        } ); }

    //  Testing for new phone number is too short
    @Test
    public void testPhoneNumTooShort(){
        Contact newContact = new Contact("contact01", "Richard", "Finley", "6175559872",
                "3 Hunli Rd, Tokyo, JP");

        assertThrows(IllegalArgumentException.class, () -> {
            newContact.setPhoneNumber("123456789");
        } ); }

    //  Testing for new phone number cannot be not null
    @Test
    public void testPhoneNumNotNull(){
        Contact newContact = new Contact("contact01", "Richard", "Finley", "6175559872",
                "3 Hunli Rd, Tokyo, JP");

        assertThrows(NullPointerException.class, () -> {
            newContact.setPhoneNumber(null);
        } ); }

    //Testing variable address for setter exceptions
    //  Testing address setter for standard operation
    @Test
    public void testAddress(){
        Contact newContact = new Contact("contact01", "Richard", "Finley", "6175559872",
                "3 Hunli Rd, Tokyo, JP");

        newContact.setAddress("17 TurtleRock Ln, Rever, RI");
        assertTrue(newContact.getAddress().equals("17 TurtleRock Ln, Rever, RI"));
    }

    //  Testing for new address is too long
    @Test
    public void testAddressTooLong(){
        Contact newContact = new Contact("contact01", "Richard", "Finley", "6175559872",
                "3 Hunli Rd, Tokyo, JP");
        assertThrows(IllegalArgumentException.class, () -> {
            newContact.setAddress("1234 Weituke Terrace, Efuyi, CA");
        } ); }

    //  Testing for new address cannot be null
    @Test
    public void testAddressNotNull(){
        Contact newContact = new Contact("contact01", "Richard", "Finley", "6175559872",
                "3 Hunli Rd, Tokyo, JP");
        assertThrows(IllegalArgumentException.class, () -> {
            newContact.setAddress(null);
        } ); }

}
