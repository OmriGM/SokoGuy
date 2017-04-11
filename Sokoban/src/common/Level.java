package common;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import model.data.GameObject;

public class Level implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int stepCounter=0;
	int boxontarget=0;
	IntegerProperty timeCount=null;
	
	
	GameObject[][]  movAbleTable;
	GameObject[][]  backgroundObjects;
	
	ArrayList<GameObject> boxArray;
	ArrayList<GameObject> characterArray;
	ArrayList<GameObject> wallArray;
	ArrayList<GameObject> floorArray;
	ArrayList<GameObject> targetArray;
public Level() {
	}
	public Level(int rows,int lines) {
		movAbleTable=new GameObject[rows][lines];
		backgroundObjects=new GameObject[rows][lines];
		boxArray=new ArrayList();
		characterArray=new ArrayList();
		wallArray=new ArrayList();
		floorArray=new ArrayList();
		targetArray=new ArrayList();
		timeCount=new SimpleIntegerProperty();
		
		
	}
	public boolean isABox(int i, int j){
		if(movAbleTable[i][j] instanceof Box)
		{	
			return true;
		
		}
		else return false;	
	}
	public boolean isAWall(int i, int j){
		if(backgroundObjects[i][j] instanceof Wall)
			return true;
		else return false;	
	}
	public boolean isOnTarget(Box b){
		if(backgroundObjects[b.getPos().getX()][b.getPos().getY()]instanceof Target)
			return true;
		else return false;	
	}
	public boolean isATarget(int i, int j){
		if(backgroundObjects[i][j]instanceof Target)
			return true;
		else return false;	
	}
	
	//returns character
	public GameObject characterLocation(int x){
		return characterArray.get(x);	
	}
	//returns movable table
	public GameObject[][] getMovAbleTable() {
		return movAbleTable;
	}
	public GameObject getMovAbleTable(int x,int y) {
		return movAbleTable[x][y];
	}
	public void setMovAbleTable(GameObject[][] movAbleTable) {
		this.movAbleTable = movAbleTable;
	}
	public void setMovAbleTable(GameObject x) {
		this.movAbleTable[x.getPos().getX()][x.getPos().getY()] = x;
	}
	public GameObject getBackgroundObjects(int x,int y) {
		return backgroundObjects[x][y];
	}
	public void setBackgroundObjects(GameObject x) {
		this.backgroundObjects[x.getPos().getX()][x.getPos().getY()]=x;
	}
	public ArrayList<GameObject> getBoxArray() {
		return boxArray;
	}
	public void setBoxArray(ArrayList<GameObject> boxArray) {
		this.boxArray = boxArray;
	}
	public ArrayList<GameObject> getCharacterArray() {
		return characterArray;
	}
	public void setCharacterArray(ArrayList<GameObject> characterArray) {
		this.characterArray = characterArray;
	}
	public ArrayList<GameObject> getWallArray() {
		return wallArray;
	}
	public void setWallArray(ArrayList<GameObject> wallArray) {
		this.wallArray = wallArray;
	}
	public ArrayList<GameObject> getFloorArray() {
		return floorArray;
	}
	public void setFloorArray(ArrayList<GameObject> floorArray) {
		this.floorArray = floorArray;
	}
	public ArrayList<GameObject> getTargetArray() {
		return targetArray;
	}
	public void setTargetArray(ArrayList<GameObject> targetArray) {
		this.targetArray = targetArray;
	}
	public void Object(GameObject[][] backgroundObjects) {
		this.backgroundObjects = backgroundObjects;
	}
	public GameObject[][] getBackgroundObjects() {
		return backgroundObjects;
	}
	public void setBackgroundObjects(GameObject[][] backgroundObjects) {
		this.backgroundObjects = backgroundObjects;
	}
	public boolean Finish() {
		int targetnum= targetArray.size();

		if(boxontarget==targetnum)
			return true;
		return false;		
	}
	public int getBoxontarget() {
		return boxontarget;
	}
	public void setBoxontarget(int boxontarget) {
		this.boxontarget = boxontarget;
	}
	public int getStepCounter() {
		return stepCounter;
	}
	public void setStepCounter(int stepCounter) {
		this.stepCounter = stepCounter;
	}
	public IntegerProperty getTimeCount() {
		return timeCount;
	}
	public void setTimeCount(int timeCount) {
		this.timeCount.set(timeCount);
	}
	public GameObject getNearObj(Position pos, String direction){
		switch (direction) {
		case "Up":
		case "up":
			if (getMovAbleTable(pos.getX()-1, pos.getY())==null)
				return getBackgroundObjects(pos.getX()-1, pos.getY());
			else return getMovAbleTable(pos.getX()-1,pos.getY());
			
			
		case "Down":
		case "down":
			if (getMovAbleTable(pos.getX()+1, pos.getY())==null)
				return getBackgroundObjects(pos.getX()+1, pos.getY());
			else return getMovAbleTable(pos.getX()+1,pos.getY());
			
		case "Left":
		case "left":
			if (getMovAbleTable(pos.getX(), pos.getY()-1)==null)
				return getBackgroundObjects(pos.getX(), pos.getY()-1);
			else return getMovAbleTable(pos.getX(),pos.getY()-1);
			
		case "Right":
		case "right":
			if (getMovAbleTable(pos.getX(), pos.getY()+1)==null)
				return getBackgroundObjects(pos.getX(), pos.getY()+1);
			else return getMovAbleTable(pos.getX(),pos.getY()+1);
			
		default:
			return null;
			
		}
	}
	
}
	