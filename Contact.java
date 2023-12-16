import static java.lang.Integer.parseInt;

public class Contact {
    private String contactID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    //Constructor
    Contact(String ID, String givenName, String surname, String contactNumber, String locality)
    {

        //Initialization of unique contact ID
        if(ID.length() > 10  || ID == null){
            throw new IllegalArgumentException("Invalid unique contact ID.");
        }
        this.contactID = ID;

        //Initialization of first name
        if(givenName.length() > 10  || givenName == null){
            throw new IllegalArgumentException("Invalid first name.");
        }
        this.firstName = givenName;

        //Initialization of last name
        if(surname.length() > 10  || surname == null){
            throw new IllegalArgumentException("Invalid last name.");
        }
        this.lastName = surname;

        //Initialization of phone number
        if(contactNumber.length() != 10){
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phoneNumber = contactNumber;

        //Initialization of address
        if(locality.length() > 30 || locality == null){
            throw new IllegalArgumentException("Invalid address.");
        }
        this.address = locality;

    };

    //public access functions for private member variables
    public String getContactID(){
        return this.contactID;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public String getAddress(){
        return this.address;
    }

    //public updater functions for private member variables
    public void setFirstName(String givenName){
        if(givenName == null || givenName.length() > 10){
            throw new IllegalArgumentException("First name is invalid.");
        }
        this.firstName = givenName;
    }
    public void setLastName(String surname){
        if(surname == null || surname.length() > 10) {
            throw new IllegalArgumentException("Last name is invalid.");
        }
        this.lastName = surname;
    }
    public void setPhoneNumber(String phoneNum){
        if(phoneNum == null){
            throw new NullPointerException("Invalid phone number.");
        }
        else if(phoneNum.length() != 10){
            throw new IllegalArgumentException("Phone number is invalid.");
        }
        else {
            if(Character.isDigit(parseInt(phoneNum))) {
                this.phoneNumber = phoneNum;
            }
            else{
                throw new IllegalArgumentException("Invalid phone number.");
            }
        }
    }
    public void setAddress(String locality){
        if(locality == null || locality.length() > 30){
            throw new IllegalArgumentException("Address is invalid.");
        }
        this.address = locality;
    }

}
