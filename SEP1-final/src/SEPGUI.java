

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.GregorianCalendar;
/**
 * the main gui class
 * @author Palle Christensen
 * @version 1.0
 */
public class SEPGUI extends JFrame
{
   private VehicleAdapter vehicleAdapter;
   private RentalListAdaptor rentalAdapter;
   private CustomerAdaptor customerAdapter;

   // Panel with cardlayout
   private JPanel cards;
   private CardLayout cl;

   // All Panels
   private JPanel overAllPanel;
   private JPanel vehiclePanel;
   private JPanel servicePanel;
   private JPanel addVehiclePanel;
   private JPanel deleteVehiclePanel;
   private newPricePanel changePricePanel;

   private rentalsPanel rentPanel;
   private newRentalPanel newRental;
   private cancelRentalPanel cancelPanel;
   private editRentalPanel editPanel;
   

   // For vehicle menu
   private JPanel vehicle1Panel;

   // For add vehicle menu
   private JPanel firstPanel;
   private JPanel secondPanel;
   private JPanel thirdPanel;
   private JPanel fourthPanel;
   private JPanel fifthPanel;
   private JPanel sixthPanel;

   // For delete vehicle menu
   private JPanel delete1Panel;
   private JPanel delete2Panel;

   // For editing vehicle
   private JPanel editVehiclePanel;
   private JPanel buttonPanel;
   private JPanel editFieldPanel;
   private JPanel pricePanel;
   private JPanel button2Panel;

   private MyButtonListener buttonListener;

   // Scroll Pane for vehicleList
   private JScrollPane vehicleScrollPane;

   // Scroll pane for service list
   private JScrollPane serviceScrollPane;

   // Menu
   private JMenuBar menuBar;

   private JMenu rentalMenu;
   private JMenuItem newRentalMenuItem;
   private JMenuItem editRentalMenuItem;
   private JMenuItem deleteRentalMenuItem;
   private JMenuItem rentalsMenuItem;

   private JMenu vehicleMenu;
   private JMenuItem vehiclesMenuItem;
   private JMenuItem serviceMenuItem;
   private JMenuItem addVehicleMenuItem;
   private JMenuItem deleteVehicleMenuItem;
   private JMenuItem editVehicleMenuItem;
   private JMenuItem changePriceMenuItem;

   // All Buttons
   private JButton addButton;
   private JButton deleteButton;
   private JButton cancel1Button;
   private JButton cancel2Button;
   private JButton cancel3Button;
   private JButton home1Button;
   private JButton home2Button;
   private JButton updateButton;
   private JButton calculateButton;

   // Lists inside menus
   private JTextArea vehicleArea;
   private JTextArea serviceArea;

   // Drop down list for vehicle list
   private JComboBox<String> vehicleTypeBox;

   // Drop down lists for add vehicle menu
   private JComboBox<String> addTypeBox;
   private JComboBox<String> fuelTypeBox;
   private JComboBox<String> transmissionTypeBox;
   private JComboBox<String> capacityBox;
   private JComboBox<String> loadSizeBox;

   // List for delete vehicle menu
   private JLabel deleteByRegNoLabel;
   private JTextField deleteField;

   // ImageIcon and Label for logo
   private ImageIcon logoIcon;
   private JLabel logoLabel;

   // Labels for drop down list in vehicle menu
   private JLabel vehicleTypeLabel;

   // Labels for Text fields and drop down lists in add vehicle menu
   private JLabel addTypeLabel;
   private JLabel fuelTypeLabel;
   private JLabel transmissionTypeLabel;
   private JLabel capacityLabel;
   private JLabel loadSizeLabel;

   private JLabel modelFieldLabel;
   private JLabel makeFieldLabel;
   private JLabel yearFieldLabel;
   private JLabel colorFieldLabel;
   private JLabel regNoFieldLabel;
   private JLabel mileageFieldLabel;
   private JLabel locationFieldLabel;
   private JLabel priceFieldLabel;

   private JLabel editRegNoLabel;
   private JLabel newKMLabel;
   private JLabel kmLabel;
   private JLabel calcPriceLabel;

