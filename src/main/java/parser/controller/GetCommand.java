package parser.controller;

import abstract_classes.TrainComponent;
import parser.RichRailCli;
import parser.RichRailParser;
import repository_iterator.Iterator;

public class GetCommand {
	
	RichRailCli cli = new RichRailCli();
	
	public String execute(String id, String type, String option) {	
    	switch(type) {
    	  case "train":
    	        for (Iterator iter = cli.allLocomotives.getIterator(); iter.hasNext();) {
    	        	TrainComponent locomotive = iter.next();
	            	if(locomotive.getId().equals(id)) {
	            		switch(option) {
	            		//check what the user asked for
	            		case "numseats":
        				    System.out.println("Locomotive with id " + id + " has " + locomotive.getNumseats() + " seats.");
    	            		return("Locomotive with id " + id + " has " + locomotive.getNumseats() + " seats.");
	            		case "maxweight":
        				    System.out.println("Locomotive with id " + id + " is allowed a maximum of " + locomotive.getMaxweight() + " kilograms of cargo.");
    	            		return("Locomotive with id " + id + " is allowed a maximum of " + locomotive.getMaxweight() + " kilograms of cargo.");
    	            	default:
        				    System.out.println(option + " is not a valid option");
    	            		return(option + " is not a valid option");
	            		}
	            	}
	            }
			    System.out.println("This train does not exist.");
        		return("This train does not exist.");
    	  case "wagon":
      		for (Iterator iter2 = cli.allWagons.getIterator(); iter2.hasNext();) {
    			TrainComponent wagon = iter2.next();
	            	if(wagon.getId().equals(id)) {
	            		switch(option) {
	            		case "numseats":
        				    System.out.println("Wagon with id " + id + " has " + wagon.getNumseats() + " seats.");
    	            		return("Wagon with id " + id + " has " + wagon.getNumseats() + " seats.");
	            		case "maxweight":
        				    System.out.println("Wagon with id " + id + " is allowed a maximum of " + wagon.getMaxweight() + " kilograms of cargo.");
    	            		return("Wagon with id " + id + " is allowed a maximum of " + wagon.getMaxweight() + " kilograms of cargo.");
    	            	default:
        				    System.out.println(option + " is not a valid option.");
    	            		return(option + " is not a valid option.");
	            		}
	            	}
	            }
      			System.out.println("This wagon does not exist.");
      			return("This wagon does not exist.");
    	  default: 
			System.out.println("This is not a valid train component.");
    	    return("This is not a valid train component.");
    	}
    }
}
