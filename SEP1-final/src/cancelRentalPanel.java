

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
 * Class made that allows the user to cancel an existing rental
 * @author Mihai Cristian Pavel
 * Version 1.0
 */
public class cancelRentalPanel extends JPanel
{
   private JPanel namePanel;
   private JPanel pickUpDatePanel;
   private JPanel cancelPanel;
   
   private JLabel firstNameLabel;
   private JLabel lastNameLabel;
   private JLabel dayLabel;
   private JLabel monthLabel;
   private JLabel yearLabel;
   private JLabel hourLabel;
   private JLabel minuteLabel;
   
   private JTextField firstNameText;
   private JTextField lastNameText;
   
   private final Integer[] day={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
   private final Integer[] month={1,2,3,4,5,6,7,8,9,10,11,12};
   private final Integer[] hour={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
   private final Integer[] minute={0,15,30,45};
   private static final GregorianCalendar today=new GregorianCalendar();
   private static final Integer[] year={today.get(today.YEAR),today.get(today.YEAR)+1,today.get(today.YEAR)+2};
   
   private JComboBox pickUpDayInput;
   private JComboBox pickUpMonthInput;
   private JComboBox pickUpYearInput;
   private JComboBox pickUpHourInput;
   private JComboBox pickUpMinuteInput;
   
   private JButton cancelButton;
   
   private RentalListAdaptor rentalAdapter;
   
   private MyListener listener;
   
   
   private int Day,Month,Year,Hour,Minute;
   private String firstName;
   private String lastName;
   
   private static Date data;
   private RentalList rentals;
   
   /**
    * 1-arg constructor using the Rental List Adapter class
    * @param rentalAdapter
    * Version 1.0
    */
   public cancelRentalPanel(RentalListAdaptor rentalAdapter)
   {
      listener=new MyListener();
      this.rentalAdapter=rentalAdapter;
      Day=-1;Month=-1;Year=-1;Hour=-1;Minute=-1;
      data=null;
      rentals=rentalAdapter.getAllRentals();
      
      namePanel=new JPanel();
      namePanel.setSize(990,50);
      namePanel.setBorder(BorderFactory.createTitledBorder("Customer Name"));
      firstNameLabel=new JLabel("First Name");
      firstNameText=new JTextField(20);
      firstNameText.addActionListener(listener);
      lastNameLabel=new JLabel("Last Name");
      lastNameText=new JTextField(20);
      lastNameText.addActionListener(listener);
      namePanel.add(firstNameLabel);
      namePanel.add(firstNameText);
      namePanel.add(lastNameLabel);
      namePanel.add(lastNameText);
      add(namePanel);
      
      pickUpDatePanel=new JPanel();
      pickUpDatePanel.setSize(990,200);
      pickUpDatePanel=new JPanel();
      pickUpDatePanel.setBorder(BorderFactory.createTitledBorder("Pick-Up Date"));
      pickUpDatePanel.setSize(490,190);
      dayLabel=new JLabel("Day");
      pickUpDayInput=new JComboBox(day);
      pickUpDayInput.addActionListener(listener);
      monthLabel=new JLabel("Month");
      pickUpMonthInput=new JComboBox(month);
      pickUpMonthInput.addActionListener(listener);
      yearLabel=new JLabel("Year");
      pickUpYearInput=new JComboBox(year);
      pickUpYearInput.addActionListener(listener);
      hourLabel= new JLabel("hour");
      pickUpHourInput=new JComboBox(hour);
      pickUpHourInput.addActionListener(listener);
      minuteLabel=new JLabel("Minute");
      pickUpMinuteInput=new JComboBox(minute);
      pickUpMinuteInput.addActionListener(listener);
      pickUpDatePanel.add(dayLabel);
      pickUpDatePanel.add(pickUpDayInput);
      pickUpDatePanel.add(monthLabel);
      pickUpDatePanel.add(pickUpMonthInput);
      pickUpDatePanel.add(yearLabel);
      pickUpDatePanel.add(pickUpYearInput);
      pickUpDatePanel.add(hourLabel);
      pickUpDatePanel.add(pickUpHourInput);
      pickUpDatePanel.add(minuteLabel);
      pickUpDatePanel.add(pickUpMinuteInput);
      add(pickUpDatePanel);
      
      cancelPanel=new JPanel();
      cancelPanel.setSize(990, 200);
      cancelButton=new JButton("Cancel Rental");
      cancelButton.addActionListener(listener);
      cancelPanel.add(cancelButton);
      add(cancelPanel);
   }
   
   /**
    * Class made for creating all actionlisteners in only one class so we just call that
    * @author Mihai Cristian Pavel
    * Version 1.0
    */
   private class MyListener implements ActionListener
   {
      
      public void actionPerformed(ActionEvent e)
      {
        firstName=firstNameText.getText();
        lastName=lastNameText.getText();
         
         if(e.getSource()==pickUpDayInput)
         {
            Day=(int)pickUpDayInput.getSelectedItem();
         }
         if(e.getSource()==pickUpMonthInput)
         {
            Month=(int)pickUpMonthInput.getSelectedItem();
         }
         if(e.getSource()==pickUpYearInput)
         {
            Year=(int)pickUpYearInput.getSelectedItem();
         }
         if(e.getSource()==pickUpHourInput)
         {
            Hour=(int)pickUpHourInput.getSelectedItem();
         }
         if(e.getSource()==pickUpMinuteInput)
         {
            Minute=(int)pickUpMinuteInput.getSelectedItem();
         }
         if(Day!=-1 && Month!=-1 && Year!=-1 && Hour!=-1 && Minute!=-1)
         {
            data=new Date(Day, Month, Year, Hour, Minute);
         }
         if(e.getSource()==cancelButton)
         {
            rentalAdapter.deleteRentalByNameAndPickUpDate(firstName, lastName, data);
            JOptionPane.showMessageDialog(null,"the rental is deleted");
         }
      }
   }   
}