   // Text Fields for adding vehicle
   private JTextField modelField;
   private JTextField makeField;
   private JTextField yearField;
   private JTextField colorField;
   private JTextField regNoField;
   private JTextField mileageField;
   private JTextField locationField;
   private JTextField priceField;

   private JTextField editRegNoField;
   private JTextField newKMField;
   private JTextField kmField;
   private JTextField calcPriceField;

   public SEPGUI()
   {
      // What the program displays in top left corner
      super("Rent-It");

      // Initializing cardPanel and layout
      cl = new CardLayout();
      cards = new JPanel(cl);

      vehicleAdapter = new VehicleAdapter("vehicles.bin");
      rentalAdapter = new RentalListAdaptor("rentals.bin");
      customerAdapter = new CustomerAdaptor("customers.bin");

      // Initializing actionlistener
      buttonListener = new MyButtonListener();

      // Initializing Buttons
      addButton = new JButton("Add");
      addButton.addActionListener(buttonListener);
      deleteButton = new JButton("Delete");
      deleteButton.addActionListener(buttonListener);
      cancel1Button = new JButton("Cancel");
      cancel1Button.addActionListener(buttonListener);
      cancel2Button = new JButton("Cancel");
      cancel2Button.addActionListener(buttonListener);
      cancel3Button = new JButton("Cancel");
      cancel3Button.addActionListener(buttonListener);
      home1Button = new JButton("Home");
      home1Button.addActionListener(buttonListener);
      home2Button = new JButton("Home");
      home2Button.addActionListener(buttonListener);
      updateButton = new JButton("Update");
      updateButton.addActionListener(buttonListener);
      calculateButton = new JButton("Calculate");
      calculateButton.addActionListener(buttonListener);

      // Creating the Menu items and adding buttonListeners
      newRentalMenuItem = new JMenuItem("New Rental");
      newRentalMenuItem.addActionListener(buttonListener);

      editRentalMenuItem = new JMenuItem("Edit Rental");
      editRentalMenuItem.addActionListener(buttonListener);

      deleteRentalMenuItem = new JMenuItem("Cancel Rental");
      deleteRentalMenuItem.addActionListener(buttonListener);

      rentalsMenuItem = new JMenuItem("Manage Rentals");
      rentalsMenuItem.addActionListener(buttonListener);

      vehiclesMenuItem = new JMenuItem("Vehicles");
      vehiclesMenuItem.addActionListener(buttonListener);

      editVehicleMenuItem = new JMenuItem("Mileage & Price");
      editVehicleMenuItem.addActionListener(buttonListener);
      
      changePriceMenuItem = new JMenuItem("Change Price");
      changePriceMenuItem.addActionListener(buttonListener);

      serviceMenuItem = new JMenuItem("Service");
      serviceMenuItem.addActionListener(buttonListener);

      addVehicleMenuItem = new JMenuItem("Add Vehicle");
      addVehicleMenuItem.addActionListener(buttonListener);

      deleteVehicleMenuItem = new JMenuItem("Delete Vehicle");
      deleteVehicleMenuItem.addActionListener(buttonListener);

      // Creating the MenuBar and adding the menus
      rentalMenu = new JMenu("Rentals");

      rentalMenu.add(newRentalMenuItem);
      rentalMenu.add(editRentalMenuItem);
      rentalMenu.add(deleteRentalMenuItem);
      rentalMenu.add(rentalsMenuItem);

      vehicleMenu = new JMenu("Manage Vehicles");

      vehicleMenu.add(vehiclesMenuItem);
      vehicleMenu.add(editVehicleMenuItem);
      vehicleMenu.add(changePriceMenuItem);
      vehicleMenu.add(serviceMenuItem);
      vehicleMenu.add(addVehicleMenuItem);
      vehicleMenu.add(deleteVehicleMenuItem);

      menuBar = new JMenuBar();

      menuBar.add(rentalMenu);
      menuBar.add(vehicleMenu);
      setJMenuBar(menuBar);

      // Initializing all Panels
      overAllPanel = new JPanel();

      rentPanel = new rentalsPanel(rentalAdapter);
      newRental = new newRentalPanel(rentalAdapter, vehicleAdapter,customerAdapter);
      cancelPanel = new cancelRentalPanel(rentalAdapter);
      editPanel = new editRentalPanel(rentalAdapter);

      vehiclePanel = new JPanel(new BorderLayout());
      pricePanel = new JPanel();
      button2Panel = new JPanel();
      servicePanel = new JPanel(new BorderLayout());
      addVehiclePanel = new JPanel(new GridLayout(6, 1));
      deleteVehiclePanel = new JPanel(new GridLayout(2, 1));
      
      changePricePanel = new newPricePanel(vehicleAdapter);

      editVehiclePanel = new JPanel(new GridLayout(2, 1));
      buttonPanel = new JPanel();
      editFieldPanel = new JPanel();

      vehicle1Panel = new JPanel();

      firstPanel = new JPanel();
      secondPanel = new JPanel();
      thirdPanel = new JPanel();
      fourthPanel = new JPanel();
      fifthPanel = new JPanel();
      sixthPanel = new JPanel();

      delete1Panel = new JPanel();
      delete2Panel = new JPanel();

      // Creating and adding Logo to start up screen
      logoIcon = new ImageIcon("img/Logo.jpg");
      logoLabel = new JLabel();
      logoLabel.setIcon(logoIcon);

      overAllPanel.add(logoLabel);

      // Initializing Labels for Drop down list in vehicle Menu
      vehicleTypeLabel = new JLabel("Type: ");

      // Initializing all labels for drop down lists and text fields in add
      // vehicle menu
      addTypeLabel = new JLabel("Type: ");
      fuelTypeLabel = new JLabel("Fuel Type: ");
      transmissionTypeLabel = new JLabel("Transmission: ");
      capacityLabel = new JLabel("Capacity: ");
      loadSizeLabel = new JLabel("Load size: ");

      makeFieldLabel = new JLabel("Make: ");
      modelFieldLabel = new JLabel("Model: ");
      yearFieldLabel = new JLabel("Year: ");
      colorFieldLabel = new JLabel("Color: ");
      regNoFieldLabel = new JLabel("Reg. Nr: ");
      mileageFieldLabel = new JLabel("Mileage: ");
      locationFieldLabel = new JLabel("Location: ");
      priceFieldLabel = new JLabel("Price: ");
      capacityLabel = new JLabel("Capacity: ");
      loadSizeLabel = new JLabel("Load size: ");

      // Creating the DropDownList for vehicle Menu
      vehicleTypeBox = new JComboBox<String>();
      vehicleTypeBox.addItemListener(buttonListener);
      vehicleTypeBox.addItem("Select");
      vehicleTypeBox.addItem("All");
      vehicleTypeBox.addItem("Family Cars");
      vehicleTypeBox.addItem("Vans");
      vehicleTypeBox.addItem("Moving Trucks");
      vehicleTypeBox.addItem("Auto Campers");

      // Creating the DropDownLists for add Vehicle menu
      addTypeBox = new JComboBox<String>();
      addTypeBox.addItemListener(buttonListener);
      addTypeBox.addItem("Select");
      addTypeBox.addItem("Family Car");
      addTypeBox.addItem("Van");
      addTypeBox.addItem("Moving Truck");
      addTypeBox.addItem("Auto Camper");

      fuelTypeBox = new JComboBox<String>();
      fuelTypeBox.addItem("Select");
      fuelTypeBox.addItem("Gasoline");
      fuelTypeBox.addItem("Diesel");

      transmissionTypeBox = new JComboBox<String>();
      transmissionTypeBox.addItem("Select");
      transmissionTypeBox.addItem("Manual");
      transmissionTypeBox.addItem("Automatic");

      capacityBox = new JComboBox<String>();
      capacityBox.addItem("Select");
      capacityBox.addItem("1");
      capacityBox.addItem("2");
      capacityBox.addItem("3");
      capacityBox.addItem("4");
      capacityBox.addItem("5");
      capacityBox.addItem("6");
      capacityBox.addItem("7");
      capacityBox.addItem("8");
      capacityBox.addItem("9");
      capacityBox.addItem("10");

      loadSizeBox = new JComboBox<String>();
      loadSizeBox.addItemListener(buttonListener);
      loadSizeBox.addItem("Select");
      loadSizeBox.addItem("1000");
      loadSizeBox.addItem("1250");
      loadSizeBox.addItem("1500");
      loadSizeBox.addItem("1750");
      loadSizeBox.addItem("2000");
      loadSizeBox.addItem("2250");
      loadSizeBox.addItem("2500");
      loadSizeBox.addItem("2750");
      loadSizeBox.addItem("3000");
      loadSizeBox.addItem("3250");
      loadSizeBox.addItem("3500");
      loadSizeBox.addItem("3750");
      loadSizeBox.addItem("4000");

      loadSizeLabel.setVisible(false);
      loadSizeBox.setVisible(false);
      capacityLabel.setVisible(false);
      capacityBox.setVisible(false);

      // Adding Area to vehicle Panel
      vehicle1Panel.add(vehicleTypeLabel);
      vehicle1Panel.add(vehicleTypeBox);
      vehicle1Panel.add(home1Button);

      vehicleArea = new JTextArea(20, 50);
      vehicleArea.setEditable(false);
      vehicleScrollPane = new JScrollPane(vehicleArea);
      vehicleScrollPane
            .setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

      vehiclePanel.add(vehicle1Panel, BorderLayout.NORTH);
      vehiclePanel.add(vehicleScrollPane, BorderLayout.CENTER);

      // Creating edit KM Panel
      editRegNoLabel = new JLabel("Reg. No: ");
      newKMLabel = new JLabel("Mileage: ");
      kmLabel = new JLabel("Mileage driven: ");
      calcPriceLabel = new JLabel("Price: ");

      editRegNoField = new JTextField(10);
      newKMField = new JTextField(10);
      kmField = new JTextField(10);
      calcPriceField = new JTextField(10);

      buttonPanel.add(updateButton);
      buttonPanel.add(cancel3Button);

      editFieldPanel.add(editRegNoLabel);
      editFieldPanel.add(editRegNoField);
      editFieldPanel.add(newKMLabel);
      editFieldPanel.add(newKMField);
      
      pricePanel.add(kmLabel);
      pricePanel.add(kmField);
      pricePanel.add(calcPriceLabel);
      pricePanel.add(calcPriceField);
      button2Panel.add(calculateButton);
      
      kmField.setEditable(false);
      calcPriceField.setEditable(false);

      editVehiclePanel.add(editFieldPanel);
      editVehiclePanel.add(buttonPanel);
      editVehiclePanel.add(pricePanel);
      editVehiclePanel.add(button2Panel);

      // Creating service List in Service menu
      serviceArea = new JTextArea(20, 50);
      serviceArea.setEditable(false);
      serviceScrollPane = new JScrollPane(serviceArea);
      serviceScrollPane
            .setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

      servicePanel.add(home2Button, BorderLayout.NORTH);
      servicePanel.add(serviceScrollPane, BorderLayout.CENTER);

      // Initializing Text fields for adding vehicles
      makeField = new JTextField(10);
      modelField = new JTextField(10);
      yearField = new JTextField(4);
      colorField = new JTextField(7);
      regNoField = new JTextField(7);
      mileageField = new JTextField(10);
      locationField = new JTextField(10);
      priceField = new JTextField(5);

      // Creating Panel for Add vehicle menu
      firstPanel.add(addTypeLabel);
      firstPanel.add(addTypeBox);

      firstPanel.add(makeFieldLabel);
      firstPanel.add(makeField);
      firstPanel.add(modelFieldLabel);
      firstPanel.add(modelField);
      secondPanel.add(yearFieldLabel);
      secondPanel.add(yearField);
      secondPanel.add(colorFieldLabel);
      secondPanel.add(colorField);
      secondPanel.add(regNoFieldLabel);
      secondPanel.add(regNoField);
      thirdPanel.add(fuelTypeLabel);
      thirdPanel.add(fuelTypeBox);
      thirdPanel.add(transmissionTypeLabel);
      thirdPanel.add(transmissionTypeBox);
      thirdPanel.add(mileageFieldLabel);
      thirdPanel.add(mileageField);
      fourthPanel.add(locationFieldLabel);
      fourthPanel.add(locationField);
      fourthPanel.add(priceFieldLabel);
      fourthPanel.add(priceField);
      fourthPanel.add(loadSizeLabel);
      fourthPanel.add(loadSizeBox);
      fifthPanel.add(capacityLabel);
      fifthPanel.add(capacityBox);

      sixthPanel.add(addButton);
      sixthPanel.add(cancel1Button);

      addVehiclePanel.add(firstPanel);
      addVehiclePanel.add(secondPanel);
      addVehiclePanel.add(thirdPanel);
      addVehiclePanel.add(fourthPanel);
      addVehiclePanel.add(fifthPanel);
      addVehiclePanel.add(sixthPanel);

      // Initializing Delete vehicle menu fields
      deleteByRegNoLabel = new JLabel("Registration Number: ");
      deleteField = new JTextField(10);

      // Adding all fields to Delete vehicle menu
      delete1Panel.add(deleteByRegNoLabel);
      delete1Panel.add(deleteField);
      delete2Panel.add(deleteButton);
      delete2Panel.add(cancel2Button);

      deleteVehiclePanel.add(delete1Panel);
      deleteVehiclePanel.add(delete2Panel);

      // Adding all Panels to over all card panel
      cards.add(overAllPanel, "startUp");

      cards.add(rentPanel, "rent");
      cards.add(newRental, "newRent");
      cards.add(cancelPanel, "cancelRental");
      cards.add(editPanel, "editRental");

      cards.add(vehiclePanel, "vehicle");
      cards.add(editVehiclePanel, "edit");
      cards.add(changePricePanel, "changePrice");
      cards.add(servicePanel, "service");
      cards.add(addVehiclePanel, "addVehicle");
      cards.add(deleteVehiclePanel, "deleteVehicle");
      cl.show(cards, "startUp");

      // Adding card panel to JFrame
      add(cards);

      // Setting size and close operation
      setSize(1000, 800);
      setVisible(true);
      setResizable(true);

      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
   }

