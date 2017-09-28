

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
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
 * a class used to create a panel for changing the rental price of a vehicle
 * 
 * @author mihai cristian pavel
 * @version 1.0
 */
public class newPricePanel extends JPanel
{
   private JLabel newPriceLabel;

   private JTextField newPriceText;

   private JList<Vehicle> vehiclesList;
   private JScrollPane pane;

   private JComboBox vehicleTypeChoise;
   private final String[] vehicleChoise = { "All", "Family Car", "Van",
         "Moving Truck", "Auto Camper" };

   private JButton changePrice;

   private JPanel vehicleTypePanel;
   private JPanel newPrice;
   private JPanel changeButtonPanel;

   private VehicleAdapter vehicleAdaptor;
   private MyListener listener;
   private ListListener listListener;
   private Vehicle temp;

   /**
    * a one-argument constructor for the new peice panel
    * 
    * @param vehicleAdaptor
    *           the vehicle adaptor
    */
   public newPricePanel(VehicleAdapter vehicleAdaptor)
   {
      temp = null;
      this.vehicleAdaptor = vehicleAdaptor;
      listener = new MyListener();
      listListener = new ListListener();

      vehicleTypePanel = new JPanel();
      vehicleTypePanel.setSize(990, 20);
      vehicleTypePanel.setBorder(BorderFactory
            .createTitledBorder("Vehicle Type Selection"));
      vehicleTypeChoise = new JComboBox(vehicleChoise);
      vehicleTypeChoise.addActionListener(listener);
      vehicleTypePanel.add(vehicleTypeChoise);
      add(vehicleTypePanel);

      vehiclesList = new JList<Vehicle>();
      vehiclesList.addListSelectionListener(listListener);
      pane = new JScrollPane(vehiclesList);
      pane.setSize(990, 400);
      pane.setBorder(BorderFactory.createTitledBorder("Vehicle List"));
      add(pane);

      newPrice = new JPanel();
      newPrice.setSize(990, 20);
      newPrice.setBorder(BorderFactory
            .createTitledBorder("New Price For Rental"));
      newPriceLabel = new JLabel("New Price");
      newPriceText = new JTextField(10);
      newPriceText.addActionListener(listener);
      newPrice.add(newPriceLabel);
      newPrice.add(newPriceText);
      add(newPrice);

      changeButtonPanel = new JPanel();
      changeButtonPanel.setSize(990, 20);
      changePrice = new JButton("Change Price");
      changePrice.addActionListener(listener);
      changeButtonPanel.add(changePrice);
      add(changeButtonPanel);
   }

   /**
    * a class for the action listeners from the new price panel
    * 
    * @author mihai cristian pavel
    * @version 1.0
    */
   private class MyListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         Vehicle[] familyCars = vehicleAdaptor.getFamilyCars();
         Vehicle[] vans = vehicleAdaptor.getVans();
         Vehicle[] trucks = vehicleAdaptor.getMovingTrucks();
         Vehicle[] autoCamper = vehicleAdaptor.getAutoCamper();
         VehicleList all = vehicleAdaptor.getAllVehicles();
         Vehicle[] allVehicles = new Vehicle[all.size()];
         
         DefaultListModel<Vehicle> lm = new DefaultListModel<Vehicle>();
         
         lm.clear();
                  
