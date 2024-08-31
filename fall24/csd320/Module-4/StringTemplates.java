// Paul Romer, CSD320, August 29 2024, Module 4.1 Discussion Board
// String Temeplates 

public class StringTemplates {
	public static void main(String[] args) {
		String name = "Paul";
		String school = "Bellevue";
		int age = 27;
		String message = STR."My name is /{name} and I'm /{age} attending school at /{school}."; // works on java 22 preview
		
		System.out.println(message);
	}
}
