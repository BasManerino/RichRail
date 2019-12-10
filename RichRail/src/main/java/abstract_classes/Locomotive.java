package abstract_classes;

import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;

public abstract class Locomotive implements TrainComponent, Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private int numseats;
	private float maxweight;
	
	private List<TrainComponent> wagonList;
	
	public Locomotive(String id) {
		this.id = id;
		this.wagonList = new ArrayList<TrainComponent>();
	}
	
	public Locomotive(String id, int numseats, float maxweight) {
		this.id = id;
		this.numseats = numseats;
		this.maxweight = maxweight;
		this.wagonList = new ArrayList<TrainComponent>();
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public int getNumseats() {
		return numseats;
	}

	public float getMaxweight() {
		return maxweight;
	}

	public void setNumseats(int numseats) {
		this.numseats = numseats;
	}

	public void setMaxweight(float maxWeight) {
		this.maxweight = maxWeight;
	}
	
	public List<TrainComponent> getComponentList() {
		return wagonList;
	}

	public void setComponentList(ArrayList<TrainComponent> wagonList) {
		this.wagonList = wagonList;
	}

	public int getComponentCount() {
		return wagonList.size();
	}

	public void addComponent(TrainComponent wagon) {
		this.wagonList.add(wagon);
	}
	
	public void removeComponent(TrainComponent wagon) {
		this.wagonList.remove(wagon);
	}
	
	public void clearComponentList() {
		this.wagonList.clear();
	}
}