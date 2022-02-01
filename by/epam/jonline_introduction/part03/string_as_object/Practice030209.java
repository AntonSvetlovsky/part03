/*
 * Посчитать количество строчных (маленьких) и прописных (больших) букв
 * во введенной строке. Учитывать только английские буквы.
 */

package by.epam.jonline_introduction.part03.string_as_object;

import java.util.Scanner;

public class Practice030209 {

	public static void main(String[] args) {

		String str;
		int upperCase;
		int lowerCase;

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Введите строку(только латинские буквы)");
		System.out.print(">> ");
		str = sc.nextLine();

		upperCase = 0;
		lowerCase = 0;

		for (int i = 0; i < str.length(); i++) {
			if ((int) str.charAt(i) >= 65 && (int) str.charAt(i) <= 90) {
				upperCase++;
			}
			if ((int) str.charAt(i) >= 97 && (int) str.charAt(i) <= 122) {
				lowerCase++;
			}
		}

		System.out.println("Количество больших букв = " + upperCase);
		System.out.println("Количество маленьких букв = " + lowerCase);
	}
}