   // Making list update when entering panel
   private void updateAllVehicleArea()
   {
      VehicleList vehicles = vehicleAdapter.getAllVehicles();
      vehicleArea.setText(vehicles.toString());
   }

   private void updateFamilyVehicleArea()
   {
      Vehicle[] vehicles = vehicleAdapter.getFamilyCars();
      String str = "";
      for (int i = 0; i < vehicles.length; i++)
      {
         str += vehicles[i].toString() + "\n";
      }
      vehicleArea.setText(str);
   }

   private void updateVanVehicleArea()
   {
      Vehicle[] vehicles = vehicleAdapter.getVans();
      String str = "";
      for (int i = 0; i < vehicles.length; i++)
      {
         str += vehicles[i].toString() + "\n";
      }
      vehicleArea.setText(str);
   }

   private void updateMovingTruckVehicleArea()
   {
      Vehicle[] vehicles = vehicleAdapter.getMovingTrucks();
      String str = "";
      for (int i = 0; i < vehicles.length; i++)
      {
         str += vehicles[i].toString() + "\n";
      }
      vehicleArea.setText(str);
   }

   private void updateAutoCamperVehicleArea()
   {
      Vehicle[] vehicles = vehicleAdapter.getAutoCamper();
      String str = "";
      for (int i = 0; i < vehicles.length; i++)
      {
         str += vehicles[i].toString() + "\n";
      }
      vehicleArea.setText(str);
   }

