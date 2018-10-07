package test;

public class Inherit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent p =new Parent();
		p.setId(123);
		p.setName("Subir");
		System.out.println(p.getId()+" "+p.getName());
		Child c= new Child();
		c.setId(123);c.setName("Subir");
		c.setSurname("Adhikari");
//		p=c;
		System.out.println(c.getId()+" "+c.getSurname() + " "+c.getName());
	}

}
