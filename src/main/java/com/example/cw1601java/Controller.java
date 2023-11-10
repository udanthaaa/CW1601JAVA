package com.example.cw1601java;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.time.LocalDate;
import java.util.*;
import java.io.*;
import java.net.URL;
import java.util.function.Predicate;

public class Controller implements Initializable {

	// FXML elements used in the GUI.
	@FXML
	private Button DashDriverManagement;

	@FXML
	private Button DashViewStandings;

	@FXML
	private Button DashSimulateRace;

	@FXML
	private Button DashSortByDate;

	@FXML
	private Button DashDataManagement;

	@FXML
	private TableView<DriverDetails> DetailsTable;

	@FXML
	private TableView<DriverDetails> DetailsTable1;

	@FXML
	private TableView<DriverDetails> DetailsTable2;

	@FXML
	private TableView<DriverDetails> DetailsTable3;

	@FXML
	private TableView<RaceDetails> SRRTable;

	@FXML
	private TableView<RaceDetails> VRLTable;

	@FXML
	private TableColumn<DriverDetails, String> NameColumn;

	@FXML
	private TableColumn<DriverDetails, Integer> AgeColumn;

	@FXML
	private TableColumn<DriverDetails, String> TeamColumn;

	@FXML
	private TableColumn<DriverDetails, String> CarColumn;

	@FXML
	private TableColumn<DriverDetails, Integer> CurrentPointsColumn;

	@FXML
	private TextField NameField;

	@FXML
	private TextField AgeField;

	@FXML
	private TextField TeamField;

	@FXML
	private TextField CarField;

	@FXML
	private TextField CurrentPointsField;

	@FXML
	private TextField SearchField;

	@FXML
	private TextField SearchField1;

	@FXML
	private TextField SearchField2;

	@FXML
	private Button btnDriverManagement;

	@FXML
	private Button btnViewStandings;

	@FXML
	private Button btnSimulateRace;

	@FXML
	private Button btnSortByDate;

	@FXML
	private Button btnDataManagement;

	@FXML
	private Button btnDashboard;

	@FXML
	private Button backBtn;

	@FXML
	private Pane pneDriverManagement;

	@FXML
	private Pane pneViewStandings;

	@FXML
	private Pane pneSimulateRace;

	@FXML
	private Pane pneSortbyDate;

	@FXML
	private Pane pneDataManagement;

	@FXML
	private Pane pneDashboard;

	@FXML
	private Pane fullDetails;

	@FXML
	private Label msgLabel;

	@FXML
	private Label msgLabel1;

	@FXML
	private DatePicker datePick;

	@FXML
	private Label srrLabel;

	@FXML
	private Label msgLabel2;

	@FXML
	private Label msgLabel3;

	@FXML
	private TableColumn<DriverDetails, String> NameColumn1;

	@FXML
	private TableColumn<DriverDetails, Integer> AgeColumn1;

	@FXML
	private TableColumn<DriverDetails, String> TeamColumn1;

	@FXML
	private TableColumn<DriverDetails, String> CarColumn1;

	@FXML
	private TableColumn<DriverDetails, Integer> CurrentPointsColumn1;

	@FXML
	private TableColumn<DriverDetails, String> NameColumn2;

	@FXML
	private TableColumn<DriverDetails, Integer> AgeColumn2;

	@FXML
	private TableColumn<DriverDetails, String> TeamColumn2;

	@FXML
	private TableColumn<DriverDetails, String> CarColumn2;

	@FXML
	private TableColumn<DriverDetails, Integer> CurrentPointsColumn2;

	@FXML
	private TableColumn<DriverDetails, String> NameColumn3;

	@FXML
	private TableColumn<DriverDetails, Integer> AgeColumn3;

	@FXML
	private TableColumn<DriverDetails, String> TeamColumn3;

	@FXML
	private TableColumn<DriverDetails, String> CarColumn3;

	@FXML
	private TableColumn<DriverDetails, Integer> CurrentPointsColumn3;

	@FXML
	private TableColumn<RaceDetails, String> FDriverColumn;

	@FXML
	private TableColumn<RaceDetails, Integer> FPoints;

	@FXML
	private TableColumn<RaceDetails, String> LocationColumn;

	@FXML
	private TableColumn<RaceDetails, String> SDriverColumn;

	@FXML
	private TableColumn<RaceDetails, Integer> SPoints;

	@FXML
	private TableColumn<RaceDetails, String> TDriverColumn;

	@FXML
	private TableColumn<RaceDetails, Integer> TPoints;

	@FXML
	private TableColumn<RaceDetails, Date> dateColumn;

	@FXML
	private TableColumn<RaceDetails, String> FDriverColumn1;

	@FXML
	private TableColumn<RaceDetails, Integer> FPoints1;

	@FXML
	private TableColumn<RaceDetails, String> LocationColumn1;

	@FXML
	private TableColumn<RaceDetails, String> SDriverColumn1;

	@FXML
	private TableColumn<RaceDetails, Integer> SPoints1;

	@FXML
	private TableColumn<RaceDetails, String> TDriverColumn1;

	@FXML
	private TableColumn<RaceDetails, Integer> TPoints1;

	@FXML
	private TableColumn<RaceDetails, Date> dateColumn1;

	@FXML
	private TableColumn<RaceFullDetails, Integer> FDCurrentPoints;

	@FXML
	private TableColumn<RaceFullDetails, Date> FDDate;

	@FXML
	private TableColumn<RaceFullDetails, String> FDLocation;

	@FXML
	private TableColumn<RaceFullDetails, String> FDName;

