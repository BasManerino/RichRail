package app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import parser.RichRailCli;
import parser.RichRailParser;
import repository_iterator.Iterator;

import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import abstract_classes.Locomotive;
import abstract_classes.TrainComponent;
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
		
		public void execute(RichRailParser.AddcommandContext ctx) {
			String wagonid = ctx.ID().get(0).getText();
	        String locoid = ctx.ID().get(1).getText();
	        
	        for (Iterator iter = cli.allLocomotives.getIterator(); iter.hasNext();) {
	        	TrainComponent locomotive = iter.next();
	        	if(locomotive.getId().equals(locoid)){
	        		for (Iterator iter2 = cli.allWagons.getIterator(); iter2.hasNext();) {
	        			TrainComponent wagon = iter2.next();
	        			if(wagon.getId().equals(wagonid)) {
	        				List<TrainComponent> components = ((Locomotive) locomotive).getComponentList();
	        				for(TrainComponent wagono : components){
	        					System.out.println(wagono.getId());
	        				}
	        				for(TrainComponent wagono2 : components){
	        					if(wagono2.getId().equals(wagonid)) {
	        						System.out.println("This wagon is already attached to this train.");
	        						return;
	        					}
	        				}
	        				((Locomotive) locomotive).addComponent(wagon);
	        				    cli.observer.setLocomotives(cli.repo, cli.allLocomotives, cli.persister);
	            		        System.out.println("Wagon with id " + wagonid + " has been added to train with id " + locoid + ".");
	            				return;
	        			}
	        		}
	               	System.out.println("This wagon does not exist.");
	            	return;
	        	}
	        }
	        System.out.println("This train does not exist.");
	        return;
	    }
	}
