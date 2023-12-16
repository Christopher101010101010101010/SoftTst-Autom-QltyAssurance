//import Contact.java;

import java.util.ArrayList;
import java.util.List;

public class ContactService {
    private List<Contact> myContacts;

    //Service function definition for addition of a contact to system database
    public boolean addContact(Contact newContact){
        //Initialize boolean duplicate checker to false
        boolean duplFound = false;

        //confirm that duplicate Contact instance does not exist in the database
        for(int i = 0; i < myContacts.size(); i++){

            //if duplicate instance is found set duplicate checker to true
            if(myContacts.get(i).getContactID() == newContact.getContactID()){
                duplFound = true;
                break;
            }
        }

        //if a duplicate instance is found then throw an illegal argument flag
        if(duplFound){

            throw new IllegalArgumentException("Invalid Contact instance.");
        }

        //otherwise add new Contact to the database
        else{

            myContacts.add(newContact);
        }

        return true;
    }

    //Service function definition for removal of Contact object from system database via
    //  unique contact ID
    public boolean deleteContact(String uniqueID){

        //Test for parameter ID length and not null
        if(uniqueID == null || uniqueID.length() > 10){
            if(uniqueID == null){
                throw new NullPointerException("ID is null.");
            }
            else {
                throw new IllegalArgumentException("Invalid ID.");
            }
        }

        //Iterate through list objects comparing uniqueIDs against parameter ID
        for(int i = 0; i < myContacts.size(); i++){

            //initialize temporary contact object to i-th index of myContacts list
            Contact tempContact = myContacts.get(i);

            //if i-th index object's contactID matches parameter ID then output confirmation
            //remove object and return from function
            if(tempContact.getContactID() == uniqueID){
                myContacts.remove(i);
                return true;
            }
        }
        //if object is not found throw exception
        throw new IllegalArgumentException("No match found.");
    }

    //Service function definitions for updating a Contact object in system database
    public boolean updateContactFirstName(String uniqueID, String givenName){

        //iterate through list to find object with ID matching parameter ID
        for(int i = 0; i < myContacts.size(); i++){

            //if ith index object of database has ID equivalent to parameter ID then set First name to parameter
            if(myContacts.get(i).getContactID() == uniqueID){

                myContacts.get(i).setFirstName(givenName);
                return true;
            }
        }

        //throw exception to confirm that no match was found for unique contact id
        throw new IllegalArgumentException("No match found.");
    }

    //Update a Contact instance's last name via ID
    public boolean updateContactLastName(String uniqueID, String surname){

        //iterate through list to find object with ID matching parameter ID
        for(int i = 0; i < myContacts.size(); i++){

            //if ith index object of database has ID equivalent to parameter ID then set last name to parameter
            if(myContacts.get(i).getContactID() == uniqueID){

                myContacts.get(i).setLastName(surname);
                return true;
            }
        }

        //throw exception to confirm that no match was found for unique contact id
        throw new IllegalArgumentException("No match found.");
    }

    // Update Contact instance's phone number via ID
    public boolean updateContactPhoneNum(String uniqueID, String phoneNum){

        //iterate through list to find object with ID matching parameter ID
        for(int i = 0; i < myContacts.size(); i++){

            //if ith index object of database has ID equivalent to parameter ID then set phone number to parameter
            if(myContacts.get(i).getContactID() == uniqueID){

                myContacts.get(i).setPhoneNumber(phoneNum);
                return true;
            }
        }

        //throw exception to confirm that no match was found for unique contact id
        throw new IllegalArgumentException("No match found.");
    }

    // Update Contact instance's address via ID
    public boolean updateContactAddress(String uniqueID, String locality){

        //iterate through list to find object with ID matching parameter ID
        for(int i = 0; i < myContacts.size(); i++){

            //if ith index object of database has ID equivalent to parameter ID then set address to parameter
            if(myContacts.get(i).getContactID() == uniqueID){

                myContacts.get(i).setAddress(locality);
                return true;
            }
        }

        //throw exception to confirm that no match was found for unique contact id
        throw new IllegalArgumentException("No match found.");
    }

    //return function for i-th index of the Contact Service database
    public Contact getCServObj(int i){ return this.myContacts.get(i);}

    //return function to be service database
    public List<Contact> getDatabase(){ return this.myContacts;}

    ContactService(){
        this.myContacts = new ArrayList<Contact>();
    }
}
