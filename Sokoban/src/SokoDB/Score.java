package SokoDB;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

@Entity(name="SokoTable")
public class Score implements Serializable{
	
	@Column(name="ID")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="Username")
	private String userName;
	@Column(name="Level")
	private String levelName;
	@Column(name="Steps")
	private int steps;
	@Column(name="Time")
	private int time;
	public Score(){	
	}
	public Score(String userName, String levelName, int steps, int time) {
		super();
		this.userName = userName;
		this.levelName=levelName;
		this.steps =steps;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName=userName;
	}
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName=levelName;
	}
	public int getSteps() {
		return steps;
	}
	public void setSteps(int steps) {
		this.steps=steps;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time=time;
	}
	
	
}
