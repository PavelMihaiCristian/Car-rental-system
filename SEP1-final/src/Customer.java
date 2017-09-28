

import java.io.Serializable;

/**
 * A class that is responsible for creating customer objects
 * @author mihai cristian pavel
 * @version 1.0
 */
public class Customer implements Serializable
{
   private String firstName;
   private String lastName;
   private String phoneNumber;
   private String licenseNo;
 
   /**
    * a 4-argument constructor that is initializing all the fields with the values given by the parameters
    * @param firstName the first name of the customer
    * @param lastName the last name of the customer
    * @param phoneNumber the phone number of the customer
    * @param licenseNo the driver license number of the customer
    */
   public Customer(String firstName,String lastName,String phoneNumber,String licenseNo)
   {
      this.firstName=firstName;
      this.lastName=lastName;
      this.phoneNumber=phoneNumber;
      this.licenseNo=licenseNo;
   }
   /**
    * a 3-argument constructor that is initializing the first name, last name and phone number of the customer with the values received by the parameters and the license number with null. this will be used for reservations
    * @param firstName the first name of the customer
    * @param lastName the last name of the customer
    * @param phoneNumber the phone number of the customer
    */
   public Customer(String firstName,String lastName,String phoneNumber)
   {
      this.firstName=firstName;
      this.lastName=lastName;
      this.phoneNumber=phoneNumber;
      this.licenseNo="";
   }
   /**
    * a method that sets the first name of the customer
    * @param firstName the first name of the customer
    */
   public void setFirstName(String firstName)
   {
      this.firstName=firstName;
   }
   /**
    * a set method for the lastName field
    * @param lastName the last name of the customer
    */
   public void setLastName(String lastName)
   {
      this.lastName=lastName;
   }
   /**
    * a set method for the phone number field
    * @param phoneNumber the phone number of the customer
    */
   public void setPhoneNumber(String phoneNumber)
   {
      this.phoneNumber=phoneNumber;
   }
   /**
    * a set method for the license number field
    * @param licenseNo the driver license number of the customer
    */
   public void setLicenseNo(String licenseNo)
   {
      this.licenseNo=licenseNo;
   }
   /**
    * a get method for the first name of the customer
    * @return the firstName field's value
    */
   public String getFirstName()
   {
      return firstName;
   }
   /**
    * a get method for the last name of the customer
    * @return the lastName field's value
    */
   public String getLastName()
   {
      return lastName;
   }
   /**
    * a get method for the phone number of the customer
    * @return the phoneNumber field's value
    */
   public String getPhoneNumber()
   {
      return phoneNumber;
   }
   /**
    * a get method for the license number of the customer
    * @return the licenseNo field's value
    */
   public String getLicenseNo()
   {
      return licenseNo;
   }
   /**
    * a toString method that will return a String object with all the information about a customer
    */
   public String toString()
   {
      return firstName+" "+lastName+" "+phoneNumber+" "+licenseNo;
   }
   /**
    * a equals method that can be used to compare 2 objects
    * @return a boolean value true if the 2 objects of the Customer class are the same, or false if the 2 objects are different
    */
   public boolean equals(Object obj)
   {
      if(!(obj instanceof Customer)) return false;
      Customer other=(Customer)obj;
      return firstName.equals(other.firstName) && lastName.equals(other.lastName) &&
            phoneNumber.equals(other.phoneNumber) && licenseNo.equals(other.licenseNo);
   }
}
