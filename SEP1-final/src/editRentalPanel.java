

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * a class used for creating the edit rental panel
 * @author mihai cristian pavel
 * @version 1.0
 */
public class editRentalPanel extends JPanel
{
   private JPanel searchPanelName;
   private JPanel searchPanelPickUpDate;
   private JPanel newDatePanel;
   private JPanel newPickUpDatePanel;
   private JPanel newDeliveryDatePanel;
   private JPanel newNamePanel;
   private JPanel newInfoPanel;
   private JPanel newLocationPanel;
   private JPanel buttonPanel;
   private JPanel reservationPanel;
   
   private JLabel searchFirstNameLabel;
   private JLabel searchLastNameLabel;
   private JLabel searchPickDayLabel;
   private JLabel searchPickMonthLabel;
   private JLabel searchPickYearLabel;
   private JLabel searchPickHourLabel;
   private JLabel searchPickMinuteLabel;
   
   private JTextField searchFirstNameText;
   private JTextField searchLastNameText;
   private JComboBox searchPickDayText;
   private JComboBox searchPickMonthText;
   private JComboBox searchPickYearText;
   private JComboBox searchPickHourText;
   private JComboBox searchPickMinuteText;
   private JTextField foundFirstNameText;
   private JTextField foundLastNameText;
   private JTextField foundPhoneNumberText;
   private JTextField foundLicenseNumberText;
   private JTextField reservationText;
   
   private JLabel pickDayLabel;
   private JLabel pickMonthLabel;
   private JLabel pickYearLabel;
   private JLabel pickHourLabel;
   private JLabel pickMinuteLabel;
   private JLabel deliveryDayLabel;
   private JLabel deliveryMonthLabel;
   private JLabel deliveryYearLabel;
   private JLabel deliveryHourLabel;
   private JLabel deliveryMinuteLabel;
   private JLabel foundFirstNameLabel;
   private JLabel foundLastNameLabel;
   private JLabel foundPhoneNumberLabel;
   private JLabel foundLicenseNumberLabel;
   private JLabel choosePickUpLOcationLabel;
   private JLabel chooseDeliveryLocation;
   private JLabel reservationLabel;
   
   private JComboBox pickDayChoise;
   private JComboBox pickMonthChoise;
   private JComboBox pickYearChoise;
   private JComboBox pickHourChoise;
   private JComboBox pickMinuteChoise;
   private JComboBox deliveryDayChoise;
   private JComboBox deliveryMonthChoise;
   private JComboBox deliveryYearChoise;
   private JComboBox deliveryHourChoise;
   private JComboBox deliveryMinuteChoise;
   private JComboBox newPickUpLocation;
   private JComboBox newDeliveryLocation;
   
