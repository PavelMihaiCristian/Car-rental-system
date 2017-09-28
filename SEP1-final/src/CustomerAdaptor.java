

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

/**
 * A class used for working with the CustomerList class
 * @author mihai cristian pavel
 * @version 1.0
 */
public class CustomerAdaptor implements Serializable
{
   MyFileIO mfio;
   String fileName;
   
   /**
    * A one-argument constructor used for initializing
    * @param fileName the file name where the file will be saved
    */
   public CustomerAdaptor(String fileName)
   {
      mfio=new MyFileIO();
      this.fileName=fileName;
   }
   /**
    * A method for reading the Customer list object from the file
    * @return a CustomerList object
    */
   public CustomerList getAllCustomers()
   {
      CustomerList temp=null;
      try{
         temp=(CustomerList)mfio.readObjectFromFile(fileName);
      }
      catch(FileNotFoundException e){
         System.out.println("File not found");
      }
      catch(IOException e){
         System.out.println("file not found");
      }
      catch(ClassNotFoundException e){
         System.out.println("class not found");
      }
      return temp;
   }
   /**
    * a method for saving the updated object to the file
    * @param customers the CustomerList object
    */
   public void saveCustomers(CustomerList customers)
   {
      try{
         mfio.writeToFile(fileName, customers);
      }
      catch(FileNotFoundException e){
         System.out.println("File not found");
      }
      catch(IOException e){
         System.out.println("IO exception writing to file");
      }
   }
   /**
    * a method that adds a customer to the list and after saves the list to the file
    * @param customer the customer that will be added to the list
    */
   public void addCustomer(Customer customer)
   {
      CustomerList temp=getAllCustomers();
      temp.addCustomer(customer);
      saveCustomers(temp);
      getAllCustomers();
   }
   /**
    * a method that is reading the CustomerList object from the file , deleting the Customer with the specific values in firstName and lastName fields and updates the file with the new CustomerList
    * @param firstName first name of the person is needed to delete
    * @param lastName last name of the person that is needed to delete
    */
   public void deleteCustomerByName(String firstName,String lastName)
   {
      CustomerList temp=getAllCustomers();
      temp.deleteCustomerByName(firstName, lastName);
      saveCustomers(temp);
      getAllCustomers();
   }
   /**
    * a method used to delete a customer with the phone number given by the parameter phoneNumber
    * @param phoneNumber phone number of the person that is being deleted
    */
   public void deleteCustomerByPhoneNumber(String phoneNumber)
   {
      CustomerList temp=getAllCustomers();
      CustomerList updated=new CustomerList();
      for(int i=0;i<temp.size();i++)
      {
         if(!(temp.getCustomerAtIndex(i).getPhoneNumber().equals(phoneNumber)))
         {
            updated.addCustomer(temp.getCustomerAtIndex(i));
         }
      }
      saveCustomers(updated);
      getAllCustomers();
   }
   /**
    * a method for changing the phone number for a customer in the list
    * @param firstName first name of the person that will have his phone number changed
    * @param lastName last name of the person that will have his phone number changed
    * @param phoneNumber the new phone number of the customer with the first and last name given by the parameters firstName and lastName
    */
   public void editCustomerData(String firstName,String lastName,String phoneNumber)
   {
      CustomerList temp=getAllCustomers();
      temp.getCustomerByName(firstName, lastName).setPhoneNumber(phoneNumber);
      saveCustomers(temp);
      getAllCustomers();
   }
}
