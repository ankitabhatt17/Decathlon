package com.decathlon.com;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.decathlon.com.model.Athlets;

public class CreateXML {

	public static void createXMLFile(Athlets listOfAthlete, String path) {
		try {

			File file = new File(path);
			JAXBContext jaxbContext = JAXBContext.newInstance(Athlets.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(listOfAthlete, file);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}