   private void updateServiceArea()
   {
      VehicleList vehicles = vehicleAdapter.getAllVehicles();
      String str = "";

      for (int i = 0; i < vehicles.size(); i++)
      {

         if (vehicles.getVehicleByIndex(i).getMileage() % 20000 >= 19000)
         {
            str += vehicles.getVehicleByIndex(i) + "\n";
         }
      }
      serviceArea.setText(str);
   }

   // Creating Action listeners for everything
   private class MyButtonListener implements ActionListener, ItemListener
   {
     
       Rental tempRental = null;
      public void actionPerformed(ActionEvent e)
      {
         
         int oldMileage = 0;
         RentalList tempList = rentalAdapter.getAllRentals();
         int newMile = 0;
         
         if (e.getSource() == rentalsMenuItem)
         {
            cl.show(cards, "rent");
         }
         if (e.getSource() == newRentalMenuItem)
         {
            cl.show(cards, "newRent");
         }
         if(e.getSource() == editRentalMenuItem)
         {
            cl.show(cards, "editRental");
         }
         if (e.getSource() == deleteRentalMenuItem)
         {
            cl.show(cards, "cancelRental");
         }

         if (e.getSource() == vehiclesMenuItem)
         {
            cl.show(cards, "vehicle");
            
            updateAllVehicleArea();
            updateFamilyVehicleArea();
            updateVanVehicleArea();
            updateMovingTruckVehicleArea();
            updateAutoCamperVehicleArea();
         }
         if (e.getSource() == editVehicleMenuItem)
         {
            cl.show(cards, "edit");
         }
         if(e.getSource() == changePriceMenuItem)
         {
            cl.show(cards, "changePrice");
         }
         if (e.getSource() == serviceMenuItem)
         {
            cl.show(cards, "service");

            updateServiceArea();
         }
         if (e.getSource() == addVehicleMenuItem)
         {
            cl.show(cards, "addVehicle");
         }
         if (e.getSource() == deleteVehicleMenuItem)
         {
            cl.show(cards, "deleteVehicle");
         }

         if (e.getSource() == updateButton)
         {
            VehicleList vehicles = vehicleAdapter.getAllVehicles();

            GregorianCalendar today = new GregorianCalendar();
            
            String regNo = editRegNoField.getText();
            String mileage = newKMField.getText();

            newMile = Integer.parseInt(mileage);

            for (int i = 0; i < vehicles.size(); i++)
            {
               if (vehicles.getVehicleByIndex(i).getRegNo().equals(regNo))
               {
                  Vehicle tempVehicle = vehicles.getVehicleByIndex(i);
                  for(int j = 0; j < tempList.size(); j++)
                  {
                     if(tempList.getRentalAtIndex(j).getVehicle().getRegNo().equals(tempVehicle.getRegNo()))
                     {
                        if(tempList.getRentalAtIndex(j).getReturnTime().getDay() == today.get(GregorianCalendar.DAY_OF_MONTH)
                              && tempList.getRentalAtIndex(j).getReturnTime().getMonth() == today.get(GregorianCalendar.MONTH)+1
                              && tempList.getRentalAtIndex(j).getReturnTime().getYear() == today.get(GregorianCalendar.YEAR))
                        {
                           tempRental = tempList.getRentalAtIndex(j);
                        }
                     }
                     
                  }
                  oldMileage = vehicles.getVehicleByIndex(i).getMileage();
                  vehicles.getVehicleByIndex(i).setMileage(newMile);
                  
                  kmField.setText((newMile - oldMileage) + "");
               }
               vehicleAdapter.saveVehicles(vehicles);
            }
         }
         if(e.getSource() == calculateButton)
         {
            int kilometers=Integer.parseInt(kmField.getText());
            double price=tempRental.calculateRentalPrice(kilometers);
            calcPriceField.setText(price+"");
         }
         if (e.getSource() == addButton)
         {
            String make = makeField.getText();
            String model = modelField.getText();
            String year = yearField.getText();
            String color = colorField.getText();
            String regNo = regNoField.getText();
            String mileage = mileageField.getText();
            String location = locationField.getText();
            String price = priceField.getText();

            String addvehicleType = (String) addTypeBox.getSelectedItem();
            String fuelType = (String) fuelTypeBox.getSelectedItem();
            String transmission = (String) transmissionTypeBox
                  .getSelectedItem();
            String loadSize = (String) loadSizeBox.getSelectedItem();
            String capacity = (String) capacityBox.getSelectedItem();

            int y = 2016;
            int mile = 0;
            double p = 100.00;

            try
            {
               y = Integer.parseInt(year);
               mile = Integer.parseInt(mileage);
               p = Double.parseDouble(price);
            }
            catch (NumberFormatException i)
            {
               JOptionPane.showMessageDialog(null, "Wrong input, try again");
               return;
            }

            switch (addvehicleType)
            {
               case "Family Car":
                  FamilyCar fc1 = new FamilyCar(make, model, y, color, regNo,
                        fuelType, mile, transmission, location, p);

                  vehicleAdapter.addVehicle(fc1);
                  break;
               case "Van":
                  int ls = Integer.parseInt(loadSize);

                  Van v1 = new Van(make, model, y, color, regNo, fuelType,
                        mile, transmission, location, p, ls);

                  vehicleAdapter.addVehicle(v1);
                  break;
               case "Moving Truck":
                  int ls1 = Integer.parseInt(loadSize);

                  MovingTruck mt1 = new MovingTruck(make, model, y, color,
                        regNo, fuelType, mile, transmission, location, p, ls1);

                  vehicleAdapter.addVehicle(mt1);
                  break;
               case "Auto Camper":
                  int cap = Integer.parseInt(capacity);

                  AutoCamper ac1 = new AutoCamper(make, model, y, color, regNo,
                        fuelType, mile, transmission, location, p, cap);

                  vehicleAdapter.addVehicle(ac1);
            }

            JOptionPane.showMessageDialog(null, "Vehicle Added");

            makeField.setText("");
            modelField.setText("");
            yearField.setText("");
            colorField.setText("");
            regNoField.setText("");
            mileageField.setText("");
            locationField.setText("");
            priceField.setText("");

            addTypeBox.setSelectedIndex(0);
            fuelTypeBox.setSelectedIndex(0);
            transmissionTypeBox.setSelectedIndex(0);
            loadSizeBox.setSelectedIndex(0);
            capacityBox.setSelectedIndex(0);
         }

         if (e.getSource() == deleteButton)
         {
            vehicleAdapter.deleteVehicle(deleteField.getText());
            JOptionPane.showMessageDialog(null, "Vehicle Deleted");

            deleteField.setText("");
         }

         if (e.getSource() == cancel1Button || e.getSource() == cancel2Button
               || e.getSource() == cancel3Button
               || e.getSource() == home1Button || e.getSource() == home2Button)
         {
            cl.show(cards, "startUp");

            vehicleTypeBox.setSelectedIndex(0);
            addTypeBox.setSelectedIndex(0);
            fuelTypeBox.setSelectedIndex(0);
            transmissionTypeBox.setSelectedIndex(0);
            loadSizeBox.setSelectedIndex(0);
            capacityBox.setSelectedIndex(0);

            vehicleArea.setText("");
            serviceArea.setText("");
         }
      }

