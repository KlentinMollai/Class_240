package Character;

import java.util.Scanner;

public class CharacterDemo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		char input = sc.next().charAt(0);
		boolean test = Character.isDigit(input);
	}

}
