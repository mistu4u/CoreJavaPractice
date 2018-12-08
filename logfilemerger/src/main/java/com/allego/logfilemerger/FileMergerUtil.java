package com.allego.logfilemerger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;

/**
 * FileMergerUtil, this Class file contains the utility methods for merging and
 * sorting the records Created By: Subir Adhikari Authored on: 07/12/2018 Third
 * party API used: Google Guava
 */

public class FileMergerUtil {
	private final static Logger LOGGER = Logger.getLogger(FileMergerUtil.class.getName());

	// This function is responsible for sorting the file based on the timestamp part
	void sortoutputFile(String outputFile) throws FileNotFoundException {
		FileInputStream fr = new FileInputStream(new File(outputFile));
		try {
			Multimap<Date, String> myMultimap = MultimapBuilder.treeKeys().arrayListValues().build();
			BufferedReader inputReader = new BufferedReader(new InputStreamReader(fr));
			String theLine = "";
			while ((theLine = inputReader.readLine()) != null) {
				myMultimap.put(getTimeStamp(theLine), theLine);
			}
			inputReader.close();
			try {
				FileWriter writer = new FileWriter(outputFile);
				for (Date val : myMultimap.keySet()) {
					for (String value : myMultimap.get(val)) {
						writer.write(value);
						writer.write('\n');
					}
				}
				writer.close();
			} catch (Exception e) {
				LOGGER.severe("Exception happened during closure of writer object");
				e.printStackTrace();
			}
		} catch (Exception e) {
			LOGGER.severe("Exception happened during sorting the file according to the timestamp");
			e.printStackTrace();
		}

	}

	// This will validate and merge the files
	void validateFilesAndMerge(String[] listOfFiles, String outputFile) throws IOException {
		for (int i = 0; i < listOfFiles.length; i++) {
			if (new File(listOfFiles[i]).isFile()) {
				LOGGER.info("Merging file :: " + listOfFiles[i]);

				// Opening fileWriter and BufferedWriter for writing the files to the output
				// file path
				FileWriter fw = new FileWriter(outputFile, true);
				try {
					BufferedWriter bw = new BufferedWriter(fw);

					// Opening BufferedReader and FileReader to read the input files
					FileInputStream fr = new FileInputStream(new File(listOfFiles[i]));
					try {
						BufferedReader inputReader = new BufferedReader(new InputStreamReader(fr));

						// Reading input file and writing to the output file
						String theLine = "";
						while ((theLine = inputReader.readLine()) != null) {
							LOGGER.info("File name: " + listOfFiles[i] + " Line is :: " + theLine);
							bw.write(theLine);
							bw.newLine();
						}
						inputReader.close();
					} catch (IOException e) {
						LOGGER.severe("Exception happened in inputReader reader");
						e.printStackTrace();
					}
					bw.close();
				} catch (IOException e) {
					LOGGER.severe("Exception happened in bw writer");
					e.printStackTrace();
				}
			} else {
				LOGGER.warning(listOfFiles[i] + " is not a valid file, please verify file name and path");
			}
		}
	}

	// This will extract the timestamp part from the String
	private static Date getTimeStamp(String theLine) throws ParseException {
		String datepart = theLine.substring(0, 24);
		LOGGER.info("datepart is:: " + datepart);
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(datepart);
	}
}
