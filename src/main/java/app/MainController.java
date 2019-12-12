package app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import parser.RichRailCli;
import parser.RichRailParser;
import repository_iterator.Iterator;
import parser.controller.*;

import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import abstract_classes.Locomotive;
import abstract_classes.TrainComponent;
import abstract_classes.Wagon;
import factory.LocomotiveBasedTrainFactory;
import factory.TrainFactory;
import factory.WagonBasedTrainFactory;
public class MainController implements Initializable{
	@FXML
	private Label myMessage;
	public void generateRandom(ActionEvent event) {
		Random rand = new Random();
		int myrand = rand.nextInt(50) + 1;
		myMessage.setText(Integer.toString(myrand));
		System.out.println(Integer.toString(myrand));
		
	}
	@FXML
	public Label mylabel;
	@FXML
	public ComboBox<String> comboBox;
	
	ObservableList<String> list = FXCollections.observableArrayList("Mark", "Tom", "John", "Jack");
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		comboBox.setItems(list);
		
	}
	
	public void comboChanged(ActionEvent event) {
		comboBox.getItems().addAll("Ram", "Ben", "Steve", "Ma");
		//mylabel.setText(comboBox.getValue());
	}
	
	RichRailCli cli = new RichRailCli();
	
	@FXML
	Button executebtn;
	@FXML
	Button trainbtn;
	@FXML
	Button wagonbtn;
	@FXML
	public TextField id;
	@FXML
	public TextField numseats;
	@FXML
	public TextField maxweight;
	@FXML
	public TextField idwagon;
	@FXML
	public TextField numseatswagon;
	@FXML
	public TextField maxweightwagon;
	@FXML
	public TextArea commandview;
	@FXML
	public TextArea commandview2;
	

	
	public void getTrainFields (ActionEvent event) {
		id.getText();
		numseats.getText();
		maxweight.getText();
		System.out.println(id.getText() + " " + numseats.getText() + " " + maxweight.getText());
		NewCommand command = new NewCommand();
		command.execute(id.getText(), Integer.parseInt(numseats.getText()),  Float.parseFloat(maxweight.getText()), "train");
	}
	
	public void getWagonFields (ActionEvent event) {
		idwagon.getText();
		numseatswagon.getText();
		maxweightwagon.getText();
		System.out.println(idwagon.getText() + " " + numseatswagon.getText() + " " + maxweightwagon.getText());
		NewCommand command = new NewCommand();
		command.execute(idwagon.getText(), Integer.parseInt(numseatswagon.getText()),  Float.parseFloat(maxweightwagon.getText()), "wagon");
	}
	
	 public void writeToScreen(String text) {
		commandview.setText(text);
		
	}
	
	
	
	}
