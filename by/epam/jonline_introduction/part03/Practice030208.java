/*
 * Вводится строка слов, разделенных пробелами. Найти самое длинное
 * слово и вывести его на экран. Случай, когда самых длинных слов
 * может быть несколько, не обрабатывать.
 */

package by.epam.jonline_introduction.part03;

import java.util.Scanner;

public class Practice030208 {
	public static void main(String[] args) {
		String str;
		String[] words;
		int max;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Введите строку");
		System.out.print(">> ");
		str = sc.nextLine();

		words = str.split(" ");
		max = 0;

		for (int i = 0; i < words.length; i++) {
			if (words[i].length() > words[max].length()) {
				max = i;
			}
		}

		System.out.print("Самым длинным словом является : ");
		System.out.println(words[max]);
	}
}
