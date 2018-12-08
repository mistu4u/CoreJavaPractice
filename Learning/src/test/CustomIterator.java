package test;

import java.util.ArrayList;
import java.util.Iterator;

public class CustomIterator<Employee> implements Iterable<Employee> {

	@Override
	public Iterator<Employee> iterator() {
		// TODO Auto-generated method stub
		return (Iterator<Employee>) new CustomIterator<Employee>();
	}

	private class CustomIteratorImpl<Employee> implements Iterator<Employee> {
		private int pos = 0;
		private ArrayList<Employee> emp;

		@Override
		public boolean hasNext() {

			if (pos < emp.size()) {
				return false;
			} else {
				return true;
			}
		}

		@Override
		public Employee next() {
			Employee em = emp.get(pos);
			pos++;
			return em;
		}

	}
}
