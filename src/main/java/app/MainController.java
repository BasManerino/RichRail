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
import parser.controller.*;
import repository_iterator.Iterator;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;

import com.ibm.icu.text.SimpleDateFormat;

import abstract_classes.Locomotive;
import abstract_classes.TrainComponent;
import abstract_classes.Wagon; 

public class MainController implements Initializable, Command{
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		updateView();
	}
	
	@FXML
	public Button executebtn;
	@FXML
	public Button trainbtn;
	@FXML
	public Button wagonbtn;
	@FXML
	public Button logger;
	@FXML
	public TextField id;
	@FXML
	public TextField numseats;
	@FXML
	public TextField maxweight;
	@FXML
	public TextField idwagon;
	@FXML
	public TextField command;
	@FXML
	public TextField numseatswagon;
	@FXML
	public TextField maxweightwagon;
	@FXML
	public TextArea commandview;
	@FXML
	public TextArea commandview2;
	@FXML
	public TextArea trainview;
	
	public void getTrainFields (ActionEvent event) {
		System.out.println(id.getText() + " " + numseats.getText() + " " + maxweight.getText());
		int numseats2 = 0;
		float maxweight2 = 0;
		
		try {
			numseats2 = Integer.parseInt(numseats.getText());
		}
		
		catch(NumberFormatException e) {
			numseats2 = 0;
		}
		
		try {
			maxweight2 = Float.parseFloat(maxweight.getText());
		}
		
		catch(NumberFormatException e) {
			maxweight2 = 0;
		}
		
		NewCommand command = new NewCommand();
		command.execute(id.getText(), numseats2, maxweight2, "train");
		commandview2.appendText(command.getFinalMessage());
		commandview2.appendText("\n");
	}
	
	public void getWagonFields (ActionEvent event) {
		System.out.println(id.getText() + " " + numseats.getText() + " " + maxweight.getText());
		int numseats2 = 0;
		float maxweight2 = 0;
		
		try {
			numseats2 = Integer.parseInt(numseatswagon.getText());
		}
		
		catch(NumberFormatException e) {
			numseats2 = 0;
		}
		
		try {
			maxweight2 = Float.parseFloat(maxweightwagon.getText());
		}
		
		catch(NumberFormatException e) {
			maxweight2 = 0;
		}
		
		NewCommand command = new NewCommand();
		command.execute(id.getText(), numseats2, maxweight2, "wagon");
		commandview2.appendText(command.getFinalMessage());
		commandview2.appendText("\n");
	}
	
	public void execute(ActionEvent event) {
		CLI cli = new CLI();
		commandview.appendText(command.getText());
		commandview.appendText("\n");
		commandview2.appendText(cli.bootUp(command.getText()));
		commandview2.appendText("\n");
		trainview.clear();
		updateView();
	}
	
	public void logToFile(ActionEvent event) throws IOException {
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss'.txt'").format(new Date());
		PrintWriter writer = new PrintWriter("log_"+fileName, "UTF-8");
		writer.write(commandview2.getText());
		writer.close();
	}
	
	public void updateView() {
	    RichRailCli cli = new RichRailCli();
		String viewText = "";
		//write the locomotives and their attached wagons to the screen
        for (Iterator iter = cli.allLocomotives.getIterator(); iter.hasNext();) {
        	TrainComponent locomotive = iter.next();
        	viewText = "(<" + locomotive.getClass().getSimpleName() + ">" + locomotive.getId() + ")";
			for(TrainComponent wagon : ((Locomotive) locomotive).getComponentList()){
				viewText = viewText + "-----" + "(<" + wagon.getClass().getSimpleName() + ">" + wagon.getId() + ")";
			}
			trainview.appendText(viewText);
			trainview.appendText("\n");
        }
        //write the remaining loose wagons to the screen
        trainview.appendText("\n");
  		for (Iterator iter2 = cli.allWagons.getIterator(); iter2.hasNext();) {
			TrainComponent wagon = iter2.next();
			if(((Wagon) wagon).isAttached() == false){
				trainview.appendText("(<" + wagon.getClass().getSimpleName() + ">" + wagon.getId() + "), ");
			}
	    }
    }
}
