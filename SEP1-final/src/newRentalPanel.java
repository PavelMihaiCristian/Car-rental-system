

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * a class made for creating the new Rental panel
 * @author mihai cristian pavel
 * @version 1.0
 */
public class newRentalPanel extends JPanel
{
   private RentalListAdaptor adaptor;
   private VehicleAdapter vehicleAdaptor;
   private CustomerAdaptor customerAdapter;
   private MyListener listener;
   private ListListener listListener;
   
   private JLabel vehicleType;
   private JComboBox typeDropdown;
   private final String[] vehicleChoise={"All","Family Car","Van","Moving Truck","Auto Camper"};
   
   private JLabel pickUpDay;
   private JLabel pickUpMonth;
   private JLabel pickUpYear;
   private JLabel pickUpHour;
   private JLabel pickUpMinute;
   private JLabel returnDay;
   private JLabel returnMonth;
   private JLabel returnYear;
   private JLabel returnHour;
   private JLabel returnMinute;
   
   private JComboBox pickUpDayInput;
   private JComboBox pickUpMonthInput;
   private JComboBox pickUpYearInput;
   private JComboBox pickUpHourInput;
   private JComboBox pickUpMinuteInput;
   private JComboBox returnDayInput;
   private JComboBox returnMonthInput;
   private JComboBox returnYearInput;
   private JComboBox returnHourInput;
   private JComboBox returnMinuteInput;
   