	@FXML
	private TableColumn<RaceFullDetails, Integer> FDPosition;


	@FXML
	private TableView<RaceFullDetails> FDTable;


	// Creating an observable list of DriverDetails objects.
	final ObservableList<DriverDetails> dataList = FXCollections.observableArrayList();

	// Creating a Filtered list.
	private FilteredList<DriverDetails> fData;

	private Timeline timeline;

	// Creating an observable list to sort data.
	final ObservableList<DriverDetails> sort = FXCollections.observableArrayList();

	// Creating an observable list of Race Details objects.
	final ObservableList<RaceDetails> racelist = FXCollections.observableArrayList();

	// Creating an observable list to sort by date.
	final ObservableList<RaceDetails> sortbyDate = FXCollections.observableArrayList();

	final ObservableList<RaceFullDetails> FullDetails = FXCollections.observableArrayList();

	//Opening the File Chooser.
	FileChooser fileChooser = new FileChooser();


	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		// Set cell value factories for driver details table columns
		NameColumn.setCellValueFactory(new PropertyValueFactory<DriverDetails, String>("Name"));
		AgeColumn.setCellValueFactory(new PropertyValueFactory<DriverDetails, Integer>("Age"));
		TeamColumn.setCellValueFactory(new PropertyValueFactory<DriverDetails, String>("Team"));
		CarColumn.setCellValueFactory(new PropertyValueFactory<DriverDetails, String>("Car"));
		CurrentPointsColumn.setCellValueFactory(new PropertyValueFactory<DriverDetails, Integer>("CurrentPoints"));

		// Set cell value factories for driver details table columns
		NameColumn1.setCellValueFactory(new PropertyValueFactory<DriverDetails, String>("Name"));
		AgeColumn1.setCellValueFactory(new PropertyValueFactory<DriverDetails, Integer>("Age"));
		TeamColumn1.setCellValueFactory(new PropertyValueFactory<DriverDetails, String>("Team"));
		CarColumn1.setCellValueFactory(new PropertyValueFactory<DriverDetails, String>("Car"));
		CurrentPointsColumn1.setCellValueFactory(new PropertyValueFactory<DriverDetails, Integer>("CurrentPoints"));

		// Set cell value factories for driver details table columns
		NameColumn2.setCellValueFactory(new PropertyValueFactory<DriverDetails, String>("Name"));
		AgeColumn2.setCellValueFactory(new PropertyValueFactory<DriverDetails, Integer>("Age"));
		TeamColumn2.setCellValueFactory(new PropertyValueFactory<DriverDetails, String>("Team"));
		CarColumn2.setCellValueFactory(new PropertyValueFactory<DriverDetails, String>("Car"));
		CurrentPointsColumn2.setCellValueFactory(new PropertyValueFactory<DriverDetails, Integer>("CurrentPoints"));

		// Set cell value factories for driver details table columns
		NameColumn3.setCellValueFactory(new PropertyValueFactory<DriverDetails, String>("Name"));
		AgeColumn3.setCellValueFactory(new PropertyValueFactory<DriverDetails, Integer>("Age"));
		TeamColumn3.setCellValueFactory(new PropertyValueFactory<DriverDetails, String>("Team"));
		CarColumn3.setCellValueFactory(new PropertyValueFactory<DriverDetails, String>("Car"));
		CurrentPointsColumn3.setCellValueFactory(new PropertyValueFactory<DriverDetails, Integer>("CurrentPoints"));

