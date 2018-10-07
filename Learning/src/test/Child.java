package test;

public class Child extends Parent{
	private String surname ;

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Child() {
		super();
	}

	public Child(String surname) {
		super();
		this.surname = surname;
	}
}