   private final Integer[] day={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
   private final Integer[] month={1,2,3,4,5,6,7,8,9,10,11,12};
   private final Integer[] hour={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
   private final Integer[] minute={0,15,30,45};
   private static final GregorianCalendar today=new GregorianCalendar();
   private static final Integer[] year={today.get(today.YEAR),today.get(today.YEAR)+1,today.get(today.YEAR)+2};
   
   private JPanel vehicleTypePanel;
   private JPanel datePanel;
   private JPanel pickUpDatePanel;
   private JPanel returnDatePanel;
   private JPanel listOfAvailablePanel;
   private JPanel namePanel;
   private JPanel phoneLicencePanel;
   private JPanel pickUpReturnPanel;
   private JPanel buttonPanel;
   private JPanel estimatedPricePanel;
   
   private JList<Vehicle> availableVehicles;
   private JScrollPane pane;
   
   private JLabel firstNameLabel;
   private JLabel lastNameLabel;
   private JLabel phoneNumberLabel;
   private JLabel licenseNumberLabel;
   private JLabel pickUpLabel;
   private JLabel returnLabel;
   private JLabel estimatedKM;
   private JLabel estimatedPrice;
   
   private JTextField firstNameText;
   private JTextField lastNameText;
   private JTextField phoneNumberText;
   private JTextField licenseNumberText;
   private JTextField estimateKmText;
   private JTextField estimatedPriceText;
   
   private JComboBox pickUpLocationLabel;
   private JComboBox returnLocationLabel;
   
   private final String[] locations={"Horsens","Viborg","Aalborg","Aarhus","Copenhagen"};
   
   private JButton done;
   private JButton cancel;
   private JButton search;
   
   private Vehicle temporaryVehicle;
   /**
    * a one-argument constructor for the new panel
    * @param adaptor rental list adaptor
    * @param vehicleAdaptor vehicle adaptor
    * @param customerAdapter customer adaptor
    */
   public newRentalPanel(RentalListAdaptor adaptor,VehicleAdapter vehicleAdaptor,CustomerAdaptor customerAdapter)
   {
      this.adaptor=adaptor;
      this.vehicleAdaptor=vehicleAdaptor;
      this.customerAdapter=customerAdapter;
      listener=new MyListener();
      listListener=new ListListener();
      temporaryVehicle=null;
      
      vehicleTypePanel=new JPanel();
      vehicleTypePanel.setSize(1000,50);
      vehicleType=new JLabel("Vehicle type");
      typeDropdown=new JComboBox(vehicleChoise);
      typeDropdown.addActionListener(listener);
      vehicleTypePanel.add(vehicleType);
      vehicleTypePanel.add(typeDropdown);
      add(vehicleTypePanel);
     
      namePanel=new JPanel();
      namePanel.setSize(900,25);
      namePanel.setBorder(BorderFactory.createTitledBorder("Customer name"));
      firstNameLabel=new JLabel("First Name");
      firstNameText=new JTextField(20);
      firstNameText.addActionListener(listener);
      lastNameLabel=new JLabel("Last Name");
      lastNameText=new JTextField(20);
      lastNameText.addActionListener(listener);
      phoneNumberLabel=new JLabel("Phone Number");
      phoneNumberText=new JTextField(20);
      phoneNumberText.addActionListener(listener);
      licenseNumberLabel=new JLabel("Driver License Number");
      licenseNumberText=new JTextField(20);
      licenseNumberText.addActionListener(listener);
      namePanel.add(firstNameLabel);
      namePanel.add(firstNameText);
      namePanel.add(lastNameLabel);
      namePanel.add(lastNameText);
      
      
      availableVehicles=new JList<Vehicle>();
      availableVehicles.setVisibleRowCount(10);
      availableVehicles.addListSelectionListener(listListener);
      pane=new JScrollPane(availableVehicles);
      pane.setSize(900,400);
      pane.setBorder(BorderFactory.createTitledBorder("Available vehicles"));
      
      datePanel=new JPanel();
      datePanel.setSize(990,200);
      pickUpDatePanel=new JPanel();
      pickUpDatePanel.setBorder(BorderFactory.createTitledBorder("Pick-Up Date"));
      pickUpDatePanel.setSize(490,190);
      returnDatePanel=new JPanel();
      returnDatePanel.setBorder(BorderFactory.createTitledBorder("Return Date"));
      returnDatePanel.setSize(490,190);
      pickUpDay=new JLabel("Day");
      pickUpDayInput=new JComboBox(day);
      pickUpDayInput.addActionListener(listener);
      int dayIndex = today.get(GregorianCalendar.DATE);
      pickUpDayInput.setSelectedIndex(dayIndex-1);
      pickUpMonth=new JLabel("Month");
      pickUpMonthInput=new JComboBox(month);
      pickUpMonthInput.addActionListener(listener);
      int monthIndex=today.get(GregorianCalendar.MONTH);
      pickUpMonthInput.setSelectedIndex(monthIndex);
      pickUpYear=new JLabel("Year");
      pickUpYearInput=new JComboBox(year);
      pickUpYearInput.addActionListener(listener);
      pickUpYearInput.setSelectedIndex(0);
      pickUpHour= new JLabel("hour");
      pickUpHourInput=new JComboBox(hour);
      pickUpHourInput.addActionListener(listener);
      int hourIndex=today.get(GregorianCalendar.HOUR_OF_DAY);
      pickUpHourInput.setSelectedIndex(hourIndex);
      pickUpMinute=new JLabel("Minute");
      pickUpMinuteInput=new JComboBox(minute);
      pickUpMinuteInput.addActionListener(listener);
      int minuteIndex=today.get(GregorianCalendar.MINUTE);
      if(minuteIndex>45) 
         {
            pickUpMinuteInput.setSelectedIndex(0);
            pickUpHourInput.setSelectedIndex(pickUpHourInput.getSelectedIndex()+1);
         }
      else if(minuteIndex>30) pickUpMinuteInput.setSelectedIndex(3);
            else if(minuteIndex>15) pickUpMinuteInput.setSelectedIndex(2);
                  else pickUpMinuteInput.setSelectedIndex(1);          
      pickUpDatePanel.add(pickUpDay);
      pickUpDatePanel.add(pickUpDayInput);
      pickUpDatePanel.add(pickUpMonth);
      pickUpDatePanel.add(pickUpMonthInput);
      pickUpDatePanel.add(pickUpYear);
      pickUpDatePanel.add(pickUpYearInput);
      pickUpDatePanel.add(pickUpHour);
      pickUpDatePanel.add(pickUpHourInput);
      pickUpDatePanel.add(pickUpMinute);
      pickUpDatePanel.add(pickUpMinuteInput);
      
      returnDay=new JLabel("Day");
      returnDayInput=new JComboBox(day);
      returnDayInput.addActionListener(listener);
      returnDayInput.setSelectedIndex(dayIndex);
      returnMonth=new JLabel("Month");
      returnMonthInput=new JComboBox(month);
      returnMonthInput.addActionListener(listener);
      returnMonthInput.setSelectedIndex(monthIndex);
      returnYear=new JLabel("Year");
      returnYearInput=new JComboBox(year);
      returnYearInput.addActionListener(listener);
      returnYearInput.setSelectedIndex(0);
      returnHour= new JLabel("hour");
      returnHourInput=new JComboBox(hour);
      returnHourInput.setSelectedIndex(hourIndex);
      returnHourInput.addActionListener(listener);
      returnMinute=new JLabel("Minute");
      returnMinuteInput=new JComboBox(minute);
      returnMinuteInput.addActionListener(listener);
      if(minuteIndex>45) 
      {
         returnMinuteInput.setSelectedIndex(0);
         returnHourInput.setSelectedIndex(returnHourInput.getSelectedIndex()+1);
      }
      else if(minuteIndex>30) returnMinuteInput.setSelectedIndex(3);
         else if(minuteIndex>15) returnMinuteInput.setSelectedIndex(2);
               else returnMinuteInput.setSelectedIndex(1);
      returnDatePanel.add(returnDay);
      returnDatePanel.add(returnDayInput);
      returnDatePanel.add(returnMonth);
      returnDatePanel.add(returnMonthInput);
      returnDatePanel.add(returnYear);
      returnDatePanel.add(returnYearInput);
      returnDatePanel.add(returnHour);
      returnDatePanel.add(returnHourInput);
      returnDatePanel.add(returnMinute);
      returnDatePanel.add(returnMinuteInput);
      
      search=new JButton("Search");
      search.addActionListener(listener);
      datePanel.add(pickUpDatePanel);
      datePanel.add(returnDatePanel);
      datePanel.add(search);
      add(datePanel);
      
      listOfAvailablePanel=new JPanel();
      listOfAvailablePanel.setBorder(BorderFactory.createTitledBorder("Estimated Km usage"));
      listOfAvailablePanel.setSize(900,20);
      estimatedKM=new JLabel("Estimated KM");
      estimateKmText=new JTextField(10);
      estimateKmText.addActionListener(listener);
      
      listOfAvailablePanel.add(estimatedKM);
      listOfAvailablePanel.add(estimateKmText);
      add(pane);
      add(listOfAvailablePanel);
      
      add(namePanel);
      
      phoneLicencePanel=new JPanel();
      phoneLicencePanel.setSize(900,25);
      phoneLicencePanel.setBorder(BorderFactory.createTitledBorder("Customer Information"));
      phoneLicencePanel.add(phoneNumberLabel);
      phoneLicencePanel.add(phoneNumberText);
      phoneLicencePanel.add(licenseNumberLabel);
      phoneLicencePanel.add(licenseNumberText);
      add(phoneLicencePanel);
      
      pickUpReturnPanel=new JPanel();
      pickUpReturnPanel.setSize(900,25);
      pickUpReturnPanel.setBorder(BorderFactory.createTitledBorder("Location"));
      pickUpLocationLabel=new JComboBox(locations);
      returnLocationLabel=new JComboBox(locations);
      pickUpLocationLabel.addActionListener(listener);
      returnLocationLabel.addActionListener(listener);
      pickUpLocationLabel.setSelectedIndex(0);
      returnLocationLabel.setSelectedIndex(0);
      pickUpLabel=new JLabel("Pick-Up Location");
      returnLabel=new JLabel("Return Location");
      pickUpReturnPanel.add(pickUpLabel);
      pickUpReturnPanel.add(pickUpLocationLabel);
      pickUpReturnPanel.add(returnLabel);
      pickUpReturnPanel.add(returnLocationLabel);
      add(pickUpReturnPanel);
      
      buttonPanel=new JPanel();
      buttonPanel.setSize(900,25);
      done=new JButton("Done");
      cancel=new JButton("Cancel");
      done.addActionListener(listener);
      cancel.addActionListener(listener);
      buttonPanel.add(done);
      buttonPanel.add(cancel);
      add(buttonPanel);
      
      estimatedPricePanel=new JPanel();
      estimatedPrice=new JLabel("Estimated price");
      estimatedPriceText=new JTextField(10);
      estimatedPriceText.addActionListener(listener);
      estimatedPricePanel.add(estimatedPrice);
      estimatedPricePanel.add(estimatedPriceText);
      add(estimatedPricePanel);
      
   }
  
   /**
    * a class for the action listeners from the new panel
    * @author mihai cristian pavel
    * @version 1.0
    */
   private class MyListener implements ActionListener
   {
      int pickupday=-1,pickupmonth=-1,pickupyear=-1,pickuphour=-1,pickupminute=-1,returnday=-1,returnmonth=-1,returnyear=-1,returnhour=-1,returnminute=-1;
      String pickUpLocation="",returnLocation="";
      String licenseNumber="";
      public void actionPerformed(ActionEvent e)
      {
         
         Date pick=null,delivery=null;
         RentalList rentals=adaptor.getAllRentals();
         CustomerList customers=customerAdapter.getAllCustomers();
         String firstName="",lastName="",phoneNumber="";
         VehicleList all=vehicleAdaptor.getAllVehicles();
         Vehicle[] allVehicles=new Vehicle[all.size()];
         for(int i=0;i<all.size();i++)
         {
            allVehicles[i]=all.getVehicleByIndex(i);
         }
         Vehicle[] familyCars=vehicleAdaptor.getFamilyCars();
         Vehicle[] vans=vehicleAdaptor.getVans();
         Vehicle[] trucks=vehicleAdaptor.getMovingTrucks();
         Vehicle[] autoCamper=vehicleAdaptor.getAutoCamper();
         
         ArrayList<Vehicle> temp=new ArrayList<Vehicle>();
         Vehicle[] newListOfVehicle=new Vehicle[temp.size()];
         
         Customer temporaryCustomer=null;
         Rental temporaryRental=null;
         
         
         if(e.getSource()==typeDropdown)
         {
            if(typeDropdown.getSelectedIndex()==0)
            {
               availableVehicles.setListData(allVehicles);
            }
            if(typeDropdown.getSelectedIndex()==1)
            {
               availableVehicles.setListData(familyCars);
            }
            if(typeDropdown.getSelectedIndex()==2)
            {
               availableVehicles.setListData(vans);
            }
            if(typeDropdown.getSelectedIndex()==3)
            {
               availableVehicles.setListData(trucks);
            }
            if(typeDropdown.getSelectedIndex()==4)
            {
               availableVehicles.setListData(autoCamper);
            }
         }
         if(e.getSource()==pickUpDayInput) pickupday =(int)pickUpDayInput.getSelectedItem();
         if(e.getSource()==pickUpMonthInput) pickupmonth = (int)pickUpMonthInput.getSelectedItem();
         if(e.getSource()==pickUpYearInput) pickupyear = (int)pickUpYearInput.getSelectedItem();
         if(e.getSource()==pickUpHourInput) pickuphour = (int)pickUpHourInput.getSelectedItem();
         if(e.getSource()==pickUpMinuteInput) pickupminute = (int)pickUpMinuteInput.getSelectedItem();
         if(e.getSource()==returnDayInput) returnday = (int)returnDayInput.getSelectedItem();
         if(e.getSource()==returnMonthInput) returnmonth = (int)returnMonthInput.getSelectedItem();
         if(e.getSource()==returnYearInput) returnyear = (int)returnYearInput.getSelectedItem();
         if(e.getSource()==returnHourInput) returnhour= (int)returnHourInput.getSelectedItem();
         if(e.getSource()==returnMinuteInput) returnminute = (int)returnMinuteInput.getSelectedItem();
         pick=new Date(pickupday, pickupmonth, pickupyear, pickuphour, pickupminute);
         delivery=new Date(returnday, returnmonth, returnyear, returnhour, returnminute);
         firstName=firstNameText.getText();
         lastName=lastNameText.getText();
         phoneNumber=phoneNumberText.getText();
         licenseNumber=licenseNumberText.getText();
         if(e.getSource()==search)
         {   
            if(typeDropdown.getSelectedIndex()==0)
            {
               if(pick!=null && delivery!=null) 
               {
               for(int i=0;i<allVehicles.length;i++)
               {
                  boolean flag=true;
                  for(int j=0;j<rentals.size();j++)
                  {
                     if(rentals.getRentalAtIndex(j).getVehicle().equals(allVehicles[i]))
                     {
                        if(rentals.checkRentalAvailability(new Rental(allVehicles[i],rentals.getRentalAtIndex(j).getCustomer(), pick, delivery, rentals.getRentalAtIndex(j).getPickUPLocation(), rentals.getRentalAtIndex(j).getReturnLocation()))==false) 
                           {
                              flag=false;
                           }
                     }
                  }
                  if(flag==true) temp.add(allVehicles[i]);
               }
               newListOfVehicle=new Vehicle[temp.size()];
               temp.toArray(newListOfVehicle);
               availableVehicles.setListData(newListOfVehicle);
               }
            }
            if(typeDropdown.getSelectedIndex()==1)
            {
               if(pick!=null && delivery!=null) 
               {
               for(int i=0;i<familyCars.length;i++)
               {
                  boolean flag=true;
                  for(int j=0;j<rentals.size();j++)
                  {
                     if(rentals.getRentalAtIndex(j).getVehicle().equals(familyCars[i]))
                     {
                        if(rentals.checkRentalAvailability(new Rental(familyCars[i],rentals.getRentalAtIndex(j).getCustomer(), pick, delivery, rentals.getRentalAtIndex(j).getPickUPLocation(), rentals.getRentalAtIndex(j).getReturnLocation()))==false) 
                           {
                              flag=false;
                           }
                     }
                  }
                  if(flag==true) temp.add(familyCars[i]);
               }
               newListOfVehicle=new Vehicle[temp.size()];
               temp.toArray(newListOfVehicle);
               availableVehicles.setListData(newListOfVehicle);
               }
            }
            if(typeDropdown.getSelectedIndex()==2)
            {
               if(pick!=null && delivery!=null) 
               {
               for(int i=0;i<vans.length;i++)
               {
                  boolean flag=true;
                  for(int j=0;j<rentals.size();j++)
                  {
                     if(rentals.getRentalAtIndex(j).getVehicle().equals(vans[i]))
                     {
                        if(rentals.checkRentalAvailability(new Rental(vans[i],rentals.getRentalAtIndex(j).getCustomer(), pick, delivery, rentals.getRentalAtIndex(j).getPickUPLocation(), rentals.getRentalAtIndex(j).getReturnLocation()))==false) 
                           {
                              flag=false;
                           }
                     }
                  }
                  if(flag==true) temp.add(vans[i]);
               }
               newListOfVehicle=new Vehicle[temp.size()];
               temp.toArray(newListOfVehicle);
               availableVehicles.setListData(newListOfVehicle);
               }
            }
            if(typeDropdown.getSelectedIndex()==3)
            {
               if(pick!=null && delivery!=null) 
               {
               for(int i=0;i<trucks.length;i++)
               {
                  boolean flag=true;
                  for(int j=0;j<rentals.size();j++)
                  {
                     if(rentals.getRentalAtIndex(j).getVehicle().equals(trucks[i]))
                     {
                        if(rentals.checkRentalAvailability(new Rental(trucks[i],rentals.getRentalAtIndex(j).getCustomer(), pick, delivery, rentals.getRentalAtIndex(j).getPickUPLocation(), rentals.getRentalAtIndex(j).getReturnLocation()))==false) 
                           {
                              flag=false;
                           }
                     }
                  }
                  if(flag==true) temp.add(trucks[i]);
               }
               newListOfVehicle=new Vehicle[temp.size()];
               temp.toArray(newListOfVehicle);
               availableVehicles.setListData(newListOfVehicle);
               }
            }
            if(typeDropdown.getSelectedIndex()==4)
            {
               if(pick!=null && delivery!=null) 
               {
               for(int i=0;i<autoCamper.length;i++)
               {
                  boolean flag=true;
                  for(int j=0;j<rentals.size();j++)
                  {
                     if(rentals.getRentalAtIndex(j).getVehicle().equals(autoCamper[i]))
                     {
                        if(rentals.checkRentalAvailability(new Rental(autoCamper[i],rentals.getRentalAtIndex(j).getCustomer(), pick, delivery, rentals.getRentalAtIndex(j).getPickUPLocation(), rentals.getRentalAtIndex(j).getReturnLocation()))==false) 
                           {
                              flag=false;
                           }
                     }
                  }
                  if(flag==true) temp.add(autoCamper[i]);
               }
               newListOfVehicle=new Vehicle[temp.size()];
               temp.toArray(newListOfVehicle);
               availableVehicles.setListData(newListOfVehicle);
               }
            }
         }
         if(firstName!=null && lastName!=null && phoneNumber!=null) 
            {
               temporaryCustomer=new Customer(firstName, lastName, phoneNumber,licenseNumber);
            }
         if(e.getSource()==pickUpLocationLabel)
         {
            pickUpLocation=locations[pickUpLocationLabel.getSelectedIndex()];
            
         }
         if(e.getSource()==returnLocationLabel)
         {
            returnLocation=locations[returnLocationLabel.getSelectedIndex()];
         }

         if(e.getSource()==done)
         {
            if(pick.isBefore(new Date()))
            {
               JOptionPane.showMessageDialog(null,"Invalid Pick-up Date");
            }
            else if(delivery.isBefore(pick))
                  {
                     JOptionPane.showMessageDialog(null,"Delivery day is before pick-up date.Choose another day");
                  }
               else
               { 
                  temporaryRental=new Rental(availableVehicles.getSelectedValue(), temporaryCustomer, pick, delivery, (String)pickUpLocationLabel.getSelectedItem(), returnLocation);
                  customerAdapter.addCustomer(temporaryCustomer);
              
                  int km=Integer.parseInt(estimateKmText.getText());
                  estimatedPriceText.setText(temporaryRental.calculateRentalPrice(km)+""); 
                  adaptor.addRental(temporaryRental);
                  resetAllFields();
                  if(licenseNumber.length()==0)
                  {
                     JOptionPane.showMessageDialog(null,"The reservation is made in the system");
                  }
                  else
                  {
                     JOptionPane.showMessageDialog(null,"The rental is made in the system");
                  }
               }
            
         }
         if(e.getSource()==cancel)
         {
            resetAllFields();
         }
         
      }
   }
   /**
    * a class for the action listeners for the vehicle list in the new rental panel
    * @author mihai cristian pavel
    * @version 1.0
    */
   public class ListListener implements ListSelectionListener
   {
      public void valueChanged(ListSelectionEvent e)
      {
         if(e.getSource()==availableVehicles)
         {
            temporaryVehicle=availableVehicles.getSelectedValue();
         }
      }
   }
   /**
    * a method for reseting all the fields after the new rental is done or after presing the cancel button
    */
   public void resetAllFields()
   {
      int dayIndex = today.get(GregorianCalendar.DATE);
      int monthIndex=today.get(GregorianCalendar.MONTH);
      int hourIndex=today.get(GregorianCalendar.HOUR_OF_DAY);
      typeDropdown.setSelectedIndex(0);
      pickUpDayInput.setSelectedIndex(dayIndex);
      pickUpMonthInput.setSelectedIndex(monthIndex);
      pickUpYearInput.setSelectedIndex(0);
      pickUpHourInput.setSelectedIndex(hourIndex);
      pickUpMinuteInput.setSelectedIndex(0);
      int minuteIndex=today.get(GregorianCalendar.MINUTE);
      if(minuteIndex>45) 
         {
            pickUpMinuteInput.setSelectedIndex(0);
            pickUpHourInput.setSelectedIndex(pickUpHourInput.getSelectedIndex()+1);
         }
      else if(minuteIndex>30) pickUpMinuteInput.setSelectedIndex(3);
            else if(minuteIndex>15) pickUpMinuteInput.setSelectedIndex(2);
                  else pickUpMinuteInput.setSelectedIndex(1); 
      returnDayInput.setSelectedIndex(dayIndex+1);
      returnMonthInput.setSelectedIndex(monthIndex);
      returnYearInput.setSelectedIndex(0);
      returnHourInput.setSelectedIndex(hourIndex);
      if(minuteIndex>45) 
      {
         returnMinuteInput.setSelectedIndex(0);
         returnHourInput.setSelectedIndex(returnHourInput.getSelectedIndex()+1);
      }
      else if(minuteIndex>30) returnMinuteInput.setSelectedIndex(3);
         else if(minuteIndex>15) returnMinuteInput.setSelectedIndex(2);
               else returnMinuteInput.setSelectedIndex(1); 
      availableVehicles.removeAll();
      pickUpLocationLabel.setSelectedIndex(0);
      returnLocationLabel.setSelectedIndex(0);
      firstNameText.setText("");
      lastNameText.setText("");
      phoneNumberText.setText("");
      licenseNumberText.setText("");
      estimateKmText.setText("");
   }
}
