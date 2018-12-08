package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OsCommandExecutor {

	public static void main(String[] args) {
		String s = null;
		String osCommand = "ping www.bvvsdw.com";
		Logger logger = Logger.getLogger(OsCommandExecutor.class.getName());
		try {
			Process p = Runtime.getRuntime().exec(osCommand);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
			logger.log(Level.INFO, "The input is :: "+ stdInput);
			while ((s = stdInput.readLine()) != null) {
				logger.log(Level.INFO, s);
            }
			BufferedReader stdErr = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			logger.log(Level.INFO, "The error reason is :: "+ stdErr.toString());
			while ((s = stdErr.readLine()) != null) {
				logger.log(Level.INFO, s);
            }
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
