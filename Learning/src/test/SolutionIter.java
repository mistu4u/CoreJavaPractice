package test;

import java.util.Iterator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class SolutionIter implements Iterable<Integer> {

	Reader reader;

	public SolutionIter(Reader inp) throws IOException {
		reader = inp;
	}

	public Iterator<Integer> iterator() {
		return new SolutionIterator(reader);
	}
}

class SolutionIterator implements Iterator<Integer> {
	private Reader reader;

	public SolutionIterator(Reader reader) {
		this.setReader(reader);
	}

	@Override
	public boolean hasNext() {
		boolean rflg = true;
		// TODO Auto-generated method stub
		try {
			rflg = reader.ready();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			rflg = false;
		}
		return rflg;
	}

	@Override
	public Integer next() {

		BufferedReader br  = null;
		//= new BufferedReader(new InputStreamReader(reader));
		String TextUnderProcessing;
		int toInteger = 0;
		try {
			while (br.readLine() != null) {
				TextUnderProcessing = br.readLine();
				TextUnderProcessing = TextUnderProcessing.replaceFirst("^0", "");
				try {
					toInteger = Integer.parseInt(TextUnderProcessing);
				} catch (NumberFormatException e) {
					toInteger = 0;
				}
				if ((toInteger > 1000000000) || (toInteger < -1000000000)) {
					toInteger = 0;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return toInteger;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

}
