package model;

import java.util.ArrayList;
import java.util.List;

import abstract_classes.Locomotive;
import abstract_classes.TrainComponent;

public class PlainLocomotive extends Locomotive{

	private static final long serialVersionUID = 1L;
	public List<TrainComponent> wagonList = new ArrayList<TrainComponent>();
	public PlainLocomotive(String id, int numseats, float maxweight) {
		super(id, numseats, maxweight);
		this.wagonList = new ArrayList<TrainComponent>();
	}
}