   private final Integer[] day={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
   private final Integer[] month={1,2,3,4,5,6,7,8,9,10,11,12};
   private final Integer[] hour={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
   private final Integer[] minute={0,15,30,45};
   private static final GregorianCalendar today=new GregorianCalendar();
   private static final Integer[] year={today.get(today.YEAR),today.get(today.YEAR)+1,today.get(today.YEAR)+2};
   private final String[] locations={"Horsens","Viborg","Aalborg","Aarhus","Copenhagen"};
   
   private JButton changeButton;
   private JButton searchButton;
   private MyListener listener;
   private RentalListAdaptor rentalAdaptor;
   
   public editRentalPanel(RentalListAdaptor rentalAdapter)
   {
      listener=new MyListener();
      this.rentalAdaptor=rentalAdapter;
      
      searchPanelName=new JPanel();
      searchPanelName.setSize(990, 50);
      searchPanelName.setBorder(BorderFactory.createTitledBorder("Name searched"));
      searchFirstNameLabel=new JLabel("First Name");
      searchFirstNameText=new JTextField(20);
      searchFirstNameText.addActionListener(listener);
      searchLastNameLabel=new JLabel("Last Name");
      searchLastNameText=new JTextField(20);
      searchLastNameText.addActionListener(listener);
      searchPanelName.add(searchFirstNameLabel);
      searchPanelName.add(searchFirstNameText);
      searchPanelName.add(searchLastNameLabel);
      searchPanelName.add(searchLastNameText);
      add(searchPanelName);
      
      searchPanelPickUpDate=new JPanel();
      searchPanelPickUpDate.setSize(990,50);
      searchPanelPickUpDate.setBorder(BorderFactory.createTitledBorder("The searched pick-up date"));
      searchPickDayLabel=new JLabel("Day");
      searchPickDayText=new JComboBox(day);
      searchPickDayText.addActionListener(listener);
      searchPickMonthLabel=new JLabel("Month");
      searchPickMonthText=new JComboBox(month);
      searchPickMonthText.addActionListener(listener);
      searchPickYearLabel=new JLabel("Year");
      searchPickYearText=new JComboBox(year);
      searchPickYearText.addActionListener(listener);
      searchPickHourLabel=new JLabel("Hour");
      searchPickHourText=new JComboBox(hour);
      searchPickHourText.addActionListener(listener);
      searchPickMinuteLabel=new JLabel("Minute");
      searchPickMinuteText=new JComboBox(minute);
      searchPickMinuteText.addActionListener(listener);
      searchButton=new JButton("Search");
      searchButton.addActionListener(listener);
      searchPanelPickUpDate.add(searchPickDayLabel);
      searchPanelPickUpDate.add(searchPickDayText);
      searchPanelPickUpDate.add(searchPickMonthLabel);
      searchPanelPickUpDate.add(searchPickMonthText);
      searchPanelPickUpDate.add(searchPickYearLabel);
      searchPanelPickUpDate.add(searchPickYearText);
      searchPanelPickUpDate.add(searchPickHourLabel);
      searchPanelPickUpDate.add(searchPickHourText);
      searchPanelPickUpDate.add(searchPickMinuteLabel);
      searchPanelPickUpDate.add(searchPickMinuteText);
      searchPanelPickUpDate.add(searchButton);
      add(searchPanelPickUpDate);
      
      reservationPanel=new JPanel();
      reservationPanel.setSize(990, 20);
      reservationPanel.setBorder(BorderFactory.createTitledBorder("Found Reservation"));
      reservationLabel=new JLabel("Reservation");
      reservationText=new JTextField(80);
      reservationPanel.add(reservationLabel);
      reservationPanel.add(reservationText);
      add(reservationPanel);
      
      newNamePanel=new JPanel();
      newNamePanel.setSize(990,20);
      newNamePanel.setBorder(BorderFactory.createTitledBorder("New Customer Name"));
      foundFirstNameLabel=new JLabel("First Name");
      foundFirstNameText=new JTextField(20);
      foundFirstNameText.addActionListener(listener);
      foundLastNameLabel=new JLabel("Last Name");
      foundLastNameText=new JTextField(20);
      foundLastNameText.addActionListener(listener);
      newNamePanel.add(foundFirstNameLabel);
      newNamePanel.add(foundFirstNameText);
      newNamePanel.add(foundLastNameLabel);
      newNamePanel.add(foundLastNameText);
      add(newNamePanel);
      
      newInfoPanel=new JPanel();
      newInfoPanel.setSize(900,20);
      newInfoPanel.setBorder(BorderFactory.createTitledBorder("New Customer Info"));
      foundPhoneNumberLabel=new JLabel("Phone number");
      foundPhoneNumberText=new JTextField(20);
      foundPhoneNumberText.addActionListener(listener);
      foundLicenseNumberLabel=new JLabel("License number");
      foundLicenseNumberText=new JTextField(20);
      foundLicenseNumberText.addActionListener(listener);
      newInfoPanel.add(foundPhoneNumberLabel);
      newInfoPanel.add(foundPhoneNumberText);
      newInfoPanel.add(foundLicenseNumberLabel);
      newInfoPanel.add(foundLicenseNumberText);
      add(newInfoPanel);
      
      newDatePanel=new JPanel();
      newDatePanel.setSize(990, 50);
      newDatePanel.setBorder(BorderFactory.createTitledBorder("New Rental Period"));
      
      newPickUpDatePanel=new JPanel();
      newPickUpDatePanel.setSize(990,50);
      newPickUpDatePanel.setBorder(BorderFactory.createTitledBorder("New Pick-up Date"));
      pickDayLabel=new JLabel("Day");
      pickDayChoise=new JComboBox(day);
      pickDayChoise.addActionListener(listener);
      pickMonthLabel=new JLabel("Month");
      pickMonthChoise=new JComboBox(month);
      pickMonthChoise.addActionListener(listener);
      pickYearLabel=new JLabel("Year");
      pickYearChoise=new JComboBox(year);
      pickYearChoise.addActionListener(listener);
      pickHourLabel=new JLabel("Hour");
      pickHourChoise=new JComboBox(hour);
      pickHourChoise.addActionListener(listener);
      pickMinuteLabel=new JLabel("Minute");
      pickMinuteChoise=new JComboBox(minute);
      pickMinuteChoise.addActionListener(listener);
      newPickUpDatePanel.add(pickDayLabel);
      newPickUpDatePanel.add(pickDayChoise);
      newPickUpDatePanel.add(pickMonthLabel);
      newPickUpDatePanel.add(pickMonthChoise);
      newPickUpDatePanel.add(pickYearLabel);
      newPickUpDatePanel.add(pickYearChoise);
      newPickUpDatePanel.add(pickHourLabel);
      newPickUpDatePanel.add(pickHourChoise);
      newPickUpDatePanel.add(pickMinuteLabel);
      newPickUpDatePanel.add(pickMinuteChoise);
      newDatePanel.add(newPickUpDatePanel);
      
      newDeliveryDatePanel=new JPanel();
      newDeliveryDatePanel.setSize(990,50);
      newDeliveryDatePanel.setBorder(BorderFactory.createTitledBorder("New Return Date"));
      deliveryDayLabel=new JLabel("Day");
      deliveryDayChoise=new JComboBox(day);
      deliveryDayChoise.addActionListener(listener);
      deliveryMonthLabel=new JLabel("Month");
      deliveryMonthChoise=new JComboBox(month);
      deliveryMonthChoise.addActionListener(listener);
      deliveryYearLabel=new JLabel("Year");
      deliveryYearChoise=new JComboBox(year);
      deliveryYearChoise.addActionListener(listener);
      deliveryHourLabel=new JLabel("Hour");
      deliveryHourChoise=new JComboBox(hour);
      deliveryHourChoise.addActionListener(listener);
      deliveryMinuteLabel=new JLabel("Minute");
      deliveryMinuteChoise=new JComboBox(minute);
      deliveryMinuteChoise.addActionListener(listener);
      newDeliveryDatePanel.add(deliveryDayLabel);
      newDeliveryDatePanel.add(deliveryDayChoise);
      newDeliveryDatePanel.add(deliveryMonthLabel);
      newDeliveryDatePanel.add(deliveryMonthChoise);
      newDeliveryDatePanel.add(deliveryYearLabel);
      newDeliveryDatePanel.add(deliveryYearChoise);
      newDeliveryDatePanel.add(deliveryHourLabel);
      newDeliveryDatePanel.add(deliveryHourChoise);
      newDeliveryDatePanel.add(deliveryMinuteLabel);
      newDeliveryDatePanel.add(deliveryMinuteChoise);
      newDatePanel.add(newDeliveryDatePanel);
      add(newDatePanel);
      
      newLocationPanel=new JPanel();
      newLocationPanel.setSize(900, 20);
      newLocationPanel.setBorder(BorderFactory.createTitledBorder("New Location"));
      choosePickUpLOcationLabel=new JLabel("Pick-Up Location");
      newPickUpLocation=new JComboBox(locations);
      newPickUpLocation.addActionListener(listener);
      chooseDeliveryLocation=new JLabel("Delivery Location");
      newDeliveryLocation=new JComboBox(locations);
      newDeliveryLocation.addActionListener(listener);
      newLocationPanel.add(choosePickUpLOcationLabel);
      newLocationPanel.add(newPickUpLocation);
      newLocationPanel.add(chooseDeliveryLocation);
      newLocationPanel.add(newDeliveryLocation);
      add(newLocationPanel);
      
      buttonPanel=new JPanel();
      buttonPanel.setSize(990,20);
      changeButton=new JButton("Done");
      changeButton.addActionListener(listener);
      buttonPanel.add(changeButton);
      add(buttonPanel);
   }
   private class MyListener implements ActionListener
   {
      RentalList rentals;
      Rental temporaryRental=null;
      Vehicle temporaryVehicle=null;
      public void actionPerformed(ActionEvent e)
      {
         rentals=rentalAdaptor.getAllRentals();
         if(e.getSource()==searchButton)
         {
            int day=(int)searchPickDayText.getSelectedItem();
            int month=(int)searchPickMonthText.getSelectedItem();
            int year=(int)searchPickYearText.getSelectedItem();
            int hour=(int)searchPickHourText.getSelectedItem();
            int minute=(int)searchPickMinuteText.getSelectedItem();
            Date temporaryDate=new Date(day, month, year, hour, minute); 
            temporaryRental=rentals.getRentalByNameAndPickUpDate(searchFirstNameText.getText(),searchLastNameText.getText(), temporaryDate);
            if(temporaryRental!=null)
            {
               reservationText.setText(temporaryRental.toString());
               foundFirstNameText.setText(temporaryRental.getCustomer().getFirstName());
               foundLastNameText.setText(temporaryRental.getCustomer().getLastName());
               foundPhoneNumberText.setText(temporaryRental.getCustomer().getPhoneNumber());
               temporaryVehicle=temporaryRental.getVehicle();
               if(temporaryRental.getCustomer().getLicenseNo()!=null)
               {
                  foundLicenseNumberText.setText(temporaryRental.getCustomer().getLicenseNo());
               }
               pickDayChoise.setSelectedIndex(temporaryRental.getPickUpTime().getDay()-1);
               deliveryDayChoise.setSelectedIndex(temporaryRental.getReturnTime().getDay()-1);
               pickMonthChoise.setSelectedIndex(temporaryRental.getPickUpTime().getMonth()-1);
               deliveryMonthChoise.setSelectedIndex(temporaryRental.getReturnTime().getMonth()-1);
               GregorianCalendar today=new GregorianCalendar();
               if(temporaryRental.getPickUpTime().getYear()==today.get(GregorianCalendar.YEAR))
               {
                  pickYearChoise.setSelectedIndex(0);
               }
               if(temporaryRental.getPickUpTime().getYear()==today.get(GregorianCalendar.YEAR)+1)
               {
                  pickYearChoise.setSelectedIndex(1);
               }
               if(temporaryRental.getPickUpTime().getYear()==today.get(GregorianCalendar.YEAR)+2)
               {
                  pickYearChoise.setSelectedIndex(2);
               }
               if(temporaryRental.getPickUpTime().getYear()==today.get(GregorianCalendar.YEAR))
               {
                  deliveryYearChoise.setSelectedIndex(0);
               }
               if(temporaryRental.getPickUpTime().getYear()==today.get(GregorianCalendar.YEAR)+1)
               {
                  deliveryYearChoise.setSelectedIndex(1);
               }
               if(temporaryRental.getPickUpTime().getYear()==today.get(GregorianCalendar.YEAR)+2)
               {
                  deliveryYearChoise.setSelectedIndex(2);
               }
               pickHourChoise.setSelectedIndex(temporaryRental.getPickUpTime().getHour());
               deliveryHourChoise.setSelectedIndex(temporaryRental.getReturnTime().getHour());
               if(temporaryRental.getPickUpTime().getMinute()==0) 
                  {
                     pickMinuteChoise.setSelectedIndex(0);
                  }
               if(temporaryRental.getPickUpTime().getMinute()==15) 
               {
                  pickMinuteChoise.setSelectedIndex(1);
               }
               if(temporaryRental.getPickUpTime().getMinute()==30) 
               {
                  pickMinuteChoise.setSelectedIndex(2);
               }
               if(temporaryRental.getPickUpTime().getMinute()==45) 
               {
                  pickMinuteChoise.setSelectedIndex(3);
               }
               if(temporaryRental.getReturnTime().getMinute()==0) 
               {
                  deliveryMinuteChoise.setSelectedIndex(0);
               }
               if(temporaryRental.getReturnTime().getMinute()==15) 
               {
                  deliveryMinuteChoise.setSelectedIndex(1);
               }
               if(temporaryRental.getReturnTime().getMinute()==30) 
               {
                  deliveryMinuteChoise.setSelectedIndex(2);
               }
               if(temporaryRental.getReturnTime().getMinute()==45) 
               {
                  deliveryMinuteChoise.setSelectedIndex(3);
               }
               if(temporaryRental.getPickUPLocation().equals("Horsens"))
               {
                  newPickUpLocation.setSelectedIndex(0);
               }
               if(temporaryRental.getPickUPLocation().equals("Viborg"))
               {
                  newPickUpLocation.setSelectedIndex(1);
               }
               if(temporaryRental.getPickUPLocation().equals("Aalborg"))
               {
                  newPickUpLocation.setSelectedIndex(2);
               }
               if(temporaryRental.getPickUPLocation().equals("Aarhus"))
                  {
                  newPickUpLocation.setSelectedIndex(3);
                  }
               if(temporaryRental.getPickUPLocation().equals("Copenhagen"))
               {
                  newPickUpLocation.setSelectedIndex(4);
               }
               if(temporaryRental.getReturnLocation().equals("Horsens"))
               {
                  newDeliveryLocation.setSelectedIndex(0);
               }
               if(temporaryRental.getReturnLocation().equals("Viborg"))
               {
                  newDeliveryLocation.setSelectedIndex(1);
               }
               if(temporaryRental.getReturnLocation().equals("Aalborg"))
               {
                  newDeliveryLocation.setSelectedIndex(2);
               }
               if(temporaryRental.getReturnLocation().equals("Aarhus"))
                  {
                  newDeliveryLocation.setSelectedIndex(3);
                  }
               if(temporaryRental.getReturnLocation().equals("Copenhagen"))
               {
                  newDeliveryLocation.setSelectedIndex(4);
               }
               
            }
            else
            {
               JOptionPane.showMessageDialog(null,"There is no rental in the system with the introduced data");
            }
         }
         if(e.getSource()==changeButton)
         {
            String firstName=foundFirstNameText.getText();
            String lastName=foundLastNameText.getText();
            String phoneNumber=foundPhoneNumberText.getText();
            String licenseNumber=foundLicenseNumberText.getText();
            Customer temporaryCustomer=new Customer(firstName, lastName, phoneNumber,licenseNumber);
            int pickday=(int)pickDayChoise.getSelectedItem();
            int pickmonth=(int)pickMonthChoise.getSelectedItem();
            int pickyear=(int)pickYearChoise.getSelectedItem();
            int pickhour=(int)pickHourChoise.getSelectedItem();
            int pickminute=(int)pickMinuteChoise.getSelectedItem();
            int deliveryday=(int)deliveryDayChoise.getSelectedItem();
            int deliverymonth=(int)deliveryMonthChoise.getSelectedItem();
            int deliveryyear=(int)deliveryYearChoise.getSelectedItem();
            int deliveryhour=(int)deliveryHourChoise.getSelectedItem();
            int deliveryminute=(int)deliveryMinuteChoise.getSelectedItem();
            String pickuplocation=(String)newPickUpLocation.getSelectedItem();
            String deliverylocation=(String)newDeliveryLocation.getSelectedItem();
            Date pickUpDate=new Date(pickday, pickmonth, pickyear, pickhour, pickminute);
            Date deliveryDate=new Date(deliveryday, deliverymonth, deliveryyear, deliveryhour, deliveryminute);
            rentals.deleteRental(temporaryRental);
            rentalAdaptor.deleteRental(temporaryRental);
            Rental newRental=new Rental(temporaryVehicle, temporaryCustomer, pickUpDate, deliveryDate, pickuplocation, deliverylocation);
            if(rentals.checkRentalAvailability(newRental))
            {
               rentalAdaptor.addRental(newRental);
               JOptionPane.showMessageDialog(null,"The rental has been modified");
            }
            else
            {
               JOptionPane.showMessageDialog(null,"The vehicle is not available for the selected period, rental cancelled");
            }
            
            searchFirstNameText.setText("");
            searchLastNameText.setText("");
            searchPickDayText.setSelectedIndex(0);
            searchPickMonthText.setSelectedIndex(0);
            searchPickYearText.setSelectedIndex(0);
            searchPickHourText.setSelectedIndex(0);
            searchPickMinuteText.setSelectedIndex(0);
            foundFirstNameText.setText("");
            foundLastNameText.setText("");
            foundPhoneNumberText.setText("");
            foundLicenseNumberText.setText("");
            reservationText.setText("");
            pickDayChoise.setSelectedIndex(0);
            pickMonthChoise.setSelectedIndex(0);
            pickYearChoise.setSelectedIndex(0);
            pickHourChoise.setSelectedIndex(0);
            pickMinuteChoise.setSelectedIndex(0);
            deliveryDayChoise.setSelectedIndex(0);
            deliveryMonthChoise.setSelectedIndex(0);
            deliveryYearChoise.setSelectedIndex(0);
            deliveryHourChoise.setSelectedIndex(0);
            deliveryMinuteChoise.setSelectedIndex(0);
            newPickUpLocation.setSelectedIndex(0);
            newDeliveryLocation.setSelectedIndex(0);
         }
      }
   }
}
