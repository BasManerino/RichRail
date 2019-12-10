package parser.controller;

import java.util.List;

import abstract_classes.Locomotive;
import abstract_classes.TrainComponent;
import parser.RichRailCli;
import parser.RichRailParser;
import repository_iterator.Iterator;

public class AddCommand {
	
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
