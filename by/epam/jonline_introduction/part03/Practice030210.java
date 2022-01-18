/*
 * Строка X состоит из нескольких предложений, каждое из которых
 * кончается точкой, восклицательным или вопросительным знаком.
 * Определить количество предложений в строке X.
 */

package by.epam.jonline_introduction.part03;

import java.util.Scanner;

public class Practice030210 {
	public static void main(String[] args) {
		String str;
		String[] sentence;
		int q;

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Введите строку:");
		System.out.print(">> ");
		str = sc.nextLine();

		sentence = str.split("[\\.\\?\\!]");

		q = sentence.length;

		System.out.println("Количество предложений = " + q);
	}
}
