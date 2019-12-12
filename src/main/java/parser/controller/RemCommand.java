package parser.controller;

import abstract_classes.Locomotive;
import abstract_classes.Wagon;
import abstract_classes.TrainComponent;
import parser.RichRailCli;
import parser.RichRailParser;
import repository_iterator.Iterator;

public class RemCommand {
	
	RichRailCli cli = new RichRailCli();
	
	public String execute(String wagonid, String locoid) {
        for (Iterator iter = cli.allLocomotives.getIterator(); iter.hasNext();) {
        	TrainComponent locomotive = iter.next();
        	if(locomotive.getId().equals(locoid)){
          		for (Iterator iter2 = cli.allWagons.getIterator(); iter2.hasNext();) {
        			TrainComponent wagon = iter2.next();
        			if(wagon.getId().equals(wagonid)) {
        				//check if this wagon is attached to this train
        				for(TrainComponent wagono : ((Locomotive) locomotive).getComponentList()){
        					if(wagono.getId().equals(wagonid)) {
                				((Locomotive) locomotive).removeComponent(wagono);
                				((Wagon) wagon).setAttached(false);
            					cli.observer.setLocomotives(cli.repo, cli.allLocomotives, cli.persister);
            				    System.out.println("Wagon with id " + wagonid + " has been removed from train with id " + locoid + ".");
                		        return("Wagon with id " + wagonid + " has been removed from train with id " + locoid + ".");
        					}
        				}
    				    System.out.println("This wagon is not attached to this train.");
        				return("This wagon is not attached to this train.");
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
