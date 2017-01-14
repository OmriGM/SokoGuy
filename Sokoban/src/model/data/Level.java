package model.data;

import java.io.Serializable;
import java.util.ArrayList;

import model.policy.MySokobanRules;
import model.policy.Policy;

public class Level implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int score=0;
	int boxontarget=0;
	Policy policy;
	
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
		policy=new MySokobanRules();
		boxArray=new ArrayList();
		characterArray=new ArrayList();
		wallArray=new ArrayList();
		floorArray=new ArrayList();
		targetArray=new ArrayList();
		
		
		
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
		if(backgroundObjects[b.getX()][b.getY()]instanceof Target)
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
	//get current score
	public int getScore(){
		return score;
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
		this.movAbleTable[x.getX()][x.getY()] = x;
	}
	public GameObject getBackgroundObjects(int x,int y) {
		return backgroundObjects[x][y];
	}
	public void setBackgroundObjects(GameObject x) {
		this.backgroundObjects[x.getX()][x.getY()]=x;
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
	public void setScore(int score) {
		this.score = score;
	}
	public void Object(GameObject[][] backgroundObjects) {
		this.backgroundObjects = backgroundObjects;
	}
	public Policy getPolicy() {
		return policy;
	}
	public void setPolicy(Policy policy) {
		this.policy = policy;
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
	
	
}
	