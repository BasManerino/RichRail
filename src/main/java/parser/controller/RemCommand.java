package parser.controller;

import abstract_classes.Locomotive;
import abstract_classes.Wagon;
import abstract_classes.TrainComponent;
import parser.RichRailCli;
import parser.RichRailParser;
import repository_iterator.Iterator;

public class RemCommand {
	
	RichRailCli cli = new RichRailCli();
	
	public void execute(RichRailParser.RemcommandContext ctx) {
		String wagonid = ctx.ID().get(0).getText();
        String locoid = ctx.ID().get(1).getText();
        
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
                				return;
        					}
        				}
        				System.out.println("This wagon is not attached to this train.");
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