      // Itemlistener for the Drop Down Lists (like actionListener)
      @Override
      public void itemStateChanged(ItemEvent event)
      {
         if (event.getStateChange() == ItemEvent.SELECTED)
         {
            String additem = (String) event.getItem();
            String vehicleItem = (String) event.getItem();
            if (event.getSource() == addTypeBox)
            {
               switch (additem)
               {

                  case "Family Car":
                     loadSizeLabel.setVisible(false);
                     loadSizeBox.setVisible(false);
                     capacityLabel.setVisible(false);
                     capacityBox.setVisible(false);
                     addVehiclePanel.revalidate();
                     addVehiclePanel.repaint();
                     break;

                  case "Van":
                     loadSizeLabel.setVisible(true);
                     loadSizeBox.setVisible(true);
                     capacityLabel.setVisible(false);
                     capacityBox.setVisible(false);
                     addVehiclePanel.revalidate();
                     addVehiclePanel.repaint();
                     break;

                  case "Moving Truck":
                     loadSizeLabel.setVisible(true);
                     loadSizeBox.setVisible(true);
                     capacityLabel.setVisible(false);
                     capacityBox.setVisible(false);
                     addVehiclePanel.revalidate();
                     addVehiclePanel.repaint();
                     break;

                  case "Auto Camper":
                     loadSizeLabel.setVisible(false);
                     loadSizeBox.setVisible(false);
                     capacityLabel.setVisible(true);
                     capacityBox.setVisible(true);
                     addVehiclePanel.revalidate();
                     addVehiclePanel.repaint();
                     break;
               }

            }
            if (event.getSource() == vehicleTypeBox)
            {
               switch (vehicleItem)
               {
                  case "All":
                     updateAllVehicleArea();
                     break;
                  case "Family Cars":
                     updateFamilyVehicleArea();
                     break;
                  case "Vans":
                     updateVanVehicleArea();
                     break;
                  case "Moving Trucks":
                     updateMovingTruckVehicleArea();
                     break;
                  case "Auto Campers":
                     updateAutoCamperVehicleArea();
                     break;
               }
            }

         }
      }
   }
}
