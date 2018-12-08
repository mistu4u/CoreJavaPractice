package com.allego.logfilemerger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * LogFileMerger, this Class file is responsible for merging multiple log files
 * into a single one Created By: Subir Adhikari Authored on: 07/12/2018 Third
 * party API used: Google Guava
 */

public class LogFileMerger {
	private final static Logger LOGGER = Logger.getLogger(LogFileMerger.class.getName());

	public static void main(String[] args) throws IOException {

		// Settig logger level to INFO for debugging purposes; should be parameterized
		// in production code
		LOGGER.setLevel(Level.INFO);

		// Optional null check to avoid NPE, should be part of a utility class
		Optional<String> nullChecker;
		System.out.println(
				"Please provide the input log file names along with their paths separated by comma. Please press enter to process:: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputFiles = br.readLine();
		nullChecker = Optional.ofNullable(inputFiles).filter(s -> !s.isEmpty());
		if (!nullChecker.isPresent()) {
			LOGGER.warning(
					"The input file name contains either null or only whitespaces. Program is terminating. Please retry!");
			System.exit(0);
		}
		LOGGER.info("The input file name is :: " + inputFiles);
		System.out.println(
				"Please provide the output log file names along with its path. Please press enter to process:: ");
		String outputFile = br.readLine();
		LOGGER.info("The output file name is :: " + outputFile);
		nullChecker = Optional.ofNullable(outputFile).filter(s -> !s.isEmpty());
		if (!nullChecker.isPresent()) {
			LOGGER.warning(
					"The ouput file name contains either null or only whitespaces. Program is terminating. Please retry!");
			System.exit(0);
		}
		String[] listOfFiles = inputFiles.replaceAll("\\s+", "").split(",");

		// Initializing utility class for the operations
		FileMergerUtil fmutil = new FileMergerUtil();

		// This function will validate the existence of the files and merge them
		fmutil.validateFilesAndMerge(listOfFiles, outputFile);

		// This function will sort the newly created file according to the timestamp of
		// the records
		fmutil.sortoutputFile(outputFile);
	}

}
