package com.decathlon.com;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ReadFromCSVTest {

	static ReadFromCSV readFromCSV;

	String testPath = "src/test/resources/test.csv";
	String resultPath = "src/test/resources/result.xml";

	@BeforeAll
	static void setup() {
		readFromCSV = new ReadFromCSV();
	}

	@Test
	void testGet() {
		readFromCSV.readDecathlonResult(testPath, resultPath);

		File f = new File(resultPath);
		assertTrue(f.isFile());
		assertTrue(f.exists());
	}

}
