package parser.controller;

import java.util.List;

import abstract_classes.Locomotive;
import abstract_classes.Wagon;
import abstract_classes.TrainComponent;
import parser.RichRailCli;
import parser.RichRailParser;
import repository_iterator.Iterator;

//This class represent the add command.
//Its responsibility is to add existing wagons to existing locomotives.
public class AddCommand {
	
	RichRailCli cli = new RichRailCli();
	
	public String execute(String wagonid, String locoid) {     
        //check if the locomotive exists
        for (Iterator iter = cli.allLocomotives.getIterator(); iter.hasNext();) {
        	TrainComponent locomotive = iter.next();
        	if(locomotive.getId().equals(locoid)){
        		//check if the wagon exists
        		for (Iterator iter2 = cli.allWagons.getIterator(); iter2.hasNext();) {
        			TrainComponent wagon = iter2.next();
        			if(wagon.getId().equals(wagonid)) {
        				//check if the wagon is not already attached to a locomotive
        				if(((Wagon) wagon).isAttached() == false){
            				//attach the wagon to the locomotive
            				((Locomotive) locomotive).addComponent(wagon);
            				((Wagon) wagon).setAttached(true);
            				//update the source file and view
        				    cli.observer.setLocomotives(cli.repo, cli.allLocomotives, cli.persister);
        				    System.out.println("Wagon with id " + wagonid + " has been added to train with id " + locoid + ".");
            		        return("Wagon with id " + wagonid + " has been added to train with id " + locoid + ".");
        				}
        				else {
        				    System.out.println("This wagon is already attached to a train.");
            		        return("This wagon is already attached to a train.");
        				}

        			}
        		}
			    System.out.println("This wagon does not exist.");
               	return("This wagon does not exist.");
        	}
        }
	    System.out.println("This train does not exist.");
        return("This train does not exist.");
    }
}
