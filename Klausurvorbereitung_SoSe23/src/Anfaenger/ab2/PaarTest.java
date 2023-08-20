package Anfaenger.ab2;

public class PaarTest {

	public static void main(String[] args) {
		
		Paar<String> p1 = new Paar<String>("Hallo","Anton");
		System.out.println(p1.getObjectA() + " | " + p1.getObjectB());
		
		
		Paar<Integer> p2 = new Paar<Integer>(23,45);
		System.out.println(p2.getObjectA() + "  | " + p2.getObjectB());
		
		
		Paar<Double> p3 = new Paar<Double>(45.78,36.95);
		System.out.println(p3.getObjectA() + " | " + p3.getObjectB());
	}

}
