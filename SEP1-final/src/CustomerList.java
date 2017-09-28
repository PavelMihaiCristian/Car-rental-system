

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing a list of Customer objects
 * @author mihai cristian pavel
 * @version 1.0
 */
public class CustomerList implements Serializable
{
   private ArrayList<Customer> customers;
   /**
    * No-argument constructor initializing the CustomerList
    */
   public CustomerList()
   {
      customers=new ArrayList<Customer>();
   }
   /**
    * a get method for the customer list size
    * @return the size of the customer list
    */
   public int size()
   {
      return customers.size();
   }
   /**
    * a get method for all the customers in the list
    * @return a array with all the customers
    */
   public Customer[] getAllCustomers()
   {
      Customer[] temp=new Customer[size()];
      return customers.toArray(temp);
   }
   /**
    * a method created to add a new customer to the customerList
    * @param customer the customer that will be added to the list
    */
   public void addCustomer(Customer customer)
   {
      customers.add(customer);
   }
   /**
    * a method created to delete a customer from the list with the first name and last name given as parameters
    * @param firstName first name of the person
    * @param lastName last name of the person
    */
   public void deleteCustomerByName(String firstName,String lastName)
   {
      for(int i=0;i<customers.size();i++)
      {
         if(customers.get(i).equals(getCustomerByName(firstName, lastName))) 
            {
            customers.remove(i);
            break;
            }
      }
   }
   /**
    * a get method for a customer from the customer list at a certain position
    * @param index the position in the list
    * @return the customer from the position index from the list
    */
   public Customer getCustomerAtIndex(int index)
   {
      if(index<customers.size()) return customers.get(index);
      else return null;
   }
   /**
    * a get method for a customer with a specific phone number
    * @param phoneNumber the phone number of the customer that is searched in the list
    * @return the customer with a certain phone number or null if it does not find a customer with that phone number
    */
   public Customer getCustomerByPhoneNumber(String phoneNumber)
   {
      Customer temp=null;
      for(int i=0;i<size();i++)
      {
         if(customers.get(i).getPhoneNumber().equals(phoneNumber)) 
            {
            temp=customers.get(i);
            break;
            }
      }
      return temp;
   }
   /**
    * a get method for a customer from the list with a specific first name and last name
    * @param firstName first name of the customer that is searched for
    * @param lastName last name of the customer that is searched for
    * @return the customer with the firstName and lastName that match the arguments given, else returns null
    */
   public Customer getCustomerByName(String firstName,String lastName)
   {
      Customer temp=null;
      for(int i=0;i<size();i++)
      {
         if(customers.get(i).getFirstName().equals(firstName) && customers.get(i).getLastName().equals(lastName))
         {
            temp=customers.get(i);
            break;
         }
      }
      return temp;
   }
   /**
    * a toString method that returns all the customers
    */
   public String toString()
   {
      String str="";
      for(int i=0;i<customers.size();i++)
      {
         str+=customers.get(i)+"\n";
      }
      return str;
   }
}
