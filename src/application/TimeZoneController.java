package application;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.TimeZone;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class TimeZoneController implements Initializable {
	@FXML
	private Label localTimeLabel;
	
	@FXML
	private Label resultTimeLabel;
	
	@FXML
	private ComboBox <String> countriesComboBox;
	ObservableList<String> 
	listOfCountries=FXCollections.observableArrayList("Australia","Algeria","Brazil","China","Denmark","Egypt","France","Greenland","Honduras",
			"Italy","India","Japan","Kuwait","Mexico","Nigeria","Russia","South Africa","Sweden","Thailand","Yemen","Zimbabwe");
	
	// Constructors
	private SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss a");
	private Date localDate = new Date();
	private Date resultDate;
	private String dateToString = dateFormatter.format(localDate);
	

	@FXML
	// Calls FxmlLoader Class to create new instance of scene and set scene
	public void goBackButton(ActionEvent event) throws IOException {
		FxmlLoader calender = new FxmlLoader("CalenderView");
		calender.setScene("CalenderView", event);
		
 
	}
	@FXML
	
	void getTimeZoneButton (ActionEvent event){
		// user chooses value, TimeZone ID stored as String 
		String pickedTimeZone = countriesComboBox.getValue();
		String timeZone = getSelectedTimeZone(pickedTimeZone);
		
		// gets the timezone for the given ID and sets it
		TimeZone tzTimeZone = TimeZone.getTimeZone(timeZone);
	    dateFormatter.setTimeZone(tzTimeZone);
	    
	    // Stores the date as a String
	    String stringResultTimeZone = dateFormatter.format(resultDate);
	    
	    // Creates new null date 
	    Date resultTimeZone = null;
		try {
			// Converts String to Date object
			resultTimeZone = dateFormatter.parse(stringResultTimeZone);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// sets the resulting timezone label
	    resultTimeLabel.setText(dateFormatter.format(resultTimeZone));
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Initializes our FXML ComboBox
		countriesComboBox.setItems(listOfCountries);
		try {
			resultDate = dateFormatter.parse(dateToString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// sets the label with the local machine date/time
		localTimeLabel.setText(dateFormatter.format(localDate));
	}
	
	/**
	 * This method takes a list as cases 
	 * @param selectedTimeZone : user picks this from ComboBox
	 * @return the corresponding timeZone ID given by the users case
	 * @author ubaidullah.niaz
	 */
	public String getSelectedTimeZone(String selectedTimeZone) {
		switch (selectedTimeZone) {
		case "Australia":	
			return "Australia/Canberra";
		case "Algeria":	
			return "Africa/Algiers";
		case "Brazil":	
			return "America/Sao_Paulo";
		case "China":	
			return "Asia/Shanghai";
		case "Denmark":	
			return "Europe/Copenhagen";
		case "Egypt":	
			return "Africa/Cairo";
		case "France":	
			return "Europe/Paris";
		case "Greenland":	
			return "America/Godthab";
		case "Honduras":	       
			return "America/Tegucigalpa";
		case "Italy":	
			return "Europe/Rome";
		case "India":	
			return "Asia/Kolkata";
		case "Japan":	
			return "Asia/Tokyo";
		case "Kuwait":	
			return "Asia/Kuwait";
		case "Mexico":	
			return "America/Mexico_City";
		case "Nigeria":	
			return "Africa/Lagos";
		case "Russia":	
			return "Europe/Moscow";
		case "South Africa":	
			return "Africa/Johannesburg";
		case "Sweden":	
			return "Europe/Stockholm";
		case "Thailand":	
			return "Asia/Bangkok";
		case "Yemen":	
			return "Asia/Aden";
		case "Zimbabwe":	
			return "Africa/Harare";
		default:
			
		}
		return "America/Edmonton";
	}
}

