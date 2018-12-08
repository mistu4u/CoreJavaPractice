package test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

import test.SolutionIter;

public class SIterImpl {
	public static void main(String[] args) throws IOException {
//		Reader r =
//new BufferedReader(new StringReader( "137\\n-104\\n2 58\\n  +0\\n++3\\n+1\\n 23.9\\n2000000000\\n-0\\nfive\\n -1\\n"));
	String is= "137\\n-104\\n2 58\\n  +0\\n++3\\n+1\\n 23.9\\n2000000000\\n-0\\nfive\\n -1\\n";
	InputStream is1 = new ByteArrayInputStream(is.getBytes());
		BufferedReader br = new BufferedReader(new InputStreamReader(is1, "UTF-8"));
		for (Integer x : new SolutionIter(br)) {
			System.out.println(x);
		}
	}
}
