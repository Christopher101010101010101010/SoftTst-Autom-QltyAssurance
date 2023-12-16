
import org.junit.Test;
import static org.junit.Assert.*;

public class ContactServiceTest {

    //Testing Contact Service for standard operation
    //  Testing for proper Initialization, addContact function, updater functions and deleteContact function operations
    @Test
    public void testContactDatabase(){

        ContactService myContactServ = new ContactService();
        //Innialization oof three new Contact objects for system database
        Contact newContact1 = new Contact("contact01", "Robert", "Dole", "5054490267",
                "70 Alpine Dr, Boltin, ME");
        Contact newContact2 = new Contact("contact02", "William", "Grant", "5054490398",
                "15 Funky Rd, Dowal, MI");
        Contact newContact3 = new Contact("contact03", "Brittany", "Kentsen", "5054481599",
                "8 Ballpunt Ln, Nurwel, CA");

        //Test addContact for proper execution
        assertTrue(myContactServ.addContact(newContact1));
        assertTrue(myContactServ.addContact(newContact2));
        assertTrue(myContactServ.addContact(newContact3));

        //Test that objects are in database
        assertTrue(myContactServ.getCServObj(0).equals(newContact1));
        assertTrue(myContactServ.getCSAervObj(1).equals(newContact2));
        assertTrue(myContactServ.getCServObj(2).equals(newContact3));

        //Test for proper updater function execution
        //  Testing updateContactFirstName for standard operation
        assertTrue(myContactServ.updateContactFirstName(newContact1.getContactID(), "Kohl"));
        assertTrue(myContactServ.getCServObj(0).getFirstName().equals("Kohl"));

        //  Testing updateContactLastName for standard operation
        assertTrue(myContactServ.updateLastName(newContact2.getContactID(), "Henders"));
        assertTrue(myContactServ.getCServObj(1).getLastName().equals("Henders"));

        //  Testing updateContactPhoneNum for standard operation
        assertTrue(myContactServ.updateContactPhoneNum(newContact1.getContactID(), "1112223333"));
        assertTrue(myContactServ.getCServObj(0).getPhoneNumber().equals("1112223333"));

        //  Testing updateContactAddress for standard operation
        assertTrue(myContactServ.updateContactAddress(newContact3.getContactID(), "3 Ridge Trl, S Wayne, VA, USA"));
        assertTrue(myContactServ.getCServObj(0).getAddress().equals("3 Ridge Trl, S Wayne, VA, USA"));

        //Test deleteContact for proper execution
        assertTrue(myContactServ.deleteContact(newContact1.getContactID()));
        assertTrue(myContactServ.deleteContact(newContact2.getContactID()));
        assertTrue(myContactServ.deleteContact(newContact3.getContactID()));

        //Test that database is empty
        assertTrue(myContactServ.getDatabase().isEmpty());
    }

    //Testing addContact function for duplicate contact ID error
    @Test
    public void testAddContactDupl(){

        ContactService myContactServ = new ContactService();
        //Innialization oof three new Contact objects for system database
        Contact newContact1 = new Contact("contact01", "Robert", "Dole", "5054490267",
                "70 Alpine Dr, Boltin, ME");
        Contact newContact2 = new Contact("contact02", "William", "Grant", "5054490398",
                "15 Funky Rd, Dowal, MI");
        Contact newContact3 = new Contact("contact01", "Brittany", "Kentsen", "5054481599",
                "8 Ballpunt Ln, Nurwel, CA");

        //use addContact to populate ContactService instance
        myContactServ.addContact(newContact1);
        myContactServ.addContact(newContact2);

        //Test that a duplicate contactID will throw an illegal argument flag
        assertThrows(IllegalArgumentException.class, () ->{
            myContactServ.addContact(newContact3);
        } ); }

    //Test deleteContact function for invalid ID and no match in database
    //  Testing for null parameter flag
    @Test
    public void testDltConNotNull(){

        ContactService myContactServ = new ContactService();
        //Innialization oof three new Contact objects for system database
        Contact newContact1 = new Contact("contact01", "Robert", "Dole", "5054490267",
                "70 Alpine Dr, Boltin, ME");
        Contact newContact2 = new Contact("contact02", "William", "Grant", "5054490398",
                "15 Funky Rd, Dowal, MI");
        Contact newContact3 = new Contact("contact01", "Brittany", "Kentsen", "5054481599",
                "8 Ballpunt Ln, Nurwel, CA");

        //use addContact to populate ContactService instance
        myContactServ.addContact(newContact1);
        myContactServ.addContact(newContact2);

        //Test that a null pointer exception is thrown for null parameter
        assertThrows(NullPointerException.class, () ->{
            myContactServ.deleteContact(null);
        } ); }

    //  Testing for parameter too long exception
    @Test
    public void testDltConTooLng(){

        ContactService myContactServ = new ContactService();
        //Innialization oof three new Contact objects for system database
        Contact newContact1 = new Contact("contact01", "Robert", "Dole", "5054490267",
                "70 Alpine Dr, Boltin, ME");
        Contact newContact2 = new Contact("contact02", "William", "Grant", "5054490398",
                "15 Funky Rd, Dowal, MI");
        Contact newContact3 = new Contact("contact01", "Brittany", "Kentsen", "5054481599",
                "8 Ballpunt Ln, Nurwel, CA");

        //use addContact to populate ContactService instance
        myContactServ.addContact(newContact1);
        myContactServ.addContact(newContact2);

        //Test that a illegal argument exception is thrown for parameter ID too long
        assertThrows(IllegalArgumentException.class, () ->{
            myContactServ.deleteContact("contact123456");
        } ); }

