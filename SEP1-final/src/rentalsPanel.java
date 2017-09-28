

import java.awt.GridLayout;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Class made allowing user to see both current rentals and the history of rentals
 * @author Mihai Cristian Pavel
 * Version 1.0
 */
public class rentalsPanel extends JPanel
{
   private JTabbedPane tab;
   
   private JPanel historyPanel;
   private JPanel currentPanel;
   private JPanel reservationsPanel;
   
   private JTextArea historyRentalsArea;
   private JTextArea currentRentalsArea;
   private JTextArea reservationsArea;
   
   private JScrollPane historyScrollPane;
   private JScrollPane currentScrollPane;
   private JScrollPane reservationsScrollPane;
   
   private MyTabListener listener;
   
   private RentalListAdaptor rentalsAdaptor;
   
   RentalList allRentalsList;
   
   /**
    * a one-argument constructor for the Rentals panel
    * @param rentalsAdaptor the rental adapter received from the main
    */
   public rentalsPanel(RentalListAdaptor rentalsAdaptor)
   {
      listener=new MyTabListener();
      
      this.rentalsAdaptor=rentalsAdaptor;
      
      allRentalsList=rentalsAdaptor.getAllRentals();
      
      tab=new JTabbedPane();
      tab.addChangeListener(listener);
      
      historyPanel=new JPanel();
      currentPanel=new JPanel();
      reservationsPanel = new JPanel();
      historyRentalsArea=new JTextArea(45,75);
      currentRentalsArea=new JTextArea(45,75);
      reservationsArea = new JTextArea(45,75);
      historyScrollPane = new JScrollPane(historyRentalsArea);
      currentScrollPane = new JScrollPane(currentRentalsArea);
      reservationsScrollPane = new JScrollPane(reservationsArea);
      historyScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      currentScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      reservationsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      historyRentalsArea.setEditable(false);
      currentRentalsArea.setEditable(false);
      reservationsArea.setEditable(false);
      historyPanel.add(historyScrollPane);
      currentPanel.add(currentScrollPane);
      reservationsPanel.add(reservationsScrollPane);
      tab.addTab("Reservations",reservationsPanel);
      tab.addTab("Current Rentals",currentPanel);
      tab.addTab("History of Rentals", historyPanel);
      add(tab);
   }
   
   /**
    * Class made for creating all actionlisteners in only one class so we just call that
    * @author Mihai Cristian Pavel
    * Version 1.0
    */
   private class MyTabListener implements ChangeListener
   {
      public void stateChanged(ChangeEvent e)
      {
         if(((JTabbedPane)e.getSource()).getSelectedIndex()==0)
         {
            RentalList temp=getRentalsOldOrNew(1);
            reservationsArea.setText(temp.toString());
         }
 
         if(((JTabbedPane)e.getSource()).getSelectedIndex()==1)
         {
            RentalList temp=getRentalsOldOrNew(2);
            currentRentalsArea.setText(temp.toString());
         }
         
         if(((JTabbedPane)e.getSource()).getSelectedIndex()==2)
         {
            RentalList temp=getRentalsOldOrNew(3);
            historyRentalsArea.setText(temp.toString());
         } 
      }
   }
   public RentalList getRentalsOldOrNew(int choise)
   {
      RentalList old=new RentalList();
      RentalList current=new RentalList();
      allRentalsList=rentalsAdaptor.getAllRentals();
      RentalList reservations = new RentalList();
      
      for(int i=0;i<allRentalsList.size();i++)
      {
         if(allRentalsList.getRentalAtIndex(i).getCustomer().getLicenseNo().length() == 0)
         {
            reservations.addRental(allRentalsList.getRentalAtIndex(i));
         }
         else 
         {
            if(allRentalsList.getRentalAtIndex(i).getReturnTime().isBefore(new Date()))
            {
               old.addRental(allRentalsList.getRentalAtIndex(i));
            }
            else 
            {
               current.addRental(allRentalsList.getRentalAtIndex(i));
            }
         }
      }
      if(choise == 1) return reservations;
      else
         {
         if(choise==2) return current;
         else  return old;
         }
      
   }
}
