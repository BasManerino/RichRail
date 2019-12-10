package parser.controller;

import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;

import abstract_classes.Locomotive;
import abstract_classes.TrainComponent;
import abstract_classes.Wagon;
import factory.LocomotiveBasedTrainFactory;
import factory.TrainFactory;
import factory.WagonBasedTrainFactory;
import parser.RichRailCli;
import parser.RichRailParser;
import repository_iterator.Iterator;

public class NewCommand {
	
	RichRailCli cli = new RichRailCli();
	
	public void execute(RichRailParser.NewcommandContext ctx) {
        String id = ctx.ID().getText();
        
        int numseats = 0;
        float maxweight = 0;
        
        List<TerminalNode> options = ctx.NUMBER();
        if(!options.isEmpty()) {
	        numseats = Integer.parseInt(options.get(0).toString());
	        maxweight = Float.parseFloat(options.get(1).toString());
        }
        
        if(ctx.type().getText().equals("train"))
        {
        	for (Iterator iter = cli.allLocomotives.getIterator(); iter.hasNext();) {
        		TrainComponent loco = iter.next();
            	if(loco.getId().equals(id)) {
            		System.out.println("There already exists a train with this name, please choose another one.");
            		return;
            	}
            }

        	TrainFactory factory = new LocomotiveBasedTrainFactory(id, numseats, maxweight);
     
            Locomotive loco = (Locomotive) factory.createTrainComponent();
            
            cli.allLocomotives.add(loco);
            
            for (Iterator iter = cli.allLocomotives.getIterator(); iter.hasNext();) {
            	String locoid = iter.next().getId();
            	System.out.println(locoid);
            }
            
            cli.observer.setLocomotives(cli.repo, cli.allLocomotives, cli.persister);
    	        System.out.println("Train with id " + loco.getId() + " has been created.");
    	        return;
        }
        
        else if(ctx.type().getText().equals("wagon")) 
        {
        	for (Iterator iter = cli.allWagons.getIterator(); iter.hasNext();) {
        		String wagonid = iter.next().getId();
        		if(wagonid.equals(id)) {
            		System.out.println("There already exists a wagon with this name, please choose another one.");
            		return;
            	}
            }
            
        	TrainFactory factory = new WagonBasedTrainFactory(id, numseats, maxweight);
     
            Wagon wagon = (Wagon) factory.createTrainComponent();
            
            cli.allWagons.add(wagon);
            
            for (Iterator iter = cli.allWagons.getIterator(); iter.hasNext();) {
            	String wagonid = iter.next().getId();
            	System.out.println(wagonid);
            }
            
            cli.observer.setWagons(cli.repo, cli.allWagons, cli.persister);
    	        System.out.println("Wagon with name " + wagon.getId() + " has been created.");
    	        return;
        }
    }
}
