package parser.controller;

import abstract_classes.Locomotive;
import abstract_classes.TrainComponent;
import parser.RichRailCli;
import parser.RichRailParser;
import repository_iterator.Iterator;

public class DelCommand {
	
	RichRailCli cli = new RichRailCli();
	
	public void execute(RichRailParser.DelcommandContext ctx) {
		String id = ctx.ID().toString();
    	String type = ctx.type().getText();
    	
    	System.out.println(id);
    	System.out.println(type);
    	
    	int cursor = 0;
    	
    	switch(type) {
    	case "train":
	        for (Iterator iter = cli.allLocomotives.getIterator(); iter.hasNext();) {
	        	TrainComponent locomotive = iter.next();
            	if(locomotive.getId().equals(id)) {
            		((Locomotive) locomotive).clearComponentList();
            		cli.allLocomotives.remove(cursor);
            		cli.observer.setLocomotives(cli.repo, cli.allLocomotives, cli.persister);
            		System.out.println("Locomotive with id " + id + " has been succesfully deleted. All its attached wagons are deleted as well.");
            		return;
            	}
            	cursor++;
            }   
		case "wagon":
      		for (Iterator iter2 = cli.allWagons.getIterator(); iter2.hasNext();) {
    			TrainComponent wagon = iter2.next();
		    	if(wagon.getId().equals(id)) {
		    		cli.allWagons.remove(cursor);
		    		cli.observer.setWagons(cli.repo, cli.allWagons, cli.persister);
		    		System.out.println("Wagon with id " + id + " has been succesfully deleted. It shall be detached from its train if it was attached to one.");
		    		return;
		    	}
		    	cursor++;
		    }  
		default:
			System.out.println(type + " is not a valid component.");
			return;
		}
    }
}
