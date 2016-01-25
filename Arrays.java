package task;

public class Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Operation array = new Operation();
		
		array.filling(8);
		array.display();
		System.out.println("Left Right:");
		array.leftright();
		System.out.println();
		System.out.println("Spiral:");
		array.spiral();
		
	}

}