		// Set cell value factories for race table columns
		dateColumn.setCellValueFactory(new PropertyValueFactory<RaceDetails, Date>("date"));
		LocationColumn.setCellValueFactory(new PropertyValueFactory<RaceDetails, String>("location"));
		FDriverColumn.setCellValueFactory(new PropertyValueFactory<RaceDetails, String>("firstPlaceDriver"));
		SDriverColumn.setCellValueFactory(new PropertyValueFactory<RaceDetails, String>("secondPlaceDriver"));
		TDriverColumn.setCellValueFactory(new PropertyValueFactory<RaceDetails, String>("thirdPlaceDriver"));
		FPoints.setCellValueFactory(new PropertyValueFactory<RaceDetails, Integer>("firstPlacePoints"));
		SPoints.setCellValueFactory(new PropertyValueFactory<RaceDetails, Integer>("secondPlacePoints"));
		TPoints.setCellValueFactory(new PropertyValueFactory<RaceDetails, Integer>("thirdPlacePoints"));
		SRRTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {
				fullDetails.toFront();
			}
		});
		// Define a new table view for all race details
		FDDate.setCellValueFactory(new PropertyValueFactory<RaceFullDetails, Date>("date"));
		FDLocation.setCellValueFactory(new PropertyValueFactory<RaceFullDetails, String>("location"));
		FDName.setCellValueFactory(new PropertyValueFactory<RaceFullDetails, String>("name"));
		FDCurrentPoints.setCellValueFactory(new PropertyValueFactory<RaceFullDetails, Integer>("currentPoints"));
		FDPosition.setCellValueFactory(new PropertyValueFactory<RaceFullDetails, Integer>("position"));

		// Set cell value factories for race table columns
		dateColumn1.setCellValueFactory(new PropertyValueFactory<RaceDetails, Date>("date"));
		LocationColumn1.setCellValueFactory(new PropertyValueFactory<RaceDetails, String>("location"));
		FDriverColumn1.setCellValueFactory(new PropertyValueFactory<RaceDetails, String>("firstPlaceDriver"));
		SDriverColumn1.setCellValueFactory(new PropertyValueFactory<RaceDetails, String>("secondPlaceDriver"));
		TDriverColumn1.setCellValueFactory(new PropertyValueFactory<RaceDetails, String>("thirdPlaceDriver"));
		FPoints1.setCellValueFactory(new PropertyValueFactory<RaceDetails, Integer>("firstPlacePoints"));
		SPoints1.setCellValueFactory(new PropertyValueFactory<RaceDetails, Integer>("secondPlacePoints"));
		TPoints1.setCellValueFactory(new PropertyValueFactory<RaceDetails, Integer>("thirdPlacePoints"));

		// Create a filtered list
		fData = new FilteredList<>(dataList, e -> true);

		// Set items for tables
		DetailsTable.setItems(dataList);
		DetailsTable1.setItems(dataList);
		DetailsTable2.setItems(dataList);
		DetailsTable3.setItems(dataList);
		SRRTable.setItems(racelist);
		VRLTable.setItems(racelist);
		FDTable.setItems(FullDetails);

		//Load the Race details from the text file.
		LoadFullRaceData();
		LoadRaceData();

	}

	//https://stackoverflow.com/questions/29709608/how-do-i-add-objects-to-an-observable-array-backing-list
	//https://www.youtube.com/watch?v=jm_gVp12h0s&t=2727s
	@FXML
	public void addDriver(ActionEvent actionEvent){
		// Get the driver details entered by the user
		DriverDetails Driver = getDriver();

		// If driver details are not null
		if (Driver != null) {

			// Check if the driver already exists in the list
			if (DriverDuplicateCheck(Driver)) {
				displayMsg("This driver already exists in the list.", false);

			// If the driver does not exist in the list, add the driver to the list
			} else {
				dataList.add(new DriverDetails(Driver.getName(), Driver.getAge(), Driver.getTeam(), Driver.getCar(), Driver.getCurrentPoints()));
				displayMsg("Driver has been successfully added.", true);

				// Clear the fields after adding the driver to the list
				NameField.setText("");
				AgeField.setText("");
				TeamField.setText("");
				CarField.setText("");
				CurrentPointsField.setText("");
			}
		}
	}

	//https://www.youtube.com/watch?v=jm_gVp12h0s&t=2727s
	private DriverDetails getDriver() {
		DriverDetails driver = null;
		try {
			//Getting driver details input from text fields.
			String Name = NameField.getText().trim();
			int Age = Integer.parseInt(AgeField.getText().trim());
			String Team = TeamField.getText().trim();
			String Car = CarField.getText().trim();
			int CurrentPoints = Integer.parseInt(CurrentPointsField.getText().trim());

			//Checking if all fields are filled in.
			if (Name.isEmpty() || Team.isEmpty() || Car.isEmpty()) {
				displayMsg("Please fill in all required fields.",false);
				return null;

				//Checking if Name contains only A-Z characters and spaces.
			} else if (!Name.matches("[a-zA-Z ]+")){
				displayMsg("The name field can only contain alphabetic characters.",false);
				return null;

				//Check if the age is between 18 and 60.
			} else if (Age<18 || Age>60) {
				displayMsg("Drivers must be between 18 and 60 years old to be eligible to compete.",false);
				return null;

				//Checking if the current point are greater than 0.
			} else if (CurrentPoints<0) {
				displayMsg("Please enter a positive value for current points.",false);
				return null;
			}

			//Creating new object in Driver data and adding it.
			driver = new DriverDetails(Name, Age, Team, Car, CurrentPoints);

			//If user enters string value to Age and Current Points, display and error
		} catch (NumberFormatException e) {
			displayMsg("Please ensure that all fields are filled in correctly.",false);
		}
		return driver;
	}


	// Check if the driver already exists in the list
	private boolean DriverDuplicateCheck(DriverDetails driverDetails) {
		for (DriverDetails driverDetails1 : DetailsTable.getItems()) {
			if (driverDetails1.getName().equalsIgnoreCase(driverDetails.getName())) {
				return true;
			}
		}
		return false;
	}

	//https://www.youtube.com/watch?v=jm_gVp12h0s&t=2727s
	@FXML
	public void deleteDriver(ActionEvent actionEvent) {
		// Get the index of the selected driver in the table.
		int selectedID = DetailsTable.getSelectionModel().getSelectedIndex();

		// If user didn't select a driver, display a message to the user and return.
		if (selectedID < 0) {
			displayMsg("Please select a driver from the table to delete.", false);
			return;
		}


		// If user selected a driver, ask the user to confirm the deletion with an alert.
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Delete Driver");
		alert.setHeaderText("Are you sure you want to delete this driver?");
		alert.setContentText("This action cannot be undone.");
		Optional<ButtonType> result = alert.showAndWait();

		//If user pressed OK , delete the driver from the table and the list.
		if (result.get() == ButtonType.OK) {
			DriverDetails selectedDriver = DetailsTable.getSelectionModel().getSelectedItem();
			fData.getSource().remove(selectedDriver);
			DetailsTable.setItems(fData);

			// Clear the fields after deleting the driver from the list.
			NameField.setText("");
			AgeField.setText("");
			TeamField.setText("");
			CarField.setText("");
			CurrentPointsField.setText("");
			displayMsg("Driver has been successfully deleted.", true);
		}
	}

	//https://www.youtube.com/watch?v=jm_gVp12h0s&t=2727s
	@FXML
	public void updateDriver(ActionEvent actionEvent){
		//Get driver details.
		DriverDetails Driver = getupdates();

		// If driver details are not null, update the driver.
		if (Driver != null) {
			//Get the index of the selected driver from the table and update that driver from the table and the list.
			int index = DetailsTable.getSelectionModel().getFocusedIndex();
			DriverDetails selectedDriver = DetailsTable.getItems().get(index);
			int dataListIndex = dataList.indexOf(selectedDriver);
			dataList.set(dataListIndex, Driver);
			displayMsg("The driver details have been updated successfully in the list.", true);
			NameField.setText("");
			AgeField.setText("");
			TeamField.setText("");
			CarField.setText("");
			CurrentPointsField.setText("");
		}

	}

	public DriverDetails getupdates() {
		DriverDetails Driver = null;
		try {
			//Getting driver details input from text fields.
			String Name = NameField.getText().trim();
			int Age = Integer.parseInt(AgeField.getText().trim());
			String Team = TeamField.getText().trim();
			String Car = CarField.getText().trim();
			int CurrentPoints = Integer.parseInt(CurrentPointsField.getText().trim());

			DriverDetails selectedDriver = DetailsTable.getSelectionModel().getSelectedItem();
			if(selectedDriver == null){
				displayMsg("Please select a driver from the table to update.", false);
				return null;
			}
			//Check if driver already exist in the table.
			if (!Name.equalsIgnoreCase(selectedDriver.getName())) {
				for (DriverDetails driverDetails : dataList) {
					if (driverDetails.getName().equalsIgnoreCase(Name)) {
						displayMsg("This driver already exists in the list.", false);
						return null;
					}
				}
			}
			//Checking if all fields are filled in.
			if (Name.isEmpty() || Team.isEmpty() || Car.isEmpty()) {
				displayMsg("Please fill in all required fields.",false);
				return null;

				//Checking if Name contains only A-Z characters and spaces.
			} else if (!Name.matches("[a-zA-Z ]+")){
				displayMsg("The name field can only contain alphabetic characters.",false);
				return null;

				//Check if the age is between 18 and 60.
			} else if (Age<18 || Age>60) {
				displayMsg("Drivers must be between 18 and 60 years old to be eligible to compete.",false);
				return null;

				//Checking if the current point are greater than 0.
			} else if (CurrentPoints<0) {
				displayMsg("Please enter a positive value for current points.",false);
				return null;
			}

			//Creating new object in Driver data and adding it.
			Driver = new DriverDetails(Name, Age, Team, Car, CurrentPoints);

			//If user enters string value to Age and Current Points, display and error
		} catch (NumberFormatException e) {
			displayMsg("Please ensure that all fields are filled in correctly.",false);
		}
		return Driver;
	}

	//https://www.javatpoint.com/bubble-sort-in-java
	@FXML
	public void sortByCP(ActionEvent actionEvent){
		//Check if driver list is greater than 2. If not, display massage to enter at least 2 drivers.
		if (dataList.size() < 2) {
			displayMsg4("Please add at least 2 drivers to run this option.",false);
			return;
		}

		//Clear the previous list and add the data list to sort list.
		sort.clear();
		sort.addAll(dataList);

		//Sort the list by current points using bubble sort.
		for (int i=  0; i<sort.size()-1; i++) {
			for (int x=0; x<sort.size()-i-1; x++) {
				if (sort.get(x).getCurrentPoints()<sort.get(x+1).getCurrentPoints()) {
					DriverDetails t = sort.get(x);
					sort.set(x, sort.get(x+1));
					sort.set(x+1, t);
				}
			}
		}

		//Set the new list to the table.
		DetailsTable2.setItems(sort);
		displayMsg4("Done!",true);
	}

	@FXML
	public void simulateRace(ActionEvent actionEvent) {
		//Check if driver list is greater than 3. If not, display massage to enter at least 3 drivers.
		if (dataList.size() < 3){
			displayMsg2("Please add at least 3 drivers to run this option.", false);
			return;
		}

		//Get date input using date picker.
		LocalDate date = datePick.getValue();

		//check if date duplicates
		for (RaceDetails race : racelist) {
			if (race.getDate().equals(date)) {
				displayMsg2("Cannot simulate more than one race on the same date.",false);
				return;
			}
		}

		//Check if user picked a date from date picker. If not, display massage saying user to pick a date.
		if (date == null) {
			displayMsg2("Please select a race date.", false);
			return;
		}


		//Create a new array and add Race locations.
		ArrayList<String> locations = new ArrayList<>();
		locations.add("Nyirád");
		locations.add("Höljes");
		locations.add("Montalegre");
		locations.add("Barcelona");
		locations.add("Rīga");
		locations.add("Norway");

		//Shuffle race locations to select them randomly.
		Collections.shuffle(locations, new Random());
		String randomLocation = locations.get(new Random().nextInt(locations.size()));

		//Create a new list and add drivers to the list.
		List<DriverDetails> drivers = new ArrayList<>();
		drivers.addAll(dataList);
		Collections.shuffle(drivers);

		//Create a new List and add a point list.
		List<PositionPoints> positionPointsList = new ArrayList<>();
		positionPointsList.add(new PositionPoints(1, 10));
		positionPointsList.add(new PositionPoints(2, 7));
		positionPointsList.add(new PositionPoints(3, 5));

		//Selecting drivers from list and giving them position and points.
		for (int i = 0; i < drivers.size(); i++) {
			int position = i + 1;
			int points = 0;
			for (PositionPoints positionPoints : positionPointsList) {
				if (positionPoints.getPosition() == position) {
					points = positionPoints.getPoints();
					break;
				}
			}

			//Update the current points of the driver by adding the points they earned in the random race.
			drivers.get(i).setCurrentPoints(drivers.get(i).getCurrentPoints() + points);
		}

		//Get details of the top 3 drivers and their points
		String firstPlaceDriver = drivers.get(0).getName();
		String secondPlaceDriver = drivers.get(1).getName();
		String thirdPlaceDriver = drivers.get(2).getName();
		int firstPlacePoints = drivers.get(0).getCurrentPoints();
		int secondPlacePoints = drivers.get(1).getCurrentPoints();
		int thirdPlacePoints = drivers.get(2).getCurrentPoints();

		//Creating new object in race details and adding it to the list.
		racelist.add(new RaceDetails(date, randomLocation, firstPlaceDriver, secondPlaceDriver, thirdPlaceDriver, firstPlacePoints, secondPlacePoints, thirdPlacePoints));
		displayMsg2("Race Generated.",true);
		DetailsTable.refresh();
		VRLTable.refresh();

		List<Integer> positions = new ArrayList<>(dataList.size());
		for (int i = 1; i <= dataList.size(); i++) {
			positions.add(i);
		}


		for (int b = 0; b < dataList.size(); b++){
			String name = drivers.get(b).getName();
			int CurrentPoints = drivers.get(b).getCurrentPoints();
			FullDetails.add(new RaceFullDetails(date, randomLocation, name, CurrentPoints,positions.get(b)));
		}

		//Saving data automatically to text file.
		SaveRaceData();
		SaveFullRaceData();
	}

	//https://stackoverflow.com/questions/11496700/how-to-use-printwriter-and-file-classes-in-java
	//https://stackoverflow.com/questions/55963792/using-printwriter-to-create-a-text-file-with-several-rows-from-a-list
	public void SaveRaceData(){
		//Selecting the File to save data.
		File file = new File ("src\\main\\resources\\com\\example\\cw1601java\\Race.txt");
		if (file!=null) {
			try {

				//Writing data to file using the print writer.
				PrintWriter printWriter = new PrintWriter(new FileWriter(file));
				for (RaceDetails raceDetails:racelist) {
					printWriter.write(raceDetails.getDate() + "," + raceDetails.getLocation() + "," + raceDetails.getFirstPlaceDriver() + "," + raceDetails.getSecondPlaceDriver() + "," + raceDetails.getThirdPlaceDriver() + "," + raceDetails.getFirstPlacePoints() + "," + raceDetails.getSecondPlacePoints() + "," + raceDetails.getThirdPlacePoints() + "\n");
				}
				printWriter.close();

			//If the file is not there, then display error.
			} catch (Exception e) {
				displayMsg2("Error saving race data to file.", false);
			}
		}
	}

	public void SaveFullRaceData(){
		//Selecting the File to save data.
		File file = new File ("src\\main\\resources\\com\\example\\cw1601java\\FullData.txt");
		if (file!=null) {
			try {

				//Writing data to file using the print writer.
				PrintWriter printWriter = new PrintWriter(new FileWriter(file));
				for (RaceFullDetails raceDetails:FullDetails) {
					printWriter.write(raceDetails.getDate() + "," + raceDetails.getLocation() + "," + raceDetails.getName() + "," + raceDetails.getCurrentPoints() + "," + raceDetails.getPosition() + "\n");
				}
				printWriter.close();

				//If the file is not there, then display error.
			} catch (Exception e) {
				displayMsg2("Error saving race data to file.", false);
			}
		}
	}

	//https://www.w3schools.com/java/java_files_read.asp
	//https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
	public void LoadRaceData() {
		//Selecting the File to load data.
		File file = new File("src\\main\\resources\\com\\example\\cw1601java\\Race.txt");
		if (file != null) {
			try {
				//Reading data from file using the buffered reader.
				BufferedReader in = new BufferedReader(new FileReader(file));
				String line;

				//Reading data line by line.
				while ((line = in.readLine())!=null) {
					String[] split = line.split(",");
					if (split.length != 8) {
						continue;
					}
					LocalDate date = LocalDate.parse(split[0].trim());
					String location  = split[1].trim();
					String firstPlaceDriver = split[2].trim();
					String secondPlaceDriver = split[3].trim();
					String thirdPlaceDriver = split[4].trim();
					int firstPlacePoints = Integer.parseInt(split[5].trim());
					int secondPlacePoints = Integer.parseInt(split[6].trim());
					int thirdPlacePoints = Integer.parseInt(split[7].trim());

					//Creating new object in race details and adding it to the list.
					RaceDetails race = new RaceDetails(date, location, firstPlaceDriver, secondPlaceDriver, thirdPlaceDriver, firstPlacePoints, secondPlacePoints, thirdPlacePoints);
					racelist.add(race);
				}

				//Set race details to SRR Table.
				SRRTable.setItems(racelist);

			//If file cannot be found, then display an error.
			} catch (FileNotFoundException e) {
				displayMsg2("File not found.", false);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public void LoadFullRaceData() {
		//Selecting the File to load data.
		File file = new File("src\\main\\resources\\com\\example\\cw1601java\\FullData.txt");
		if (file != null) {
			try {
				//Reading data from file using the buffered reader.
				BufferedReader in = new BufferedReader(new FileReader(file));
				String line;

				//Reading data line by line.
				while ((line = in.readLine())!=null) {
					String[] split = line.split(",");
					if (split.length != 5) {
						continue;
					}
					LocalDate date = LocalDate.parse(split[0].trim());
					String location  = split[1].trim();
					String Name = split[2].trim();
					int CurrentPoints = Integer.parseInt(split[3].trim());
					int Position = Integer.parseInt(split[4].trim());

					//Creating new object in race details and adding it to the list.
					RaceFullDetails raceFullDetails = new RaceFullDetails(date, location, Name, CurrentPoints, Position);
					FullDetails.add(raceFullDetails);
				}

				//Set race details to FD Table.
				FDTable.setItems(FullDetails);

				//If file cannot be found, then display an error.
			} catch (FileNotFoundException e) {
				displayMsg2("File not found.", false);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	//https://www.javatpoint.com/bubble-sort-in-java
	//https://www.javatpoint.com/insertion-sort-in-java
	//https://www.geeksforgeeks.org/insertion-sort/
	@FXML
	public void sortByDate(ActionEvent actionEvent){
		//Check if race list is greater than 2. If not, display massage to simulate race at least 2 times.
		if (racelist.size()<2){
			displayMsg3("Please add at least 2 race to run this option.", false);
			return;
		}

		//Clear the previous list and add race list to sortbydate list.
		sortbyDate.clear();
		sortbyDate.addAll(racelist);

		//Sorting date using bubble sort.
		for (int i = 1; i < sortbyDate.size(); i++) {
			RaceDetails key = sortbyDate.get(i);
			int j = i - 1;
			while (j >= 0 && sortbyDate.get(j).getDate().isAfter(key.getDate())) {
				sortbyDate.set(j + 1, sortbyDate.get(j));
				j = j - 1;
			}
			sortbyDate.set(j + 1, key);
		}
		displayMsg3("Done!",true);

		//Set sorted list to VRL Table.
		VRLTable.setItems(sortbyDate);
	}

	//https://stackoverflow.com/questions/11496700/how-to-use-printwriter-and-file-classes-in-java
	//https://stackoverflow.com/questions/55963792/using-printwriter-to-create-a-text-file-with-several-rows-from-a-list
	@FXML
	public void SaveData(ActionEvent actionEvent){
		//Checking if data-list is empty. If empty, display an error message.
		if (dataList.isEmpty()) {
			displayMsg1("There is no Driver Details to save.", false);
			return;
		}

		//Asking user for file to save data.
		File file = fileChooser.showSaveDialog(NameField.getScene().getWindow());
		if (file!=null) {
			try {
				//Writing data to file using the print writer.
				PrintWriter printWriter = new PrintWriter(new PrintWriter(file));
				for (DriverDetails driverDetails:dataList) {
					printWriter.write(driverDetails.getName() + "," + driverDetails.getAge() + "," + driverDetails.getTeam() + "," + driverDetails.getCar() + "," + driverDetails.getCurrentPoints() + "\n");
				}
				printWriter.close();
				displayMsg1("Drivers data has been saved", true);

			//If there is an error, display the error message
			} catch (Exception e) {
				displayMsg1("Error saving drivers data to file.", false);
			}
		}
	}

	//https://www.w3schools.com/java/java_files_read.asp
	//https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
	@FXML
	public void LoadData(ActionEvent actionEvent) {
		//Asking user for file to load data.
		File file = fileChooser.showOpenDialog(null);
		if (file != null) {
			try {
				//Reading the file
				Scanner scanner = new Scanner(file);

				//Reading data line by line.
				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();

					//If line data splits by ',' and split length is 5, then continue.
					String[] split = line.split(",");
					if (split.length != 5) {
						continue;
					}

					//Checking id the Driver is already exist in the List.
					String name = split[0].trim();
					if (DriverDuplicateCheck2(name)) {
						displayMsg1("Duplicate name found: " + name, false);
						continue;
					}
					int age = Integer.parseInt(split[1].trim());
					String team = split[2].trim();
					String car = split[3].trim();
					int currentPoints = Integer.parseInt(split[4].trim());

					//Creating new object in Driver data and adding it to the list.
					DriverDetails driverDetails = new DriverDetails(name, age, team, car, currentPoints);
					dataList.add(driverDetails);
				}
				displayMsg1("Data loaded successfully.", true);
				DetailsTable.setItems(dataList);

			//If file cannot be found, display an error message.
			} catch (FileNotFoundException e) {
				displayMsg1("File not found.", false);

			//If there is error in data in the file, display error message.
			} catch (NumberFormatException e) {
				displayMsg1("Invalid data format.", false);
			}
		}
	}

	// Check if the driver already exists in the list
	private boolean DriverDuplicateCheck2(String name) {
		for (DriverDetails driver : dataList) {
			if (driver.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}


	@FXML
	public void ClearAll(ActionEvent actionEvent) {
		//Checking if data-list is empty. If empty, display an error message.
		if (dataList.isEmpty()) {
			displayMsg1("There is no data to clear.", false);
			return;
		}

		// If user pressed the button, ask the user to confirm with an alert.
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Clear Data");
		alert.setHeaderText("Are you sure you want to clear all data?");
		alert.setContentText("This action cannot be undone.");
		Optional<ButtonType> result = alert.showAndWait();

		//If user pressed OK , clear the list and the table.
		if (result.get() == ButtonType.OK) {
			dataList.clear();
			DetailsTable.getItems().clear();
		}
	}

	@FXML
	public void VrlClearAll(ActionEvent actionEvent) throws FileNotFoundException {
		//Checking if race-list is empty. If empty, display an error message.
		if (racelist.isEmpty()) {
			displayMsg3("There is no data to clear.", false);
			return;
		}

		// If user pressed the button, ask the user to confirm with an alert.
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Clear Data");
		alert.setHeaderText("Are you sure you want to clear all data?");
		alert.setContentText("This action cannot be undone.");
		Optional<ButtonType> result = alert.showAndWait();

		//If user pressed OK , clear the list and the file.
		if (result.get() == ButtonType.OK) {
			File file = new File("src\\main\\resources\\com\\example\\cw1601java\\Race.txt");
			PrintWriter printWriter = new PrintWriter(new PrintWriter(file));
			printWriter.write("");
			printWriter.flush();
			printWriter.close();
			File file2 = new File("src\\main\\resources\\com\\example\\cw1601java\\FullData.txt");
			PrintWriter printWriter2 = new PrintWriter(new PrintWriter(file2));
			printWriter2.write("");
			printWriter2.flush();
			printWriter2.close();
			racelist.clear();
			SRRTable.getItems().clear();
			VRLTable.getItems().clear();
			FullDetails.clear();
			FDTable.getItems().clear();
		}
	}

	@FXML
	public void fillFields(MouseEvent event) {
		//Get the selection from table and fill that data to text fields.
		DriverDetails selected = DetailsTable.getSelectionModel().getSelectedItem();
		if (selected != null) {
			NameField.setText(selected.getName());
			AgeField.setText(String.format("%d", selected.getAge()));
			TeamField.setText(selected.getTeam());
			CarField.setText(selected.getCar());
			CurrentPointsField.setText(String.format("%d", selected.getCurrentPoints()));
		}else {
			NameField.clear();
			AgeField.clear();
			TeamField.clear();
			CarField.clear();
			CurrentPointsField.clear();
		}
	}

	@FXML
	public void cleardata(ActionEvent actionEvent){
		//Clear the text fields.
		NameField.clear();
		AgeField.clear();
		TeamField.clear();
		CarField.clear();
		CurrentPointsField.clear();
	}

	@FXML
	public void keyset(KeyEvent keyEvent){
		//If user pressed a key on keyboard, calling the search method.
		search();
	}

	//https://www.youtube.com/watch?v=FeTrcNBVWtg&t=2s
	private void search() {
		//Searching the name on list that typed on text field
		SearchField.setOnKeyReleased(e->{
			SearchField.textProperty().addListener((observable, oldValue, newValue) -> {
				fData.setPredicate((Predicate<? super DriverDetails >) data->{
					if(newValue==null){
						return true;
					}
					String toLowerCaseFilter = newValue.toLowerCase();
					if(data.getName().toLowerCase().contains(toLowerCaseFilter)){
						return true;
					}
					return false;
				});
			});
			final SortedList<DriverDetails> driverDetails = new SortedList<>(fData);
			driverDetails.comparatorProperty().bind(DetailsTable.comparatorProperty());
			DetailsTable.setItems(driverDetails);
		});

	}

	@FXML
	public void keyset1(KeyEvent keyEvent){
		//If user pressed a key on keyboard, calling the search method.
		search2();
	}

	//https://www.youtube.com/watch?v=FeTrcNBVWtg&t=2s
	private void search2() {
		//Searching the name on list that typed on text field
		SearchField1.setOnKeyReleased(e->{
			SearchField1.textProperty().addListener((observable, oldValue, newValue) -> {
				fData.setPredicate((Predicate<? super DriverDetails >) data->{
					if(newValue==null){
						return true;
					}
					String toLowerCaseFilter = newValue.toLowerCase();
					if(data.getName().toLowerCase().contains(toLowerCaseFilter)){
						return true;
					}
					return false;
				});
			});

			final SortedList<DriverDetails> driverDetails = new SortedList<>(fData);
			driverDetails.comparatorProperty().bind(DetailsTable2.comparatorProperty());
			DetailsTable2.setItems(driverDetails);
		});

	}

	@FXML
	public void keyset2(KeyEvent keyEvent){
		//If user pressed a key on keyboard, calling the search method.
		search3();
	}

	//https://www.youtube.com/watch?v=FeTrcNBVWtg&t=2s
	private void search3() {
		//Searching the name on list that typed on text field
		SearchField2.setOnKeyReleased(e->{
			SearchField2.textProperty().addListener((observable, oldValue, newValue) -> {
				fData.setPredicate((Predicate<? super DriverDetails >) data->{
					if(newValue==null){
						return true;
					}
					String toLowerCaseFilter = newValue.toLowerCase();
					if(data.getName().toLowerCase().contains(toLowerCaseFilter)){
						return true;
					}
					return false;
				});
			});

			final SortedList<DriverDetails> driverDetails = new SortedList<>(fData);
			driverDetails.comparatorProperty().bind(DetailsTable3.comparatorProperty());
			DetailsTable3.setItems(driverDetails);
		});

	}

	//https://www.youtube.com/watch?v=jm_gVp12h0s&t=2727s
	private void displayMsg(String msg, boolean correct) {
		//Set massage label to display a massage.
		msgLabel.setText(msg);

		//Set text alignment to center.
		msgLabel.setAlignment(Pos.CENTER);
		if(correct){
			msgLabel.setTextFill(Color.GREEN);
		}else {
			msgLabel.setTextFill(Color.RED);
		}
		if (timeline != null) {
			timeline.stop();
		}

		//Adding a timer to massage. Massage will only display 5 seconds.
		timeline = new Timeline(new KeyFrame(Duration.millis(5000), event -> {
			msgLabel.setText("");
			msgLabel.setTextFill(Color.BLACK);
		}));
		timeline.play();
	}

	//https://www.youtube.com/watch?v=jm_gVp12h0s&t=2727s
	private void displayMsg1(String msg1, boolean correct1) {
		//Set massage label to display a massage.
		msgLabel1.setText(msg1);

		//Set text alignment to center.
		msgLabel1.setAlignment(Pos.CENTER);
		if(correct1){
			msgLabel1.setTextFill(Color.GREEN);
		}else {
			msgLabel1.setTextFill(Color.RED);
		}
		if (timeline != null) {
			timeline.stop();
		}

		//Adding a timer to massage. Massage will only display 5 seconds.
		timeline = new Timeline(new KeyFrame(Duration.millis(5000), event -> {
			msgLabel1.setText("");
			msgLabel1.setTextFill(Color.BLACK);
		}));
		timeline.play();
	}

	//https://www.youtube.com/watch?v=jm_gVp12h0s&t=2727s
	private void displayMsg2(String msg, boolean correct) {
		//Set massage label to display a massage.
		srrLabel.setText(msg);

		//Set text alignment to center.
		srrLabel.setAlignment(Pos.CENTER);
		if(correct){
			srrLabel.setTextFill(Color.GREEN);
		}else {
			srrLabel.setTextFill(Color.RED);
		}
		if (timeline != null) {
			timeline.stop();
		}

		//Adding a timer to massage. Massage will only display 5 seconds.
		timeline = new Timeline(new KeyFrame(Duration.millis(5000), event -> {
			srrLabel.setText("");
			srrLabel.setTextFill(Color.BLACK);
		}));
		timeline.play();
	}

	//https://www.youtube.com/watch?v=jm_gVp12h0s&t=2727s
	private void displayMsg4(String msg, boolean correct) {
		//Set massage label to display a massage.
		msgLabel3.setText(msg);

		//Set text alignment to center.
		msgLabel3.setAlignment(Pos.CENTER);
		if(correct){
			msgLabel3.setTextFill(Color.GREEN);
		}else {
			msgLabel3.setTextFill(Color.RED);
		}
		if (timeline != null) {
			timeline.stop();
		}

		//Adding a timer to massage. Massage will only display 5 seconds.
		timeline = new Timeline(new KeyFrame(Duration.millis(5000), event -> {
			msgLabel3.setText("");
			msgLabel3.setTextFill(Color.BLACK);
		}));
		timeline.play();
	}

	//https://www.youtube.com/watch?v=jm_gVp12h0s&t=2727s
	private void displayMsg3(String msg, boolean correct) {
		//Set massage label to display a massage.
		msgLabel2.setText(msg);

		//Set text alignment to center.
		msgLabel2.setAlignment(Pos.CENTER);
		if(correct){
			msgLabel2.setTextFill(Color.GREEN);
		}else {
			msgLabel2.setTextFill(Color.RED);
		}
		if (timeline != null) {
			timeline.stop();
		}

		//Adding a timer to massage. Massage will only display 5 seconds.
		timeline = new Timeline(new KeyFrame(Duration.millis(5000), event -> {
			msgLabel2.setText("");
			msgLabel2.setTextFill(Color.BLACK);
		}));
		timeline.play();
	}

	//https://www.youtube.com/watch?v=VOiFmZyGAps&t=12s
	//Method to handle clicks on the application.
	@FXML
	public void handleClicks(ActionEvent actionEvent) {
		//if user clicked Driver management button, Driver management pane will be shown.
		if (actionEvent.getSource() == btnDriverManagement) {
			pneDriverManagement.toFront();
		}

		//if user clicked View Standings button, View Standings pane will be shown.
		if (actionEvent.getSource() == btnViewStandings) {
			pneViewStandings.toFront();
		}

		//if user clicked Simulate Race button, Simulate race pane will be shown.
		if (actionEvent.getSource() == btnSimulateRace) {
			pneSimulateRace.toFront();
		}

		//if user clicked Sort By Date button, Sort By Date pane will be shown.
		if (actionEvent.getSource() == btnSortByDate) {
			pneSortbyDate.toFront();
		}

		//if user clicked Data management button, Data management pane will be shown.
		if (actionEvent.getSource() == btnDataManagement) {
			pneDataManagement.toFront();
		}

		//if user clicked Dashboard button, Dashboard pane will be shown.
		if (actionEvent.getSource() == btnDashboard) {
			pneDashboard.toFront();
		}

		//if user clicked Driver management button in the dashboard, Driver management pane will be shown.
		if (actionEvent.getSource() == DashDriverManagement) {
			pneDriverManagement.toFront();
		}

		//if user clicked View Standings button in the dashboard, View Standings pane will be shown.
		if (actionEvent.getSource() == DashViewStandings) {
			pneViewStandings.toFront();
		}

		//if user clicked Simulate Race button in the dashboard, Simulate Race pane will be shown.
		if (actionEvent.getSource() == DashSimulateRace) {
			pneSimulateRace.toFront();
		}

		//if user clicked Sort By Date button in the dashboard, Sort By Date pane will be shown.
		if (actionEvent.getSource() == DashSortByDate) {
			pneSortbyDate.toFront();
		}

		//if user clicked Data management button in the dashboard, Data management pane will be shown.
		if (actionEvent.getSource() == DashDataManagement) {
			pneDataManagement.toFront();
		}
		if (actionEvent.getSource() == backBtn) {
			pneSimulateRace.toFront();
		}
	}

	@FXML
	public void close(ActionEvent actionEvent) {
		// If user clicked Exit button, ask the user to confirm with an alert.
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Exit");
		alert.setHeaderText("Are you sure you want to exit?");
		alert.setContentText("This action cannot be undone.");
		Optional<ButtonType> result = alert.showAndWait();

		//If user pressed OK, program will exit.
		if (result.get() == ButtonType.OK) {
			System.exit(0);
		}

	}
}