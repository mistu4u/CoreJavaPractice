package test;

public class StringWithBackSlashN {

	public static void main(String[] args) {
		String str = "2x Hot dog with Salad\n2x Pork bao with Fries\n1x Pizza with Fries\"";
		System.out.println(str);
		if (str.toLowerCase().contains(new String("salad").toLowerCase())) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
}
