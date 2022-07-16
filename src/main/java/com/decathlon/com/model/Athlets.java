package com.decathlon.com.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Athletes")
public class Athlets {

	@XmlElement(name = "Athlete")
	public List<Athlete> listOfAthlete= null;


	public void setListOfAthlete(List<Athlete> listOfAthlete) {
		this.listOfAthlete = listOfAthlete;
	}	
	
}
