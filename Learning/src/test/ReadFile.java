package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(
				new FileReader("C:\\Users\\SUBIR.ADHIKARI\\eclipse-workspace\\pass.txt"))) {
			while (br.readLine() != null) {
				String content = br.readLine();
				System.out.println(content);
			}
		}
	}

}
