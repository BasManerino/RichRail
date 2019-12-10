package parser;

import java.io.IOException;

import adapter_observer.PersistenceAdapter;
import adapter_observer.Observer;
import parser.RichRailBaseListener;
import parser.RichRailParser;
import repository_iterator.LocomotiveRepository;
import repository_iterator.RepositoryManager;
import repository_iterator.WagonRepository;
import parser.controller.*;

public class RichRailCli extends RichRailBaseListener {
	
	public PersistenceAdapter persister = new PersistenceAdapter();
	public Observer observer = new Observer();
	public RepositoryManager repo = new RepositoryManager(); {
	
		try{
			 repo = persister.loadData();
		}
		catch(IOException | ClassNotFoundException e)
		{
			System.out.println("No data has been found yet. This is perfectly normal if you're using this software for the first time, a new instance shall now be created.");
		}
	}
	
    public LocomotiveRepository allLocomotives = repo.getLocomotives();
    public WagonRepository allWagons = repo.getWagons();
  
    @Override
    public void enterNewcommand(RichRailParser.NewcommandContext ctx) {
        NewCommand command = new NewCommand();
        command.execute(ctx);
    }
    
    public void enterAddcommand(RichRailParser.AddcommandContext ctx) {
        AddCommand command = new AddCommand();
        command.execute(ctx);
    }
    
    public void enterGetcommand(RichRailParser.GetcommandContext ctx) {
        GetCommand command = new GetCommand();
        command.execute(ctx);
    }
    
    public void enterDelcommand(RichRailParser.DelcommandContext ctx) {
        DelCommand command = new DelCommand();
        command.execute(ctx);
    }
    
    public void enterRemcommand(RichRailParser.RemcommandContext ctx) {
        RemCommand command = new RemCommand();
        command.execute(ctx);
    }
}
