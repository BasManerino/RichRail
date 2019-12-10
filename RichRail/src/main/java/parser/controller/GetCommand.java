package parser.controller;

import abstract_classes.TrainComponent;
import parser.RichRailCli;
import parser.RichRailParser;
import repository_iterator.Iterator;

public class GetCommand {
	
	RichRailCli cli = new RichRailCli();
	
	public void execute(RichRailParser.GetcommandContext ctx) {
		String id = ctx.ID().toString();
    	String type = ctx.type().getText();
    	String option = ctx.option().getText();
    	
    	switch(type) {
    	  case "train":
    	        for (Iterator iter = cli.allLocomotives.getIterator(); iter.hasNext();) {
    	        	TrainComponent locomotive = iter.next();
	            	if(locomotive.getId().equals(id)) {
	            		switch(option) {
	            		case "numseats":
    	            		System.out.println("Locomotive with id " + id + " has " + locomotive.getNumseats() + " seats.");
    	            		return;
	            		case "maxweight":
    	            		System.out.println("Locomotive with id " + id + " is allowed a maximum of " + locomotive.getMaxweight() + " kilograms of cargo.");
    	            		return;
    	            	default:
    	            		System.out.println(option + " is not a valid option");
    	            		return;
	            		}
	            	}
	            }  
    	  case "wagon":
      		for (Iterator iter2 = cli.allWagons.getIterator(); iter2.hasNext();) {
    			TrainComponent wagon = iter2.next();
	            	if(wagon.getId().equals(id)) {
	            		switch(option) {
	            		case "numseats":
    	            		System.out.println("Wagon with id " + id + " has " + wagon.getNumseats() + " seats.");
    	            		return;
	            		case "maxweight":
    	            		System.out.println("Wagon with id " + id + " is allowed a maximum of " + wagon.getMaxweight() + " kilograms of cargo.");
    	            		return;
    	            	default:
    	            		System.out.println(option + " is not a valid option.");
    	            		return;
	            		}
	            	}
	            }  
    	  default: 
    	    System.out.println(type + " is not a valid train component.");
    	    return;
    	}
    }
}