         for (int i = 0; i < all.size(); i++)
         {
            allVehicles[i] = all.getVehicleByIndex(i);
         }
         if (e.getSource() == vehicleTypeChoise)
         {
            if (vehicleTypeChoise.getSelectedIndex() == 0)
            {
               for(int j = 0; j < allVehicles.length; j++)
               {
                  lm.addElement(allVehicles[j]);
               }
               vehiclesList.setModel(lm);
            }
            if (vehicleTypeChoise.getSelectedIndex() == 1)
            {
               for(int j = 0; j < familyCars.length; j++)
               {
                  lm.addElement(familyCars[j]);
               }
               vehiclesList.setModel(lm);
            }
            if (vehicleTypeChoise.getSelectedIndex() == 2)
            {
               for(int j = 0; j < vans.length; j++)
               {
                  lm.addElement(vans[j]);
               }
               vehiclesList.setModel(lm);
            }
            if (vehicleTypeChoise.getSelectedIndex() == 3)
            {
               for(int j = 0; j < trucks.length; j++)
               {
                  lm.addElement(trucks[j]);
               }
               vehiclesList.setModel(lm);
            }
            if (vehicleTypeChoise.getSelectedIndex() == 4)
            {
               for(int j = 0; j < autoCamper.length; j++)
               {
                  lm.addElement(autoCamper[j]);
               }
               vehiclesList.setModel(lm);
            }
         }
         if (e.getSource() == changePrice)
         {
            if (temp != null)
            {
               try
               {
                  vehicleAdaptor.changePriceOfVehicle(temp,
                        (Double.parseDouble(newPriceText.getText())));
                  Vehicle[] familyCars1 = vehicleAdaptor.getFamilyCars();
                  Vehicle[] vans1 = vehicleAdaptor.getVans();
                  Vehicle[] trucks1 = vehicleAdaptor.getMovingTrucks();
                  Vehicle[] autoCamper1 = vehicleAdaptor.getAutoCamper();
                 
                  VehicleList all1 = vehicleAdaptor.getAllVehicles();
                  Vehicle[] allVehicles1 = new Vehicle[all.size()];
                  DefaultListModel<Vehicle> lm1 = new DefaultListModel<Vehicle>();
                  
                  lm1.clear();
                           
                  for (int i = 0; i < all1.size(); i++)
                  {
                     allVehicles1[i] = all1.getVehicleByIndex(i);
                  }
                 
                     if (vehicleTypeChoise.getSelectedIndex() == 0)
                     {
                        for(int j = 0; j < allVehicles1.length; j++)
                        {
                           lm1.addElement(allVehicles1[j]);
                        }
                        vehiclesList.setModel(lm1);
                     }
                     if (vehicleTypeChoise.getSelectedIndex() == 1)
                     {
                        for(int j = 0; j < familyCars1.length; j++)
                        {
                           lm1.addElement(familyCars1[j]);
                        }
                        vehiclesList.setModel(lm1);
                     }
                     if (vehicleTypeChoise.getSelectedIndex() == 2)
                     {
                        for(int j = 0; j < vans1.length; j++)
                        {
                           lm1.addElement(vans1[j]);
                        }
                        vehiclesList.setModel(lm1);
                     }
                     if (vehicleTypeChoise.getSelectedIndex() == 3)
                     {
                        for(int j = 0; j < trucks1.length; j++)
                        {
                           lm1.addElement(trucks1[j]);
                        }
                        vehiclesList.setModel(lm1);
                     }
                     if (vehicleTypeChoise.getSelectedIndex() == 4)
                     {
                        for(int j = 0; j < autoCamper1.length; j++)
                        {
                           lm1.addElement(autoCamper1[j]);
                           
                        }
                        vehiclesList.setModel(lm1);
                     }
                } 
               catch (NumberFormatException i)
               {
                  JOptionPane.showMessageDialog(null,
                        "Input Numbers, Not Words");
               }

               newPriceText.setText("");
               vehiclesList.setSelectedIndex(0);
               JOptionPane.showMessageDialog(null,
                     "The selected vehicles price has been changed");
            }
            else
            {
               try
               {
                  if (vehicleTypeChoise.getSelectedIndex() == 0)
                  {

                     for (int i = 0; i < all.size(); i++)
                     {
                        vehicleAdaptor.changePriceOfVehicle(
                              all.getVehicleByIndex(i),
                              (Double.parseDouble(newPriceText.getText())));
                     }
                     JOptionPane.showMessageDialog(null,
                           "The price was changed for all vehicles");
                  }
                  if (vehicleTypeChoise.getSelectedIndex() == 1)
                  {
                     for (int i = 0; i < familyCars.length; i++)
                     {
                        vehicleAdaptor.changePriceOfVehicle(familyCars[i],
                              (Double.parseDouble(newPriceText.getText())));
                     }
                     JOptionPane.showMessageDialog(null,
                           "The price was changed for all family cars");
                  }
                  if (vehicleTypeChoise.getSelectedIndex() == 2)
                  {
                     for (int i = 0; i < vans.length; i++)
                     {
                        vehicleAdaptor.changePriceOfVehicle(vans[i],
                              (Double.parseDouble(newPriceText.getText())));
                     }
                     JOptionPane.showMessageDialog(null,
                           "The price was changed for all vans");
                  }
                  if (vehicleTypeChoise.getSelectedIndex() == 3)
                  {
                     for (int i = 0; i < trucks.length; i++)
                     {
                        vehicleAdaptor.changePriceOfVehicle(trucks[i],
                              (Double.parseDouble(newPriceText.getText())));
                     }
                     JOptionPane.showMessageDialog(null,
                           "The price was changed for all moving trucks");
                  }

                  if (vehicleTypeChoise.getSelectedIndex() == 4)
                  {
                     for (int i = 0; i < autoCamper.length; i++)
                     {
                        vehicleAdaptor.changePriceOfVehicle(autoCamper[i],
                              (Double.parseDouble(newPriceText.getText())));
                     }
                     JOptionPane.showMessageDialog(null,
                           "The price was changed for all auto campers");
                  }
                  
                  
                  Vehicle[] familyCars1 = vehicleAdaptor.getFamilyCars();
                  Vehicle[] vans1 = vehicleAdaptor.getVans();
                  Vehicle[] trucks1 = vehicleAdaptor.getMovingTrucks();
                  Vehicle[] autoCamper1 = vehicleAdaptor.getAutoCamper();
                 
                  VehicleList all1 = vehicleAdaptor.getAllVehicles();
                  Vehicle[] allVehicles1 = new Vehicle[all.size()];
                  DefaultListModel<Vehicle> lm1 = new DefaultListModel<Vehicle>();
                  
                  lm1.clear();
                           
                  for (int i = 0; i < all1.size(); i++)
                  {
                     allVehicles1[i] = all1.getVehicleByIndex(i);
                  }
                 
                     if (vehicleTypeChoise.getSelectedIndex() == 0)
                     {
                        for(int j = 0; j < allVehicles1.length; j++)
                        {
                           lm1.addElement(allVehicles1[j]);
                        }
                        vehiclesList.setModel(lm1);
                     }
                     if (vehicleTypeChoise.getSelectedIndex() == 1)
                     {
                        for(int j = 0; j < familyCars1.length; j++)
                        {
                           lm1.addElement(familyCars1[j]);
                        }
                        vehiclesList.setModel(lm1);
                     }
                     if (vehicleTypeChoise.getSelectedIndex() == 2)
                     {
                        for(int j = 0; j < vans1.length; j++)
                        {
                           lm1.addElement(vans1[j]);
                        }
                        vehiclesList.setModel(lm1);
                     }
                     if (vehicleTypeChoise.getSelectedIndex() == 3)
                     {
                        for(int j = 0; j < trucks1.length; j++)
                        {
                           lm1.addElement(trucks1[j]);
                        }
                        vehiclesList.setModel(lm1);
                     }
                     if (vehicleTypeChoise.getSelectedIndex() == 4)
                     {
                        for(int j = 0; j < autoCamper1.length; j++)
                        {
                           lm1.addElement(autoCamper1[j]);
                           
                        }
                        vehiclesList.setModel(lm1);
                     }
                  
                  
                  
               }
               catch (NumberFormatException j)
               {
                  JOptionPane.showMessageDialog(null,
                        "Input Numbers, Not Words");
               }
            }
         }
      }
   }

   /**
    * a class for the listListeners from the new price panel
    * 
    * @author mihai cristian pavel
    * @version 1.0
    */
   private class ListListener implements ListSelectionListener
   {
      public void valueChanged(ListSelectionEvent e)
      {
         if (e.getSource() == vehiclesList)
         {
            temp = vehiclesList.getSelectedValue();
         }
      }
   }
}