    //  Testing for parameter ID not found in database
    @Test
    public void testDltConNotFnd(){

        ContactService myContactServ = new ContactService();
        //Innialization oof three new Contact objects for system database
        Contact newContact1 = new Contact("contact01", "Robert", "Dole", "5054490267",
                "70 Alpine Dr, Boltin, ME");
        Contact newContact2 = new Contact("contact02", "William", "Grant", "5054490398",
                "15 Funky Rd, Dowal, MI");
        Contact newContact3 = new Contact("contact01", "Brittany", "Kentsen", "5054481599",
                "8 Ballpunt Ln, Nurwel, CA");

        //use addContact to populate ContactService instance
        myContactServ.addContact(newContact1);
        myContactServ.addContact(newContact2);
        myContactServ.addContact(newContact3);

        //Test that a illegal argument exception is thrown for ID not found in database
        assertThrows(IllegalArgumentException.class, () ->{
            myContactServ.deleteContact("contact56");
        } ); }

    //Test for update Contact functions
    //  Testing updateContactFirstName for parameter ID not found in database
    @Test
    public void testUpdConFrstNmNotFnd(){
        ContactService myContactServ = new ContactService();
        //Innialization oof three new Contact objects for system database
        Contact newContact1 = new Contact("contact01", "Robert", "Dole", "5054490267",
                "70 Alpine Dr, Boltin, ME");
        Contact newContact2 = new Contact("contact02", "William", "Grant", "5054490398",
                "15 Funky Rd, Dowal, MI");
        Contact newContact3 = new Contact("contact01", "Brittany", "Kentsen", "5054481599",
                "8 Ballpunt Ln, Nurwel, CA");

        //use addContact to populate ContactService instance
        myContactServ.addContact(newContact1);
        myContactServ.addContact(newContact2);
        myContactServ.addContact(newContact3);

        //Test that a illegal argument exception is thrown for ID not found in database
        assertThrows(IllegalArgumentException.class, () ->{
            myContactServ.updateContactFirstName("key951", "Jimbo");
        } ); }

    //  Testing updateContactLastName for parameter ID not found in database
    @Test
    public void testUpdConLstNmNotFnd(){
        ContactService myContactServ = new ContactService();
        //Innialization oof three new Contact objects for system database
        Contact newContact1 = new Contact("contact01", "Robert", "Dole", "5054490267",
                "70 Alpine Dr, Boltin, ME");
        Contact newContact2 = new Contact("contact02", "William", "Grant", "5054490398",
                "15 Funky Rd, Dowal, MI");
        Contact newContact3 = new Contact("contact01", "Brittany", "Kentsen", "5054481599",
                "8 Ballpunt Ln, Nurwel, CA");

        //use addContact to populate ContactService instance
        myContactServ.addContact(newContact1);
        myContactServ.addContact(newContact2);
        myContactServ.addContact(newContact3);

        //Test that a illegal argument exception is thrown for ID not found in database
        assertThrows(IllegalArgumentException.class, () ->{
            myContactServ.updateContactLastName("key95144", "Greene");
        } ); }

    //  Testing updateContactPhoneNum for parameter ID not found in database
    @Test
    public void testUpdConPhoneNumNotFnd(){
        ContactService myContactServ = new ContactService();
        //Innialization oof three new Contact objects for system database
        Contact newContact1 = new Contact("contact01", "Robert", "Dole", "5054490267",
                "70 Alpine Dr, Boltin, ME");
        Contact newContact2 = new Contact("contact02", "William", "Grant", "5054490398",
                "15 Funky Rd, Dowal, MI");
        Contact newContact3 = new Contact("contact01", "Brittany", "Kentsen", "5054481599",
                "8 Ballpunt Ln, Nurwel, CA");

        //use addContact to populate ContactService instance
        myContactServ.addContact(newContact1);
        myContactServ.addContact(newContact2);
        myContactServ.addContact(newContact3);

        //Test that a illegal argument exception is thrown for ID not found in database
        assertThrows(IllegalArgumentException.class, () ->{
            myContactServ.updateContactPhoneNum("con001", "7819951466");
        } ); }

    //  Testing updateContactAddress for parameter ID not found in database
    @Test
    public void testUpdConAddressNotFnd(){
        ContactService myContactServ = new ContactService();
        //Innialization oof three new Contact objects for system database
        Contact newContact1 = new Contact("contact01", "Robert", "Dole", "5054490267",
                "70 Alpine Dr, Boltin, ME");
        Contact newContact2 = new Contact("contact02", "William", "Grant", "5054490398",
                "15 Funky Rd, Dowal, MI");
        Contact newContact3 = new Contact("contact01", "Brittany", "Kentsen", "5054481599",
                "8 Ballpunt Ln, Nurwel, CA");

        //use addContact to populate ContactService instance
        myContactServ.addContact(newContact1);
        myContactServ.addContact(newContact2);
        myContactServ.addContact(newContact3);

        //Test that a illegal argument exception is thrown for ID not found in database
        assertThrows(IllegalArgumentException.class, () ->{
            myContactServ.updateContactAddress("con0321", "11 Oluf Ln, Stockholm, SW");
        } ); }

}
